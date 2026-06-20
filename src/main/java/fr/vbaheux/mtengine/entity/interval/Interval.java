package fr.vbaheux.mtengine.entity.interval;

import fr.vbaheux.mtengine.exception.InvalidValueException;
import lombok.NonNull;

import java.util.List;

public record Interval(@NonNull IntervalQuality quality, int degree) {
  private static final List<Integer> perfectDegrees = List.of(1, 4, 5);

  public static Interval of(IntervalQuality quality, int degree) {
    return new Interval(quality, degree);
  }

  public Interval {
    validateConstructorArgs(quality, degree);
  }

  @Override
  @NonNull
  public String toString() {
    return quality.toString() + degree;
  }

  private static void validateConstructorArgs(IntervalQuality quality, int degree) {
    if (degree <= 0 || degree > 13) {
      throw new InvalidValueException(Interval.class, degree, "degree must be between 1 and 13");
    }
    switch (quality) {
      case PERFECT -> {
        if (!perfectDegrees.contains(degree)) {
          throw new InvalidValueException(Interval.class, quality.toString() + degree,
              "cannot have a perfect quality. authorized values: " + perfectDegrees);
        }
      }
      case MINOR, MAJOR -> {
        if (perfectDegrees.contains(degree)) {
          throw new InvalidValueException(Interval.class, quality.toString() + degree,
              "cannot have a minor or major quality. Unauthorized values: " + perfectDegrees);
        }
      }
      case DIMINISHED -> {
        if (degree == 1) {
          throw new InvalidValueException(Interval.class, quality.toString() + degree,
              "unison cannot be diminished.");
        }
      }
      default -> {
        // Do nothing
      }
    }
  }
}
