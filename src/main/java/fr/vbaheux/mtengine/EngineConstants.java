package fr.vbaheux.mtengine;

public class EngineConstants {
  public static final short NB_SEMITONES_IN_OCTAVE = 12;
  public static final short NB_STEPS_DIATONIC_SCALE = 7;

  private EngineConstants() {
    throw new IllegalStateException("Utility class, should never be instantiated");
  }
}
