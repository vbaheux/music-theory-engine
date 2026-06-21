package fr.vbaheux.mtengine.dto;

import java.util.List;

public record ChordDto(
    String name,
    String root,
    String quality,
    String inversion,
    List<String> notes
) {
}
