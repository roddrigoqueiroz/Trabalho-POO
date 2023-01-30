package Exceptions;

public class ValorMenorQue0Exception extends IllegalArgumentException{
    public ValorMenorQue0Exception(String texto){
        super(texto);
    }
    public ValorMenorQue0Exception(){
    }
}
