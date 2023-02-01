import java.io.Serializable;

public class Administrador implements Serializable {
    private String login;
    private boolean logado;
    private String senha;

    public Administrador(String login, String senha){
        this.login = login;
        this.logado = true;
        setSenha(senha);
    }
    public Administrador(){
        this.logado = false;
    }

    public void setSenha(String senha){
        if (senha.length() <= 34)
            this.senha = senha;
        else
            throw new Error("Erro!! Senha muito grande");
    }

    public void print(){
        System.out.println("Login: " + login + "\nSenha: " + senha);
    }

    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }
    public boolean estaLogado() {
        return logado;
    }
    public void setLogado() {
        logado = true;
    }
    public void setDeslogado() {
        logado = false;
    }
}
