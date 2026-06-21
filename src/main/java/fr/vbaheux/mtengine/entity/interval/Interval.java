package fr.vbaheux.mtengine.entity.interval;

import fr.vbaheux.mtengine.exception.InvalidValueException;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

import static fr.vbaheux.mtengine.EngineConstants.NB_STEPS_DIATONIC_SCALE;

public record Interval(@NonNull IntervalQuality quality, int degree) {
  /**
   * List of perfect degrees (can be perfect, augmented or diminished, but can't be major or minor).
   */
  private static final List<Integer> perfectDegrees = List.of(1, 4, 5);
  /**
   * Offsets in semitones for each degree (perfect or major), on one octave.
   */
  private static final Map<Integer, Integer> offsetsByDegree = Map.of(
      1, 0,
      2, 2,
      3, 4,
      4, 5,
      5, 7,
      6, 9,
      7, 11
  );

  public static Interval of(IntervalQuality quality, int degree) {
    return new Interval(quality, degree);
  }

  public Interval {
    validateConstructorArgs(quality, degree);
  }

  /**
   * Converts the interval to semitones.
   *
   * @return the number of semitones represented by the interval.
   */
  public int toSemitones() {
    return switch (quality) {
      // The map contains the steps as semitones for the perfect or major interval of each degree.
      case PERFECT, MAJOR -> offsetsByDegree.get(getSimpleIntervalDegree());
      // For minor intervals, remove 1 from offset.
      case MINOR -> offsetsByDegree.get(getSimpleIntervalDegree()) - 1;
      // For augmented intervals, add 1 to offset.
      case AUGMENTED -> offsetsByDegree.get(getSimpleIntervalDegree()) + 1;
      /*
      For diminished intervals:
      - If the degree is allowed to be perfect (1, 4 or 5): remove 1 semitone from offset.
      - Otherwise, the diminished interval is below the minor interval: remove 2 semitones.
       */
      case DIMINISHED -> {
        int simpleIntervalDegree = getSimpleIntervalDegree();
        yield perfectDegrees.contains(simpleIntervalDegree)
            ? offsetsByDegree.get(simpleIntervalDegree) - 1
            : offsetsByDegree.get(simpleIntervalDegree) - 2;
      }
    };
  }

  @Override
  @NonNull
  public String toString() {
    return quality.toString() + degree;
  }

  /**
   * Gets the degree of the simple interval equivalent to the current interval<br/>
   * (simple - i.e. spanning <= 1 octave, or compound).
   *
   * @return the equivalent simple interval degree.
   */
  private int getSimpleIntervalDegree() {
    return degree % (NB_STEPS_DIATONIC_SCALE + 1);
  }

  private static void validateConstructorArgs(IntervalQuality quality, int degree) {
    if (degree <= 0 || degree > 15) {
      throw new InvalidValueException(Interval.class, degree, "degree must be between 1 and 15");
    }
    switch (quality) {
      case PERFECT -> {
        if (!perfectDegrees.contains(degree % NB_STEPS_DIATONIC_SCALE)) {
          throw new InvalidValueException(Interval.class, quality.toString() + degree, "cannot have a perfect quality.");
        }
      }
      case MINOR, MAJOR -> {
        if (perfectDegrees.contains(degree % NB_STEPS_DIATONIC_SCALE)) {
          throw new InvalidValueException(Interval.class, quality.toString() + degree, "cannot have a minor or major quality.");
        }
      }
      case DIMINISHED -> {
        if (degree == 1) {
          throw new InvalidValueException(Interval.class, quality.toString() + degree, "unison cannot be diminished.");
        }
      }
      default -> {
        // Do nothing
      }
    }
  }
}
