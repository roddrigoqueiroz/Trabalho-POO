import Pessoas.*;
//import java.util.Random;
import Exceptions.*;

public class ContaPoupanca extends Conta{
    private double rendimento = 1;

    ContaPoupanca(String senha, Cliente cliente, double numeroDaConta, double numeroAgencia, double rendimento){
        super(senha, cliente, numeroDaConta, numeroAgencia);
        this.rendimento = rendimento;
    }

    protected void dadosDaConta(){
        System.out.println(super.dadosDaContaSuper() + "\n" +
            "Rendimento: " + rendimento + "\n");
    }
    
    /*private void simulaVariacaoRendimento(){ //utilizar toda vez que houver uma transacao
        Random r = new Random();
        rendimento = 1; //rendimento volta para 1 pois poderia ficar ridiculamente alto caso contrario
        rendimento = rendimento * r.nextDouble(); /*gera um numero entre 1 e 1.3 toda vez que a funcao
                                                            *for chamada para simular a variacao do rendimento */                                                 
    //}
    public double getRendimento(){
        return rendimento;
    }

    public void setRendimento(double rendimento){
        this.rendimento = rendimento;
    }

    public void saque(double valor){
        if(getSaldo()<valor){throw new SaldoInsuficienteException("Erro!! Saldo insuficiente!");}
        else {
            valorAux = getSaldo();
            setSaldo(getSaldo()-valor);}
    }

    public void deposito(double valor){
        if(valor>0){
        valorAux = getSaldo();
        setSaldo((getSaldo()*rendimento)+valor);}
        else{throw new ValorMenorQue0Exception("Erro!! O valor deve ser maior que 0");}
    }

    public double consultarSaldo(){
        return getSaldo();
    }

    public void pagamento(double valor, Conta destino){
        if(valor>getSaldo()){throw new SaldoInsuficienteException("Erro!! Saldo insuficiente!");}
        else{
            valorAux = getSaldo();
            setSaldo(getSaldo() - valor);
            destino.setSaldo(destino.getSaldo()+valor);
        }
    }
    
}
