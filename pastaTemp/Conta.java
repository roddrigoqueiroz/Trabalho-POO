
import java.time.LocalDate;
import java.util.Scanner;


public abstract class Conta {

    protected String senha;
    protected boolean status; //se a conta esta ativa ou nao
    private boolean logado; //flag para facilitar operacoes e nao precisar ficar logando toda hora
    protected LocalDate dataAbertura, dataModificacao;
    protected double numeroDaConta, saldo, numeroAgencia; //usei double pois pode ser que uma dessas variaveis estourem o valor do int
    protected Cliente cliente; //cliente para registrar o dono da conta


    Conta(String senha, Cliente cliente, double numeroDaConta, double numeroAgencia){//construtor com parametros
        status = true;
        if(senha.length()<=34){
            this.senha = senha;}
            else{throw new Error("Erro!! Senha muito grande");}//VERIFICAR SE ESSE RETURN ESTA FUNCIONANDO
        this.cliente = cliente;
        dataAbertura = LocalDate.now(); //data atual
        dataModificacao = LocalDate.now();
        saldo = 0;
        this.numeroDaConta = numeroDaConta;
        this.numeroAgencia = numeroAgencia;

    }

    //as funcoes de login talvez sejam melhor em outro lugar, como no menu, se receber como parametro o boolean de logado pode ser que seja melhor
    protected void login(){
        Scanner in = new Scanner(System.in);
        String digitado = "";
        System.out.println("Digite a senha: ");
        digitado = in.nextLine();
        if(digitado == senha){
            logado = true;
            in.close();
        }
        else{in.close(); throw new Error("Erro!! Senha incorreta");}
        
    }
    protected void logoff(){
        logado = false; //fazer mensagem de logoff no menu, pois assim metodos podem usar desta funcao mais facilmente
    }
    //^^

    protected String dadosDaContaSuper(){ //base para mostrar todas as informacoes de maneira compativel com as classes extendidas
        return
        System.out.println("Dados da conta:" + "\n" + "\n" +
            "Dono: " + Cliente.getNome + "\n" +
            "Senha: " + censurador() + "\n" +
            "Status: " + getStatus() + "\n" +
            "Data de abertura: " + dataAbertura + "\n" +
            "Data da ultima modificacao: " + dataModificacao + "\n" +
            "Numero da conta: " + numeroDaConta + "\n" +
            "Numero da agencia: " + numeroAgencia + "\n" +
            "Saldo: " + saldo + "\n");
    }

    protected abstract void dadosDaConta(); //colocando a necessidade de implementacao propria por meio do tipo abstrato

    private String censurador(){ //censurador de senha
        String censura = "";
        for(int i = 0; i < senha.length(); i++){
            censura = censura + "*";
        }
        return censura;
    }

    protected void mudarSenha(){/*muda a senha e desloga*/
        if(logado){
            Scanner in = new Scanner(System.in);
            String digitado = "", confirmacao = "";
            System.out.println("Digite a nova senha: ");
            digitado = in.nextLine();
            System.out.println("Confirme a senha digitada: ");
            confirmacao = in.nextLine();
            if(digitado == confirmacao){
                senha = digitado;
                logoff();
            }
        }
        else{
            throw new Error("Erro!! Necessario estar logado para realizar esta acao");
        }

    }


    protected void setSenha(String senha){
        if(senha.length()<=34){
        this.senha = senha;}
        else{throw new Error("Erro!! Senha muito grande");}
    }
    protected String getSenha(){
        return senha;
    }

    protected void setDono(String dono){ //acho que esse metodo vai precisar ser alterado
        cliente.setNome = dono;
    }
    protected String getDono(){
        return cliente.getNome;
    }

    protected void setStatus(boolean status){
        this.status = status;
    }
    protected String getStatus(){ //implementei uma string inves de boolean para receber o texto formatado mais facilmente
        String str;
        if(status){str = "sim";}
        else{str = "nao";}
        return str;
    }

    protected void setDataAbertura(LocalDate dataAbertura){
        this.dataAbertura = dataAbertura;
    }
    protected LocalDate getDataAbertura(){
        return dataAbertura;
    }

    protected void setDataModificacao(LocalDate dataModificacao){
        this.dataModificacao = dataModificacao;
    }
    protected LocalDate getDataModificacao(){
        return dataModificacao;
    }

    protected void setNumeroDaConta(double numeroDaConta){
        this.numeroDaConta = numeroDaConta;
    }
    protected double getNumeroDaConta(){
        return numeroDaConta;
    }

    protected void setSaldo(double saldo){
        this.saldo = saldo;
    }
    protected double getSaldo(){
        return saldo;
    }

    protected void setNumeroAgencia(double numeroAgencia){
        this.numeroAgencia = numeroAgencia;
    }
    protected double getNumeroAgencia(){
        return numeroAgencia;
    }

}
