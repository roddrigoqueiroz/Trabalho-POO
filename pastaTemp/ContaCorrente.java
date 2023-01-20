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
    
}
