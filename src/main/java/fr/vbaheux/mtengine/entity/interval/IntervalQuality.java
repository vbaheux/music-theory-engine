package fr.vbaheux.mtengine.entity.interval;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IntervalQuality {
  PERFECT("P"),
  MINOR("m"),
  MAJOR("M"),
  DIMINISHED("d"),
  AUGMENTED("A");

  private final String identifier;

  @Override
  public String toString() {
    return identifier;
  }

}
