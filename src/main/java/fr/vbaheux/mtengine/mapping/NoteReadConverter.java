package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.entity.note.Accidental;
import fr.vbaheux.mtengine.entity.note.Letter;
import fr.vbaheux.mtengine.entity.note.Note;
import org.jspecify.annotations.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class NoteReadConverter implements Converter<String, Note> {
  private static final Pattern pattern = Pattern.compile("([a-gA-G])([b#]?)");

  @Override
  public Note convert(@NonNull String source) {
    Matcher matcher = pattern.matcher(source);
    if (matcher.find()) {
      Letter letter = Letter.valueOf(matcher.group(0).toUpperCase());
      Accidental accidental = switch (matcher.group(1)) {
        case "b" -> Accidental.FLAT;
        case "#" -> Accidental.SHARP;
        case null, default -> Accidental.NATURAL;
      };
      return Note.of(letter, accidental);
    } else
      throw new IllegalArgumentException("The given string is not a valid note");
  }
}
