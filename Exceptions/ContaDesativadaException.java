package Exceptions;

public class ContaDesativadaException extends IllegalArgumentException{
    public ContaDesativadaException(String texto){
        super(texto);
    }
    public ContaDesativadaException(){
    }

}
