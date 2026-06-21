package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.dto.ChordDto;
import fr.vbaheux.mtengine.entity.chord.Chord;
import jakarta.annotation.Nullable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = {NoteWriteConverter.class})
public interface ChordWriteConverter extends Converter<Chord, ChordDto> {

  @Mapping(target = "name", source = "chord", qualifiedByName = "MapChordName")
  ChordDto convert(@Nullable Chord chord);

  @Named("MapChordName")
  static String mapChordName(Chord chord) {
    return chord.getRoot().toString() + chord.getQuality().getShortName();
  }
}
