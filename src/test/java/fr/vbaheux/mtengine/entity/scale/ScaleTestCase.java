package fr.vbaheux.mtengine.entity.scale;

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
public class ScaleTestCase {
  private static Stream<Arguments> provideNewScale() {
    return Stream.of(
        Arguments.argumentSet(
            "C major scale",
            Note.of(Letter.C),
            ScaleQuality.MAJOR,
            List.of(Note.of(Letter.C), Note.of(Letter.D), Note.of(Letter.E), Note.of(Letter.F), Note.of(Letter.G), Note.of(Letter.A), Note.of(Letter.B))
        )
        // TODO add other test cases
    );
  }

  @ParameterizedTest
  @MethodSource("provideNewScale")
  void givenKeyAndQuality_WhenNewScale_ThenCorrectNotesInstantiation(Note key, ScaleQuality quality, List<Note> expectedNotes) {
    Scale result = new Scale(key, quality);
    assertEquals(expectedNotes, result.getNotes());
  }

}
