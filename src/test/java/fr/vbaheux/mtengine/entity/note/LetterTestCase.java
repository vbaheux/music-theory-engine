package fr.vbaheux.mtengine.entity.note;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LetterTestCase {
  @ParameterizedTest
  @CsvSource(value = {
      "C,5,G",
      "C,8,C",
      "C,9,D",
      "D,3,F",
      "A,5,E",
      "B,5,F"
  })
  void givenLetterAndDegree_WhenAdd_ThenCorrectResult(Letter letter, int degree, Letter expected) {
    Letter result = assertDoesNotThrow(() -> letter.add(degree));
    assertEquals(expected, result);
  }
}
