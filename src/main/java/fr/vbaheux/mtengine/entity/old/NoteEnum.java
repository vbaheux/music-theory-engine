package fr.vbaheux.mtengine.entity.old;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoteEnum {
    C(0, "C"),
    C_SHARP(1, "C#"),
    D(2, "D"),
    D_SHARP(3, "D#"),
    E(4, "E"),
    F(5, "F"),
    F_SHARP(6, "F#"),
    G(7, "G"),
    G_SHARP(8, "G#"),
    A(9, "A"),
    A_SHARP(10, "A#"),
    B(11, "B");

    private final int index;
    private final String displayName;

    public NoteEnum addInterval(IntervalEnum interval) {
        return getFromIndex(this.index + interval.getSemitones());
    }

    private static NoteEnum getFromIndex(int index) {
        return NoteEnum.values()[index % 12];
    }
}
