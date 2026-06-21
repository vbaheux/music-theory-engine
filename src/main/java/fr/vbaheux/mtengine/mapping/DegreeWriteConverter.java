package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.dto.DegreeDto;
import fr.vbaheux.mtengine.entity.mode.Degree;
import fr.vbaheux.mtengine.entity.note.Note;
import org.jspecify.annotations.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface DegreeWriteConverter extends Converter<Degree, DegreeDto> {
  DegreeDto convert(@Nullable Degree degree);

  default String mapNoteToString(Note note) {
    return note.toString();
  }
}
