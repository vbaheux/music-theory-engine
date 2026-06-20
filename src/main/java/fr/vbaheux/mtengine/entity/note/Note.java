package fr.vbaheux.mtengine.entity.note;

import fr.vbaheux.mtengine.entity.interval.Interval;
import fr.vbaheux.mtengine.exception.InvalidStateException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static fr.vbaheux.mtengine.EngineConstants.NB_SEMITONES_IN_OCTAVE;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Note {

  @NonNull
  private Letter letter;

  private Accidental accidental = Accidental.NATURAL;

  /**
   * Get another note relative to the current note, given the interval to apply.
   *
   * @param interval the interval to apply to the current note<br/>
   *                 (e.g. C# + Perfect 5th = G#)
   * @return the requested note.
   */
  public Note get(Interval interval) {
    return get(interval.toSemitones());
  }

  /**
   * Get another note relative to the current note, given an offset in semitones.
   * <p>
   *
   * @param offset the number of semitones to apply (positive or negative)
   * @return the requested note.
   */
  public Note get(int offset) {
    // Offset of the current note from C natural.
    int currentOffset = letter.getOffset() + accidental.getOffset();
    // Add target offset & round to the octave.
    int targetOffset = (currentOffset + offset) % NB_SEMITONES_IN_OCTAVE;
    // Try to find a note matching this offset. If found, return it.
    Letter l = Letter.getByOffsetFromCNatural(targetOffset);
    if (l != null) {
      return Note.of(l, Accidental.NATURAL);
    }
    /*
    If no letter matching this offset was found:
    - If the current note has an accidental alteration, use it as preference (FLAT or SHARP)
    - Otherwise, default to SHARP. TODO pass key signature's list of accidentals as parameter & apply when wanted
    */
    return switch (accidental) {
      case FLAT -> {
        l = Letter.getByOffsetFromCNatural((targetOffset + 1) % NB_SEMITONES_IN_OCTAVE);
        if (l == null) {
          throw new InvalidStateException(Letter.class, "No letter found for offset " + currentOffset);
        }
        yield new Note(l, Accidental.FLAT);
      }
      case SHARP, NATURAL -> {
        l = Letter.getByOffsetFromCNatural((targetOffset - 1) % NB_SEMITONES_IN_OCTAVE);
        if (l == null) {
          throw new InvalidStateException(Letter.class, "No letter found for offset " + currentOffset);
        }
        yield new Note(l, Accidental.SHARP);
      }
    };
  }

  @Override
  public String toString() {
    return letter.name() + (accidental != null ? accidental : "");
  }
}
