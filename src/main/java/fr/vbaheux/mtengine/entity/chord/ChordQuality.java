package fr.vbaheux.mtengine.entity.chord;

import fr.vbaheux.mtengine.entity.interval.Interval;
import fr.vbaheux.mtengine.entity.interval.IntervalQuality;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum ChordQuality {
  MAJOR(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MAJOR, 3),
      Interval.of(IntervalQuality.PERFECT, 5)
  )),
  MINOR(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MINOR, 3),
      Interval.of(IntervalQuality.PERFECT, 5)
  )),
  DIMINISHED(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MINOR, 3),
      Interval.of(IntervalQuality.DIMINISHED, 5)
  )),
  AUGMENTED(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MAJOR, 3),
      Interval.of(IntervalQuality.AUGMENTED, 5)
  )),
  MAJOR_SEVENTH(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MAJOR, 3),
      Interval.of(IntervalQuality.PERFECT, 5),
      Interval.of(IntervalQuality.MAJOR, 7)
  )),
  MINOR_SEVENTH(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MINOR, 3),
      Interval.of(IntervalQuality.PERFECT, 5),
      Interval.of(IntervalQuality.MINOR, 7)
  )),
  DOMINANT_SEVENTH(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MAJOR, 3),
      Interval.of(IntervalQuality.PERFECT, 5),
      Interval.of(IntervalQuality.MINOR, 7))),
  DIMINISHED_SEVENTH(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MINOR, 3),
      Interval.of(IntervalQuality.DIMINISHED, 5),
      Interval.of(IntervalQuality.DIMINISHED, 7)
  )),
  HALF_DIMINISHED_SEVENTH(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MINOR, 3),
      Interval.of(IntervalQuality.DIMINISHED, 5),
      Interval.of(IntervalQuality.MINOR, 7)
  )),
  MINOR_MAJOR_SEVENTH(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MINOR, 3),
      Interval.of(IntervalQuality.PERFECT, 5),
      Interval.of(IntervalQuality.MAJOR, 7)
  )),
  AUGMENTED_MAJOR_SEVENTH(List.of(
      Interval.of(IntervalQuality.PERFECT, 1),
      Interval.of(IntervalQuality.MAJOR, 3),
      Interval.of(IntervalQuality.AUGMENTED, 5),
      Interval.of(IntervalQuality.MAJOR, 7)
  ));

  private final List<Interval> intervals;
}
