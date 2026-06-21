package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.dto.DegreeDto;
import fr.vbaheux.mtengine.entity.mode.Degree;
import org.jspecify.annotations.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = {NoteWriteConverter.class, ChordWriteConverter.class})
public interface DegreeWriteConverter extends Converter<Degree, DegreeDto> {
  DegreeDto convert(@Nullable Degree degree);
}
