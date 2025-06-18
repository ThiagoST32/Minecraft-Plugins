package org.plugins.minevidencia.Exceptions;

public class InvalidCommandParameters extends NumberFormatException {
    public InvalidCommandParameters() {
        super("Parâmetros inválidos!");
    }
}
