import Pessoas.*;
import Exceptions.*;

public class ContaSalario extends Conta{
    private double limiteSaque, limiteTransferencia;

    ContaSalario(String senha, Cliente cliente, double numeroAgencia, double limiteSaque, double limiteTransferencia){
        super(senha, cliente, numeroAgencia);
        this.limiteSaque = limiteSaque;
        this.limiteTransferencia = limiteTransferencia;
    }

    protected void dadosDaConta(){
        System.out.println(super.dadosDaContaSuper() + "\n" +
            "Limite de saque: " + limiteSaque + "\n" +
            "Limite de transferencia: " + limiteTransferencia + "\n");
    }

    public double getSaque(){
        return limiteSaque;}

    public double getTransferencia(){
        return limiteTransferencia;}

    public void setSaque(double limiteSaque){
        this.limiteSaque = limiteSaque;
    }

    public void setTransferencia(double limiteTransferencia){
        this.limiteTransferencia = limiteTransferencia;
    }

    public Transacao saque(double valor){
        if(getSaldo()<valor){throw new SaldoInsuficienteException("Erro!! Saldo insuficiente!");}
        if(valor > limiteSaque){throw new EstourouLimiteException("Erro!! Estourou o valor de limite!");}
        else {
            valorAux = getSaldo();
            setSaldo(getSaldo()-valor);
            return new Transacao(this, getDataAtual(), "Caixa eletronico");}
    }

    public Transacao deposito(double valor){
        if(valor>0){
        valorAux = getSaldo();
        setSaldo(getSaldo()+valor);
        return new Transacao(this, getDataAtual(), "Digital");}
        else{throw new ValorMenorQue0Exception("Erro!! O valor deve ser maior que 0");}
    }

    public double consultarSaldo(){
        return getSaldo();
    }

    public Transacao pagamento(double valor, Conta destino){
        if(valor>getSaldo()){throw new SaldoInsuficienteException("Erro!! Saldo insuficiente!");}
        if(valor>limiteTransferencia){throw new EstourouLimiteException("Erro!! Estourou o valor de limite!");}
        else{
            valorAux = getSaldo();
            setSaldo(getSaldo()-valor);
            destino.setSaldo(destino.getSaldo()+valor);
            return new Transacao(this, getDataAtual(), "Digital");
        }
    }
}  
