package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.entity.note.Note;
import org.jspecify.annotations.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public abstract class NoteWriteConverter implements Converter<Note, String> {
  public String convert(@Nullable Note note) {
    if (note == null) return null;
    return note.toString();
  }
}
