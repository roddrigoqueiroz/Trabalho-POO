package Exceptions;

public class SenhaIncorretamenteDigitadaException extends IllegalArgumentException{
    public SenhaIncorretamenteDigitadaException(String texto){
        super(texto);
    }
    public SenhaIncorretamenteDigitadaException(){
    }
}
