package Exceptions;

public class SaldoInsuficienteException extends IllegalArgumentException{
    public SaldoInsuficienteException(String texto){
        super(texto);
    }
    public SaldoInsuficienteException(){
    }
}
