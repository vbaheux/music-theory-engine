package fr.vbaheux.mtengine.controller;

import fr.vbaheux.mtengine.dto.ScaleDto;
import fr.vbaheux.mtengine.entity.note.Note;
import fr.vbaheux.mtengine.entity.scale.Scale;
import fr.vbaheux.mtengine.entity.scale.ScaleQuality;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScaleController {
  private final ConversionService conversionService;

  public ScaleController(ConversionService conversionService) {
    this.conversionService = conversionService;
  }

  @GetMapping("/scale")
  public ScaleDto scale(@RequestParam(defaultValue = "C") Note key, @RequestParam(defaultValue = "MAJOR") ScaleQuality quality) {
    return conversionService.convert(new Scale(key, quality), ScaleDto.class);
  }
}
