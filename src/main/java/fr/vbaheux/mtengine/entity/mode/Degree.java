package fr.vbaheux.mtengine.entity.mode;

import fr.vbaheux.mtengine.entity.chord.Chord;
import fr.vbaheux.mtengine.entity.note.Note;
import lombok.NonNull;

public record Degree(int order, @NonNull Note note, @NonNull Chord chord) {
  public static Degree of(int order, @NonNull Note note, @NonNull Chord chord) {
    return new Degree(order, note, chord);
  }
}
