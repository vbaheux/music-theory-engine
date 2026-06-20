package fr.vbaheux.mtengine.entity.note;

import fr.vbaheux.mtengine.exception.InvalidValueException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Letter {
  C(0),
  D(1),
  E(2),
  F(3),
  G(4),
  A(5),
  B(6);

  private final int index;

  public static int count() {
    return values().length;
  }

  /**
   * Gets a new letter given the degree from the current letter.
   *
   * @param degree the degree to apply to the current letter.<br/>
   *               (e.g. 1st degree of C = C, 5th degree of C = G)
   * @return the wanted letter with the applied degree offset.
   */
  public Letter offset(int degree) {
    int offset = (index + degree - 1) % count();
    return getByIndex(offset);
  }

  private static Letter getByIndex(int index) {
    for (Letter letter : values()) {
      if (letter.index == index) {
        return letter;
      }
    }
    throw new InvalidValueException(Letter.class, index, "invalid index for letter.");
  }
}
