package fr.vbaheux.mtengine.exception;

public class InvalidValueException extends MusicEngineException {
  public InvalidValueException(Class<?> c, Object value, String cause) {
    super(String.format("%s - invalid value: %s %s", c.getName(), value.toString(), cause));
  }
}
