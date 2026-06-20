package fr.vbaheux.mtengine.entity.note;

import fr.vbaheux.mtengine.exception.InvalidValueException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Letter {
  C(0),
  D(2),
  E(4),
  F(5),
  G(7),
  A(9),
  B(11);

  /**
   * Offset from C in semitones.
   */
  private final int offset;

  /**
   * Gets a new letter given the offset (in semitones) from C natural.
   *
   * @param offset the offest to find.
   * @return the letter with this offset if found, null otherwise.
   */
  public static Letter getByOffsetFromCNatural(int offset) {
    for (Letter letter : Letter.values()) {
      if (letter.getOffset() == offset) {
        return letter;
      }
    }
    return null;
  }

  /**
   * Gets a new letter given the degree from the current letter.
   *
   * @param degree the degree to apply to the current letter.<br/>
   *               (e.g. 1st degree of C = C, 5th degree of C = G)
   * @return the wanted letter with the applied degree ordinal offset.
   */
  public Letter add(int degree) {
    int newIndex = (ordinal() + degree - 1) % count();
    return getByOrdinal(newIndex);
  }

  private static Letter getByOrdinal(int ordinal) {
    for (Letter letter : values()) {
      if (letter.ordinal() == ordinal) {
        return letter;
      }
    }
    throw new InvalidValueException(Letter.class, ordinal, "invalid ordinal for letter.");
  }

  private static int count() {
    return values().length;
  }
}
