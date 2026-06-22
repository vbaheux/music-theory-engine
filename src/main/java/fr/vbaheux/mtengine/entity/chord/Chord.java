package fr.vbaheux.mtengine.entity.chord;

import fr.vbaheux.mtengine.entity.interval.Interval;
import fr.vbaheux.mtengine.entity.note.Accidental;
import fr.vbaheux.mtengine.entity.note.Note;
import fr.vbaheux.mtengine.exception.InvalidValueException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Chord {

  private final Note root;

  private final ChordQuality quality;

  private final Inversion inversion;

  private final List<Note> notes;

  public static Chord of(Note root, ChordQuality quality, Inversion inversion) {
    return new Chord(root, quality, inversion, Accidental.SHARP); // Arbitrary default preferred accidental.
  }

  public static Chord of(Note root, ChordQuality quality, Inversion inversion, Accidental preferredAccidental) {
    return new Chord(root, quality, inversion, preferredAccidental);
  }

  public Chord(Note root, ChordQuality quality, Inversion inversion, Accidental preferredAccidental) {
    if (inversion == Inversion.THIRD && quality.getIntervals().size() < 4) {
      throw new InvalidValueException(Chord.class, inversion, "cannot have a 3rd inversion for a chord with less than 4 notes.");
    }

    this.root = root;
    this.quality = quality;
    this.inversion = inversion;

    // Put intervals in the right order
    List<Interval> intervals = new ArrayList<>(quality.getIntervals());

    for (int i = 0; i < inversion.ordinal(); i++) {
      Interval toInvert = intervals.removeFirst();
      intervals.add(toInvert);
    }
    // Convert to the notes of the chord
    this.notes = intervals.stream().map(interval -> root.get(interval, preferredAccidental)).toList();
  }

}
