package fr.vbaheux.mtengine.controller;

import fr.vbaheux.mtengine.entity.old.NoteEnum;
import fr.vbaheux.mtengine.entity.old.Scale;
import fr.vbaheux.mtengine.entity.old.ScaleType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScaleController {
  @GetMapping("/scale")
  public Scale scale(@RequestParam(defaultValue = "C") NoteEnum tonic, @RequestParam(defaultValue = "MAJOR") ScaleType type) {
    return new Scale(tonic, type);
  }
}