package fr.vbaheux.mtengine.exception;

public abstract class MusicEngineException extends RuntimeException {
  public MusicEngineException(String message) {
    super(message);
  }
}
