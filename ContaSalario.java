public class ContaSalario extends Conta{
    private double limiteSaque, limiteTransferencia;

    ContaSalario(String senha, Cliente cliente, double numeroDaConta, double numeroAgencia, double limiteSaque, double limiteTransferencia){
        super(senha, cliente, numeroDaConta, numeroAgencia);
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
    
}
