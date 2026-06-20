package fr.vbaheux.mtengine.entity.interval;

import fr.vbaheux.mtengine.exception.InvalidValueException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IntervalTestCase {
  @ParameterizedTest
  @CsvSource(value = {
      "PERFECT,1", "MINOR,2", "MAJOR,2",
      "MINOR,3", "MAJOR,3", "PERFECT,4",
      "PERFECT,5", "MINOR,6", "MAJOR,6",
      "MINOR,7", "MAJOR,7"
  })
  void shouldBeValid(IntervalQuality intervalQuality, int degree) {
    Interval interval = assertDoesNotThrow(() -> new Interval(intervalQuality, degree));
    assertEquals(intervalQuality.toString() + degree, interval.toString());
  }

  @ParameterizedTest
  @CsvSource(value = {
      "MINOR,1", "MAJOR,1", "PERFECT,2",
      "PERFECT,3", "MINOR,4", "MAJOR,4",
      "MINOR,5", "MAJOR,5", "PERFECT,6",
      "PERFECT,7"
  })
  void shouldBeInvalid(IntervalQuality intervalQuality, int degree) {
    assertThrows(InvalidValueException.class, () -> new Interval(intervalQuality, degree));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13})
  void shouldBeValidForDiminishedQuality(int degree) {
    Interval interval = assertDoesNotThrow(() -> new Interval(IntervalQuality.DIMINISHED, degree));
    assertEquals(IntervalQuality.DIMINISHED.toString() + degree, interval.toString());
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13})
  void shouldBeValidForAugmentedQuality(int degree) {
    Interval interval = assertDoesNotThrow(() -> new Interval(IntervalQuality.AUGMENTED, degree));
    assertEquals(IntervalQuality.AUGMENTED.toString() + degree, interval.toString());
  }
}
