package fr.vbaheux.mtengine.entity.note;

import fr.vbaheux.mtengine.entity.interval.Interval;
import fr.vbaheux.mtengine.exception.InvalidStateException;
import fr.vbaheux.mtengine.exception.InvalidValueException;
import lombok.*;

import static fr.vbaheux.mtengine.EngineConstants.NB_SEMITONES_IN_OCTAVE;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Note {

  @NonNull
  @Getter
  private Letter letter;

  @Getter
  private Accidental accidental = Accidental.NATURAL;

  /**
   * Get another note relative to the current note, given the interval to apply.
   *
   * @param interval the interval to apply to the current note<br/>
   *                 (e.g. C# + Perfect 5th = G#)
   * @return the requested note.
   */
  public Note get(Interval interval, Accidental preferredAccidental) {
    return get(interval.toSemitones(), preferredAccidental);
  }

  /**
   * Checks if the note is natural (i.e. without FLAT or SHARP accidental, NATURAL only).
   *
   * @return true if the current note is natural, false otherwise.
   */
  public boolean isNatural() {
    return accidental.equals(Accidental.NATURAL);
  }

  /**
   * Get another note relative to the current note, given an offset in semitones.
   * <p>
   *
   * @param offset the number of semitones to apply (positive or negative)
   * @return the requested note.
   */
  public Note get(int offset, Accidental preferredAccidental) {
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
    - Otherwise, use the given preferred accidental.
    */
    return switch (accidental) {
      case FLAT -> getWithAccidental(targetOffset, Accidental.FLAT);
      case SHARP -> getWithAccidental(targetOffset, Accidental.SHARP);
      case NATURAL -> getWithAccidental(targetOffset, preferredAccidental);
    };
  }

  /**
   * Get flat or sharp note from a given offset and a preferred accidental (only FLAT or SHARP accepted).
   *
   * @param offset              the offset to apply (without accidental compensation)
   * @param preferredAccidental the preferred accidental to apply
   * @return the desired note.
   */
  private Note getWithAccidental(int offset, Accidental preferredAccidental) {
    int accidentalOffset = switch (preferredAccidental) {
      case FLAT -> 1;
      case SHARP -> -1;
      case NATURAL ->
          throw new InvalidValueException(Note.class, preferredAccidental, "Preferred accidental can't be NATURAL");
    };

    Letter l = Letter.getByOffsetFromCNatural((offset + accidentalOffset) % NB_SEMITONES_IN_OCTAVE);
    if (l == null) {
      throw new InvalidStateException(Letter.class, "No letter found for offset " + offset);
    }
    return Note.of(l, preferredAccidental);
  }

  @Override
  public String toString() {
    return letter.name() + (accidental != null ? accidental : "");
  }
}
