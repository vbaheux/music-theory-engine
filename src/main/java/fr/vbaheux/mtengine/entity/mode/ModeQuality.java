package fr.vbaheux.mtengine.entity.mode;

import fr.vbaheux.mtengine.entity.note.Accidental;
import fr.vbaheux.mtengine.entity.note.Letter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

import static fr.vbaheux.mtengine.entity.note.Accidental.*;
import static fr.vbaheux.mtengine.entity.note.Letter.*;

@AllArgsConstructor
public enum ModeQuality {
  IONIAN(new int[]{2, 2, 1, 2, 2, 2, 1},
      Map.of(C, NATURAL, D, SHARP, E, SHARP, F, FLAT, G, SHARP, A, SHARP, B, SHARP)),
  DORIAN(new int[]{2, 1, 2, 2, 2, 1, 2},
      Map.of(C, FLAT, D, NATURAL, E, SHARP, F, FLAT, G, FLAT, A, SHARP, B, SHARP)),
  PHRYGIAN(new int[]{1, 2, 2, 2, 1, 2, 2},
      Map.of(C, FLAT, D, FLAT, E, NATURAL, F, FLAT, G, FLAT, A, FLAT, B, SHARP)),
  LYDIAN(new int[]{2, 2, 2, 1, 2, 2, 1},
      Map.of(C, SHARP, D, SHARP, E, SHARP, F, NATURAL, G, SHARP, A, SHARP, B, SHARP)),
  MIXOLYDIAN(new int[]{2, 2, 1, 2, 2, 1, 2},
      Map.of(C, FLAT, D, SHARP, E, SHARP, F, FLAT, G, NATURAL, A, SHARP, B, SHARP)),
  AEOLIAN(new int[]{2, 1, 2, 2, 1, 2, 2},
      Map.of(C, FLAT, D, FLAT, E, SHARP, F, FLAT, G, FLAT, A, NATURAL, B, SHARP)),
  LOCRIAN(new int[]{1, 2, 2, 1, 2, 2, 2},
      Map.of(C, FLAT, D, FLAT, E, FLAT, F, FLAT, G, FLAT, A, FLAT, B, NATURAL));

  /**
   * List of steps, in semitones, between each note of the mode.
   */
  @Getter
  private final int[] steps;

  /**
   * Preference for root keys that don't already have an accidental (C, D, E, F, G, A & B).
   */
  private final Map<Letter, Accidental> preferredAccidentals;

  public Accidental getPreferredAccidental(Letter letter) {
    return preferredAccidentals.get(letter);
  }
}
