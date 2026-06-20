package fr.vbaheux.mtengine.entity.chord;

import fr.vbaheux.mtengine.entity.note.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Chord {

  @Builder.Default
  private Inversion inversion = Inversion.ROOT;
  private ChordQuality quality;
  private Note root;

}
