package Exceptions;

public class LoginFalsoException extends IllegalArgumentException{
    public LoginFalsoException(String texto){
        super(texto);
    }
    public LoginFalsoException(){
    }
}
