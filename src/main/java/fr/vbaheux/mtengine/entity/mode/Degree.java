package fr.vbaheux.mtengine.entity.mode;

import fr.vbaheux.mtengine.entity.chord.Chord;
import fr.vbaheux.mtengine.entity.note.Note;
import lombok.NonNull;

public record Degree(@NonNull Note note, @NonNull Chord chord) {
  public static Degree of(@NonNull Note note, @NonNull Chord chord) {
    return new Degree(note, chord);
  }
}
