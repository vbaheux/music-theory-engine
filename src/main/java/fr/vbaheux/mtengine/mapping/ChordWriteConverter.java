package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.dto.ChordDto;
import fr.vbaheux.mtengine.entity.chord.Chord;
import fr.vbaheux.mtengine.entity.note.Note;
import jakarta.annotation.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChordWriteConverter extends Converter<Chord, ChordDto> {
  ChordDto convert(@Nullable Chord chord);

  default String mapNoteToNote(Note note) {
    return note.toString();
  }

  default List<String> mapNotesToNotes(List<Note> notes) {
    return notes.stream().map(Note::toString).toList();
  }
}
