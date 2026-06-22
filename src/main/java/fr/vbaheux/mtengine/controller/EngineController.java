package fr.vbaheux.mtengine.controller;

import fr.vbaheux.mtengine.dto.ChordDto;
import fr.vbaheux.mtengine.dto.ModeDto;
import fr.vbaheux.mtengine.dto.ScaleDto;
import fr.vbaheux.mtengine.entity.chord.Chord;
import fr.vbaheux.mtengine.entity.chord.ChordQuality;
import fr.vbaheux.mtengine.entity.chord.Inversion;
import fr.vbaheux.mtengine.entity.mode.Mode;
import fr.vbaheux.mtengine.entity.mode.ModeQuality;
import fr.vbaheux.mtengine.entity.note.Note;
import fr.vbaheux.mtengine.entity.scale.Scale;
import fr.vbaheux.mtengine.entity.scale.ScaleQuality;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class EngineController {
  private final ConversionService conversionService;

  public EngineController(ConversionService conversionService) {
    this.conversionService = conversionService;
  }

  @GetMapping("/scale")
  public ScaleDto scale(@RequestParam(defaultValue = "C") Note key,
                        @RequestParam(defaultValue = "MAJOR") ScaleQuality quality) {
    return conversionService.convert(Scale.of(key, quality), ScaleDto.class);
  }

  @GetMapping("/modes/{key}")
  @SuppressWarnings("unchecked")
  public List<ModeDto> modes(@PathVariable Note key) {
    List<Mode> modes = new LinkedList<>();
    for (ModeQuality quality : ModeQuality.values()) {
      modes.add(Mode.of(key, quality));
    }
    return (List<ModeDto>) conversionService.convert(
        modes,
        TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Mode.class)),
        TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ModeDto.class))
    );
  }

  @GetMapping("/modes/{key}/{quality}")
  public ModeDto mode(@PathVariable Note key,
                      @PathVariable ModeQuality quality) {
    return conversionService.convert(Mode.of(key, quality), ModeDto.class);
  }

  @GetMapping("/chord")
  public ChordDto chord(@RequestParam(defaultValue = "C") Note root,
                        @RequestParam(defaultValue = "MAJOR") ChordQuality quality,
                        @RequestParam(defaultValue = "ROOT") Inversion inversion) {
    return conversionService.convert(Chord.of(root, quality, inversion), ChordDto.class);
  }
}
