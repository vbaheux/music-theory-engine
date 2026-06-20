package fr.vbaheux.mtengine.entity.old;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IntervalEnum {
    P1(0, "perfect unison", "diminished second"),
    m2(1, "minor second", "augmented unison"),
    M2(2, "major second", "diminished third"),
    m3(3, "minor third", "augmented second"),
    M3(4, "major third", "diminished fourth"),
    P4(5, "perfect fourth", "augmented third"),
    A4_d5(6, "diminished fifth", "augmented fourth"),
    P5(7, "perfect fifth", "diminished sixth"),
    m6(8, "minor sixth", "augmented fifth"),
    M6(9, "major sixth", "diminished seventh"),
    m7(10, "minor seventh", "augmented sixth"),
    M7(11, "major seventh", "diminished octave"),
    P8(12, "perfect octave", "augmented seventh"),
    ;

    private final int semitones;
    private final String function;
    private final String alternativeFunction;

}
