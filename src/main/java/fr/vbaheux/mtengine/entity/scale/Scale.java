package fr.vbaheux.mtengine.entity.scale;

import fr.vbaheux.mtengine.entity.note.Accidental;
import fr.vbaheux.mtengine.entity.note.Note;
import fr.vbaheux.mtengine.exception.InvalidValueException;
import lombok.Getter;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;

import static fr.vbaheux.mtengine.EngineConstants.NB_SEMITONES_IN_OCTAVE;

public class Scale {
  @Getter
  private final Note key;

  @Getter
  private final ScaleQuality quality;

  @Getter
  private final List<Note> notes;

  public static Scale of(@NonNull Note key, @NonNull ScaleQuality quality) {
    return new Scale(key, quality);
  }

  public Scale(@NonNull Note key, @NonNull ScaleQuality quality) {
    this.key = key;
    this.quality = quality;

    // Init list of notes
    this.notes = new LinkedList<>();
    int offset = 0;
    for (int step : quality.getSteps()) {
      notes.add(key.get(offset, Accidental.SHARP)); // TODO add accidental preferences map for ScaleQuality as well
      offset += step;
    }
    if (offset != NB_SEMITONES_IN_OCTAVE) {
      throw new InvalidValueException(ScaleQuality.class, offset, "Scale quality steps should cover an octave");
    }
  }
}
