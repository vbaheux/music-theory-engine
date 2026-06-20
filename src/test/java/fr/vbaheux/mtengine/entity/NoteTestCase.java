package fr.vbaheux.mtengine.entity;

import fr.vbaheux.mtengine.entity.old.IntervalEnum;
import fr.vbaheux.mtengine.entity.old.NoteEnum;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class NoteTestCase {
    @ParameterizedTest
    @CsvSource(value = {
            "C,m2,C_SHARP",
            "C,P5,G",
            "B,P5,F_SHARP"
    })
    void givenNoteAndInterval_WhenAddInterval_ThenCorrectResult(NoteEnum note, IntervalEnum interval, NoteEnum expected) {
        NoteEnum result = note.addInterval(interval);
        assertEquals(expected, result);
    }
}
