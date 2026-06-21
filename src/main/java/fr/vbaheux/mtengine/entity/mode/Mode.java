package fr.vbaheux.mtengine.entity.mode;

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
  @Getter
  private final Note key;

  @Getter
  private final ModeQuality quality;

  @Getter
  private final List<Note> notes;

  public static Mode of(@NonNull Note key, @NonNull ModeQuality quality) {
    return new Mode(key, quality);
  }

  public Mode(@NonNull Note key, @NonNull ModeQuality quality) {
    this.key = key;
    this.quality = quality;

    // TODO mutualize with Scale logic
    // Init list of notes
    this.notes = new LinkedList<>();
    int offset = 0;
    for (int step : quality.getSteps()) {
      notes.add(key.get(offset));
      offset += step;
    }
    if (offset != NB_SEMITONES_IN_OCTAVE) {
      throw new InvalidValueException(ModeQuality.class, offset, "Mode quality steps should cover an octave");
    }
  }
}
