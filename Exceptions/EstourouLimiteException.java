package Exceptions;

public class EstourouLimiteException extends IllegalArgumentException {
    public EstourouLimiteException(String texto){
        super(texto);
    }
    public EstourouLimiteException(){
    }
}
