package fr.vbaheux.mtengine.entity.mode;

import fr.vbaheux.mtengine.entity.note.Letter;
import fr.vbaheux.mtengine.entity.note.Note;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ModeTestCase {
  private static Stream<Arguments> provideNewMode() {
    return Stream.of(
        Arguments.argumentSet(
            "D dorian",
            Note.of(Letter.D),
            ModeQuality.DORIAN,
            List.of(Note.of(Letter.D), Note.of(Letter.E), Note.of(Letter.F), Note.of(Letter.G), Note.of(Letter.A), Note.of(Letter.B), Note.of(Letter.C))
        )
        // TODO add other test cases
    );
  }

  @ParameterizedTest
  @MethodSource("provideNewMode")
  void givenKeyAndQuality_WhenNewMode_ThenCorrectNotesInstantiation(Note key, ModeQuality quality, List<Note> expectedNotes) {
    // TODO check output chords as well
    Mode result = Mode.of(key, quality);
    assertEquals(expectedNotes, result.getDegrees().stream().map(degree -> degree.note()).toList());
  }
}
