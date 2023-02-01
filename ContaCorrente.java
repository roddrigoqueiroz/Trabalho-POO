import Pessoas.*;
import Exceptions.*;

public class ContaCorrente extends Conta{
    private double limite, taxaAdm, taxaParaCalculo;

    ContaCorrente(String senha, Cliente cliente, double numeroDaConta, double numeroAgencia, double limite, double taxaAdm){
        super(senha, cliente, numeroDaConta, numeroAgencia);
        this.limite = limite;
        this.taxaAdm = taxaAdm;
        setTaxaParaCalculo(taxaAdm);
    }

    protected void dadosDaConta(){
        System.out.println(super.dadosDaContaSuper() + "\n" +
            "Limite: " + limite + "\n" +
            "Taxa: " + taxaAdm + "\n");
    }

    public double getLimite(){
        return limite;
    }

    public double getTaxaAdm(){
        return taxaAdm;
    }

    public void setLimite(double limite){
        this.limite = limite;
    }

    public void setTaxaParaCalculo(double taxa){
        // 0,5% = 0,005 -> 1 - taxa (0,005) = 0,955
        this.taxaParaCalculo = 1 - taxa;
    }
    public void setTaxaAdm(double taxaAdm) {
        this.taxaAdm = taxaAdm;
    }

    public void saque(double valor){
        if(getSaldo()<valor){throw new SaldoInsuficienteException("Erro!! Saldo insuficiente!");}
        else {
            valorAux = getSaldo();
            setSaldo(getSaldo()-valor);
            Transacao t = new Transacao(this, getDataAtual(), "Caixa eletronico");
            System.out.println(t.printRecibo());}
    }

    public void deposito(double valor){
        if(valor>0 && getSaldo()+(valor*taxaParaCalculo) <= limite){
        valorAux = getSaldo();
        setSaldo(getSaldo()+(valor*taxaParaCalculo));
        Transacao t = new Transacao(this, getDataAtual(), "Digital");
        System.out.println(t.printRecibo());}
        else{throw new ValorMenorQue0Exception("Erro!! O valor deve ser maior que 0 ou menor que o limite");}
    }

    public double consultarSaldo(){
        return getSaldo();
    }

    public void pagamento(double valor, Conta destino){
        if(valor>getSaldo()){throw new SaldoInsuficienteException("Erro!! Saldo insuficiente!");}
        else{
            valorAux = getSaldo();
            setSaldo(getSaldo() - valor);
            destino.setSaldo(destino.getSaldo()+(valor*taxaParaCalculo));
            Transacao t = new Transacao(this, getDataAtual(), "Digital");
            System.out.println(t.printRecibo());
        }
    }

}
