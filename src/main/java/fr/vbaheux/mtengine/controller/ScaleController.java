package fr.vbaheux.mtengine.controller;

import fr.vbaheux.mtengine.entity.note.Note;
import fr.vbaheux.mtengine.entity.scale.Scale;
import fr.vbaheux.mtengine.entity.scale.ScaleQuality;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScaleController {
  @GetMapping("/scale")
  public Scale scale(@RequestParam(defaultValue = "C") Note note, @RequestParam(defaultValue = "MAJOR") ScaleQuality quality) {
    return new Scale(note, quality);
    // FIXME JSON response format.
  }
}
