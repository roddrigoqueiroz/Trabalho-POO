public class Funcionario extends Pessoa {
    protected int CLT;
    protected int RG;
    protected boolean sexo; // homem = false; mulher = true
    protected String cargo;
    protected double salario;
    protected int anoIngresso;

    public Funcionario(String CPF, String nome, String endereco, String dataNasc, 
    String estadoCivil,int CLT, int RG, boolean sexo,
    String cargo, double salario, int anoIngresso){
        super(CPF, nome, endereco, dataNasc, estadoCivil);
        this.CLT = CLT; // tlvz implementar algoritmo de checagem
        this.RG = RG; // tlvz implementar algoritmo de checagem
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
        this.anoIngresso = anoIngresso;
    }
}
