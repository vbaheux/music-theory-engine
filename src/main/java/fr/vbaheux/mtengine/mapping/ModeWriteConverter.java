package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.dto.ModeDto;
import fr.vbaheux.mtengine.entity.mode.Mode;
import org.jspecify.annotations.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = {NoteWriteConverter.class, DegreeWriteConverter.class})
public interface ModeWriteConverter extends Converter<Mode, ModeDto> {
  ModeDto convert(@Nullable Mode mode);
}
