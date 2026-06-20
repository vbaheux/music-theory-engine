package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.entity.note.Note;
import org.jspecify.annotations.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NoteWriteConverter implements Converter<Note, String> {
  @Override
  public String convert(@NonNull Note note) {
    return note.toString();
  }
}
