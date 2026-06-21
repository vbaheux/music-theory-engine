package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.dto.ModeDto;
import fr.vbaheux.mtengine.entity.mode.Mode;
import fr.vbaheux.mtengine.entity.note.Note;
import fr.vbaheux.mtengine.entity.scale.Scale;
import org.jspecify.annotations.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModeWriteConverter extends Converter<Mode, ModeDto> {
  ModeDto convert(@Nullable Scale scale);

  // TODO mutualize note & note list mapping in separate converter
  default String mapNoteToNote(Note note) {
    return note.toString();
  }

  default List<String> mapNotesToNotes(List<Note> notes) {
    return notes.stream().map(Note::toString).toList();
  }
}
