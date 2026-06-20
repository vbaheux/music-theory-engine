package fr.vbaheux.mtengine.entity.note;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Accidental {
  DOUBLE_FLAT(-2, "bb"),
  FLAT(-1, "b"),
  NATURAL(0, ""),
  SHARP(1, "#"),
  DOUBLE_SHARP(2, "##");

  private final int offset;
  private final String symbol;

  @Override
  public String toString() {
    return symbol;
  }
}
