package fr.vbaheux.mtengine.entity.note;

import fr.vbaheux.mtengine.entity.interval.Interval;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Note {

  @NonNull
  private Letter letter;

  private Accidental accidental;

  /**
   * Get another note relative to the current note, given the interval to apply.
   *
   * @param interval the interval to apply to the current note<br/>
   *                 (e.g. C# + Perfect 5th = G#)
   * @return the requested note.
   */
  public Note get(Interval interval) {
    // FIXME
    return Note.of(letter.offset(interval.degree()), accidental);
  }

  /**
   * Get another note relative to the current note, given an offset in semitones.
   * <p>
   *
   * @param offset the number of semitones to apply (positive or negative)
   * @return the requested note.
   */
  public Note get(int offset) {
    // FIXME
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String toString() {
    return letter.name() + (accidental != null ? accidental : "");
  }
}
