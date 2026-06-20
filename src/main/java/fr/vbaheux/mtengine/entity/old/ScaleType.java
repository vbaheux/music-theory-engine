package fr.vbaheux.mtengine.entity.old;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;

import static fr.vbaheux.mtengine.entity.old.IntervalEnum.*;

@Getter
@AllArgsConstructor
public enum ScaleType {
    MAJOR("major", "ionian",
            EnumSet.of(P1, M2, M3, P4, P5, M6, M7, P8)),
    DORIAN("dorian", null,
            EnumSet.of(P1, M2, m3, P4, P5, M6, m7, P8)),
    PHRYGIAN("phrygian", null,
            EnumSet.of(P1, m2, m3, P4, P5, m6, m7, P8)),
    LYDIAN("lydian", null,
            EnumSet.of(P1, M2, M3, A4_d5, P5, M6, M7, P8)),
    MIXOLYDIAN("mixolydian", null,
            EnumSet.of(P1, M2, M3, P4, P5, M6, m7, P8)),
    MINOR_NATURAL("minor", "eolian",
            EnumSet.of(P1, M2, m3, P4, P5, m6, m7, P8)),
    LOCRIAN("locrian", null,
            EnumSet.of(P1, m2, m3, P4, A4_d5, m6, m7, P8)),
    MINOR_HARMONIC("harmonic minor", null,
            EnumSet.of(P1, M2, m3, P4, P5, m6, M7, P8)),
    MINOR_MELODIC("melodic minor", null,
            EnumSet.of(P1, M2, m3, P4, P5, M6, M7, P8));

    private final String mainName;
    @Nullable
    private final String alternativeName;
    private final EnumSet<IntervalEnum> intervals;
}
