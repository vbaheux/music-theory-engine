package fr.vbaheux.mtengine.entity.note;

import fr.vbaheux.mtengine.entity.interval.Interval;
import fr.vbaheux.mtengine.entity.interval.IntervalQuality;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class NoteTestCase {

  private static Stream<Arguments> provideGetWithInterval() {
    return Stream.of(
        Arguments.of(Note.of(Letter.C), Interval.of(IntervalQuality.PERFECT, 5), Note.of(Letter.G)),
        Arguments.of(Note.of(Letter.C, Accidental.SHARP), Interval.of(IntervalQuality.PERFECT, 5), Note.of(Letter.G, Accidental.SHARP)),
        Arguments.of(Note.of(Letter.D, Accidental.FLAT), Interval.of(IntervalQuality.PERFECT, 5), Note.of(Letter.A, Accidental.FLAT)),
        Arguments.of(Note.of(Letter.A), Interval.of(IntervalQuality.PERFECT, 5), Note.of(Letter.E)),
        Arguments.of(Note.of(Letter.B, Accidental.FLAT), Interval.of(IntervalQuality.PERFECT, 5), Note.of(Letter.F)),
        Arguments.of(Note.of(Letter.A, Accidental.FLAT), Interval.of(IntervalQuality.MAJOR, 3), Note.of(Letter.C)),
        Arguments.of(Note.of(Letter.A, Accidental.NATURAL), Interval.of(IntervalQuality.MAJOR, 7), Note.of(Letter.G, Accidental.SHARP))
    );
  }

  @ParameterizedTest
  @MethodSource("provideGetWithInterval")
  void givenNoteAndInterval_WhenGetWithInterval_ThenCorrectResult(Note note, Interval interval, Note expected) {
    Note result = note.get(interval, Accidental.SHARP); // TODO adapt unit test to cover preferred accidentals
    assertEquals(expected, result);
  }

  private static Stream<Arguments> provideGetWithOffset() {
    return Stream.of(
        Arguments.of(Note.of(Letter.C), 7, Note.of(Letter.G)),
        Arguments.of(Note.of(Letter.C, Accidental.SHARP), 7, Note.of(Letter.G, Accidental.SHARP)),
        Arguments.of(Note.of(Letter.D, Accidental.FLAT), 7, Note.of(Letter.A, Accidental.FLAT)),
        Arguments.of(Note.of(Letter.A), 7, Note.of(Letter.E)),
        Arguments.of(Note.of(Letter.B, Accidental.FLAT), 7, Note.of(Letter.F)),
        Arguments.of(Note.of(Letter.A, Accidental.FLAT), 4, Note.of(Letter.C))
    );
  }

  @ParameterizedTest
  @MethodSource("provideGetWithOffset")
  void givenNoteAndInterval_WhenGetWithOffset_ThenCorrectResult(Note note, int offset, Note expected) {
    Note result = note.get(offset, Accidental.SHARP); // TODO adapt unit test to cover preferred accidentals
    assertEquals(expected, result);
  }
}
