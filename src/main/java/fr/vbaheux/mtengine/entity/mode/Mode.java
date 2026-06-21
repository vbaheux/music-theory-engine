package fr.vbaheux.mtengine.entity.mode;

import fr.vbaheux.mtengine.entity.chord.Chord;
import fr.vbaheux.mtengine.entity.chord.ChordQuality;
import fr.vbaheux.mtengine.entity.chord.Inversion;
import fr.vbaheux.mtengine.entity.note.Note;
import fr.vbaheux.mtengine.exception.InvalidValueException;
import lombok.Getter;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;

import static fr.vbaheux.mtengine.EngineConstants.NB_SEMITONES_IN_OCTAVE;

/**
 * Modes of the major scale.<br/>
 * Similar to {@link fr.vbaheux.mtengine.entity.scale.Scale}, but modes are inversions of a specific scale.<br/>
 * Here, we cover major (ionian), natural minor (aeolian) & all other modes of the major scale.<br/>
 * TODO adapt this class to allow modes from different
 */
public class Mode {
  /**
   * Order of chords corresponding to each degree of the IONIAN mode.<br/>
   * For each subsequent mode, start with an offset of +1, and loop back at the start.
   */
  private static final List<ChordQuality> chordQualities = List.of(
      ChordQuality.MAJOR_SEVENTH, ChordQuality.MINOR_SEVENTH, ChordQuality.MINOR_SEVENTH, ChordQuality.MAJOR_SEVENTH,
      ChordQuality.DOMINANT_SEVENTH, ChordQuality.MINOR_SEVENTH, ChordQuality.HALF_DIMINISHED_SEVENTH
  );


  @Getter
  private final Note key;

  @Getter
  private final ModeQuality quality;

  @Getter
  private final List<Degree> degrees;

  public static Mode of(@NonNull Note key, @NonNull ModeQuality quality) {
    return new Mode(key, quality);
  }

  public Mode(@NonNull Note key, @NonNull ModeQuality quality) {
    this.key = key;
    this.quality = quality;
    this.degrees = buildDegrees(key, quality);
  }

  private static List<Degree> buildDegrees(Note key, ModeQuality quality) {
    List<Degree> degrees = new LinkedList<>();
    // Counter to determine which degree we're currently at
    int currentDegree = 0;
    // Offset from key, in semitones, to find the current note for each degree
    int noteOffsetFromKey = 0;

    for (int step : quality.getSteps()) {
      // Find the current note
      Note currentNote = key.get(noteOffsetFromKey);
      // Find the chord's quality in the list - from the mode's quality and the current degree
      ChordQuality chordQuality = chordQualities.get((currentDegree + quality.ordinal()) % chordQualities.size());
      // Build the associated chord
      Chord currentChord = Chord.of(currentNote, chordQuality, Inversion.ROOT);
      // Add the note & chord to the list of degrees
      degrees.add(Degree.of(currentDegree + 1, currentNote, currentChord));
      // Prepare for next loop
      currentDegree++;
      noteOffsetFromKey += step;
    }

    // At the end of the loop, we should have covered an octave - if not, throw an exception.
    if (noteOffsetFromKey != NB_SEMITONES_IN_OCTAVE) {
      throw new InvalidValueException(ModeQuality.class, noteOffsetFromKey, "Mode quality steps should cover an octave");
    }

    return degrees;
  }
}
