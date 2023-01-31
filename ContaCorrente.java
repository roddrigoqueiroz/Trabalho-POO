import Pessoas.*;
import Exceptions.*;

public class ContaCorrente extends Conta{
    private double limite, taxa;

    ContaCorrente(String senha, Cliente cliente, double numeroDaConta, double numeroAgencia, double limite, double taxa){
        super(senha, cliente, numeroDaConta, numeroAgencia);
        this.limite = limite;
        this.taxa = taxa;
    }

    protected void dadosDaConta(){
        System.out.println(super.dadosDaContaSuper() + "\n" +
            "Limite: " + limite + "\n" +
            "Taxa: " + taxa + "\n");
    }

    public double getLimite(){
        return limite;
    }

    public double getTaxa(){
        return taxa;
    }

    public void setLimite(double limite){
        this.limite = limite;
    }

    public void setTaxa(double taxa){
        this.taxa = taxa;
    }

    public void saque(double valor){
        if(getSaldo()<valor){throw new SaldoInsuficienteException("Erro!! Saldo insuficiente!");}
        else {
            valorAux = getSaldo();
            setSaldo(getSaldo()-valor);}
    }

    public void deposito(double valor){
        if(valor>0 && getSaldo()+(valor*(-taxa)) <= limite){
        valorAux = getSaldo();
        setSaldo(getSaldo()+(valor*(-taxa)));}
        else{throw new ValorMenorQue0Exception("Erro!! O valor deve ser maior que 0 ou menor que o limite");}
    }

    public double consultarSaldo(){
        return getSaldo();
    }

    public void pagamento(double valor, Conta destino){
        if(valor>getSaldo()){throw new SaldoInsuficienteException("Erro!! Saldo insuficiente!");}
        else{
            valorAux = getSaldo();
            setSaldo(valor);
            destino.setSaldo(destino.getSaldo()+(valor*(-taxa)));
        }
    }

}
