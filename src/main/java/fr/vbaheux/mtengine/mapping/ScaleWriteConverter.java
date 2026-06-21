package fr.vbaheux.mtengine.mapping;

import fr.vbaheux.mtengine.dto.ScaleDto;
import fr.vbaheux.mtengine.entity.scale.Scale;
import org.jspecify.annotations.Nullable;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = {NoteWriteConverter.class})
public interface ScaleWriteConverter extends Converter<Scale, ScaleDto> {
  ScaleDto convert(@Nullable Scale scale);
}
