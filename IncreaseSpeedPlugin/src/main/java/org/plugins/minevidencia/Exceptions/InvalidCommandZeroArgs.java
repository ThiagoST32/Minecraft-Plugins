package org.plugins.minevidencia.Exceptions;

public class InvalidCommandZeroArgs extends IndexOutOfBoundsException {
    public InvalidCommandZeroArgs() {
      super("O comando não foi aplicado. Por favor, forneça um valor de 0 a 4");
    }
}
