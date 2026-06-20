package fr.vbaheux.mtengine.entity.interval;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IntervalQualityTestCase {

  @ParameterizedTest
  @EnumSource(IntervalQuality.class)
  public void isValidIntervalQuality(IntervalQuality intervalQuality) {
    assertEquals(intervalQuality.getIdentifier(), intervalQuality.toString());
  }
}
