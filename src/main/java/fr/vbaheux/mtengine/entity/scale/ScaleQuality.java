package fr.vbaheux.mtengine.entity.scale;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScaleQuality {
  MAJOR(new int[]{2, 2, 1, 2, 2, 2, 1}),
  NATURAL_MINOR(new int[]{2, 1, 2, 2, 1, 2, 2}),
  HARMONIC_MINOR(new int[]{2, 1, 2, 2, 1, 3, 1}),
  MELODIC_MINOR(new int[]{2, 1, 2, 2, 2, 2, 1}),
  PENTATONIC_MINOR(new int[]{3, 2, 2, 3, 2});

  private final int[] steps;

  public int countSteps() {
    return steps.length;
  }

}
