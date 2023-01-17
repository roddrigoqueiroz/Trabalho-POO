import java.time.LocalDate;

public abstract class Conta {
    // Atributos
    protected int numero;
    protected double saldo;
    protected LocalDate dataAbertura;
    protected LocalDate dataUltimaModificacao;
    protected int numeroAgencia;
    protected boolean ativa;
    protected String senha;
    protected String cliente;

    public Conta(int numero, String dataAbertura, int numeroAgencia, String senha, String cliente){
        this.numero = numero; // é bom conseguir gerar esse número automaticamente
        this.saldo = 0; // Saldo deve começar zerado ao criar uma conta
        this.dataAbertura = LocalDate.parse(dataAbertura);
        this.dataUltimaModificacao = this.dataAbertura; // Assim que a conta é criada, a última modificação é a própria data de criação
        this.senha = senha;
        this.cliente = cliente;
    }
}