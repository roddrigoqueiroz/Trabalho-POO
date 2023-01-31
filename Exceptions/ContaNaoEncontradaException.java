package Exceptions;

public class ContaNaoEncontradaException extends IllegalArgumentException{
    public ContaNaoEncontradaException(String texto){
        super(texto);
    }
    public ContaNaoEncontradaException(){
    }
}
