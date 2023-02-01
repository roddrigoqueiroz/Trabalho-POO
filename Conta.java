import Pessoas.*;
import java.time.LocalDate;
import java.util.Scanner;
import Exceptions.*;


public abstract class Conta {

    protected String senha;
    protected boolean status; //se a conta esta ativa ou nao
    private boolean logado; //flag para facilitar operacoes e nao precisar ficar logando toda hora
    protected LocalDate dataAbertura, dataModificacao, dataAtual;
    protected double numeroDaConta, saldo, numeroAgencia; //usei double pois pode ser que uma dessas variaveis estourem o valor do int
    protected Cliente cliente; //cliente para registrar o dono da conta
    protected double valorAux; //serve para armazenar o valor antes  da transacao

    Conta(String senha, Cliente cliente, double numeroDaConta, double numeroAgencia){//construtor com parametros
        status = true;
        if(senha.length()<=34){
            this.senha = senha;}
            else{throw new SenhaIncorretamenteDigitadaException("Erro!! Senha muito grande");}
        this.cliente = cliente;
        dataAbertura = LocalDate.now(); //data atual
        dataModificacao = LocalDate.now();
        saldo = 0;
        this.numeroDaConta = numeroDaConta;
        this.numeroAgencia = numeroAgencia;

    }
    public abstract Transacao saque(double valor);
    public abstract Transacao deposito(double valor);
    public abstract double consultarSaldo();
    public abstract Transacao pagamento(double valor, Conta destino);


    public double getValorAux() { //usado somente em operacoes matematicas, so retornado para ver o valor antigo
        //antes da transacao
        return valorAux;
    }

    protected void logoff(){
        logado = false; //fazer mensagem de logoff no menu, pois assim metodos podem usar desta funcao mais facilmente
    }
    //^^


    protected String dadosDaContaSuper(){ //base para mostrar todas as informacoes de maneira compativel com as classes extendidas
        return "Dados da conta:" + "\n" + "\n" +
            "Dono: " + cliente.getNome() + "\n" +
            "Senha: " + censurador() + "\n" +
            "Status: " + getStatus() + "\n" +
            "Data de abertura: " + dataAbertura + "\n" +
            "Data da ultima modificacao: " + dataModificacao + "\n" +
            "Numero da conta: " + numeroDaConta + "\n" +
            "Numero da agencia: " + numeroAgencia + "\n" +
            "Saldo: " + saldo + "\n";
    }

    //abstrato pois todo tipo diferente de conta precisa mostrar certas informacoes e toda conta precisa desse metodo
    protected abstract void dadosDaConta(); //colocando a necessidade de implementacao propria por meio do tipo abstrato

    private String censurador(){ //censurador de senha
        String censura = "";
        for(int i = 0; i < senha.length(); i++){
            censura = censura + "*";
        }
        return censura;
    }

    protected void mudarSenha(boolean logado){/*muda a senha e desloga*/
        if(logado){
            while(true){ //while pro loop infinito no caso do cliente errar a senha
            Scanner in = new Scanner(System.in);
            String digitado = "", confirmacao = "";
            System.out.print("Digite a nova senha: ");
            digitado = in.next();
            System.out.print("Confirme a senha digitada: ");
            confirmacao = in.next();
            if(digitado.equals(confirmacao)){
                senha = digitado;
                logoff();
                return;
            }
            else{
                throw new SenhaIncorretamenteDigitadaException("Erro!! Senhas digitadas sao diferentes, digite novamente");
                }
            }
        }
        else{
            throw new LoginFalsoException("Erro!! Necessario estar logado para realizar esta acao");
        }

    }

    //getters and setters

    public void setSenha(String senha){
        if(senha.length()<=34){
        this.senha = senha;}
        else{throw new SenhaIncorretamenteDigitadaException("Erro!! Senha muito grande");}
    }
    public String getSenha(){
        return senha;
    }

    public void setDono(String dono){
        cliente.setNome(dono);
    }
    public String getDono(){
        return cliente.getNome();
    }

    public void setStatus(boolean status){
        this.status = status;
    }
    public String getStatus(){ //implementei uma string inves de boolean para receber o texto formatado mais facilmente
        String str;
        if(status){str = "Conta Ativada";}
        else{str = "Conta Desativada";}
        return str;
    }

    public void setDataAbertura(LocalDate dataAbertura){
        this.dataAbertura = dataAbertura;
    }
    public LocalDate getDataAbertura(){
        return dataAbertura;
    }

    public void setDataModificacao(LocalDate dataModificacao){
        this.dataModificacao = dataModificacao;
    }
    public LocalDate getDataModificacao(){
        return dataModificacao;
    }

    public void setNumeroDaConta(double numeroDaConta){
        this.numeroDaConta = numeroDaConta;
    }
    public double getNumeroDaConta(){
        return numeroDaConta;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public double getSaldo(){
        return saldo;
    }

    public void setNumeroAgencia(double numeroAgencia){
        this.numeroAgencia = numeroAgencia;
    }
    public double getNumeroAgencia(){
        return numeroAgencia;
    }

    public LocalDate getDataAtual() {
        return dataAbertura = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

}
