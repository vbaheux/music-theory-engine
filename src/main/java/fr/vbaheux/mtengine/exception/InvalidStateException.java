package fr.vbaheux.mtengine.exception;

public class InvalidStateException extends MusicEngineException {
  public InvalidStateException(Class<?> c, String cause) {
    super(String.format("%s - invalid state: %s", c.getName(), cause));
  }
}
