package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.entity.note.Accidental;
import fr.vbaheux.mtengine.entity.note.Letter;
import fr.vbaheux.mtengine.entity.note.Note;
import org.jspecify.annotations.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mapper(componentModel = "spring")
public abstract class NoteReadConverter implements Converter<String, Note> {
  private static final Pattern pattern = Pattern.compile("^([a-gA-G])([b#]?)$");

  public Note convert(@Nullable String source) {
    if (source == null) {
      return null;
    }
    Matcher matcher = pattern.matcher(source);
    if (matcher.find()) {
      Letter letter = Letter.valueOf(matcher.group(1).toUpperCase());
      Accidental accidental = switch (matcher.group(2)) {
        case "b" -> Accidental.FLAT;
        case "#" -> Accidental.SHARP;
        case null, default -> Accidental.NATURAL;
      };
      return Note.of(letter, accidental);
    } else
      throw new IllegalArgumentException("The given string is not a valid note");
  }
}
