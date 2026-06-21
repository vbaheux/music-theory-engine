package fr.vbaheux.mtengine.entity.chord;

import fr.vbaheux.mtengine.entity.note.Accidental;
import fr.vbaheux.mtengine.entity.note.Letter;
import fr.vbaheux.mtengine.entity.note.Note;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ChordTestCase {
  private static Stream<Arguments> provideNewChord() {
    return Stream.of(
        Arguments.argumentSet("C major (root)",
            Note.of(Letter.C), ChordQuality.MAJOR, Inversion.ROOT,
            List.of(Note.of(Letter.C), Note.of(Letter.E), Note.of(Letter.G))),
        Arguments.argumentSet("Amaj7 (root)",
            Note.of(Letter.A), ChordQuality.MAJOR_SEVENTH, Inversion.ROOT,
            List.of(Note.of(Letter.A), Note.of(Letter.C, Accidental.SHARP), Note.of(Letter.E), Note.of(Letter.G, Accidental.SHARP))),
        Arguments.argumentSet("Amaj7 (1st)",
            Note.of(Letter.A), ChordQuality.MAJOR_SEVENTH, Inversion.FIRST,
            List.of(Note.of(Letter.C, Accidental.SHARP), Note.of(Letter.E), Note.of(Letter.G, Accidental.SHARP), Note.of(Letter.A)))
    );
  }

  @ParameterizedTest
  @MethodSource("provideNewChord")
  void givenNoteQualityAndInversion_WhenNewChord_ThenCorrectResult(Note root, ChordQuality quality, Inversion inversion, List<Note> expected) {
    Chord chord = assertDoesNotThrow(() -> new Chord(root, quality, inversion));
    assertEquals(expected, chord.getNotes());
  }
}
