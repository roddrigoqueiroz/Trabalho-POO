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

    private double getLimite(){
        return limite;
    }

    private double getTaxa(){
        return taxa;
    }

    private void setLimite(double limite){
        this.limite = limite;
    }

    private void setTaxa(double taxa){
        this.taxa = taxa;
    }
    
}
