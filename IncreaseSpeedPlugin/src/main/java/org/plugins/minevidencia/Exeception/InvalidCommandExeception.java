package org.plugins.minevidencia.Exeception;

public class InvalidCommandExeception extends RuntimeException {
  public InvalidCommandExeception(String message) {
    super("Invalid user command: " + message);
  }
}
