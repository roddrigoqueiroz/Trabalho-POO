package Pessoas;
import java.time.LocalDate;

public class Gerente extends Funcionario {
    private LocalDate dataIngresso;
    private int numeroAgencia;
    private boolean cursoGerencia;
    private double comissao;
    private boolean estaGerindo;

    public Gerente (String CPF, String nome, String endereco, String dataNasc, 
    String estadoCivil, String CLT, String RG, char sexo,
    double salario, int anoIngresso,
    String dataIngresso, boolean cursoGerencia, double comissao){
        super(CPF, nome, endereco, dataNasc, estadoCivil, CLT, RG, sexo, "gerente", salario, anoIngresso);
        this.dataIngresso = LocalDate.parse(dataIngresso);
        this.cursoGerencia = cursoGerencia;
        this.estaGerindo = false;
        this.numeroAgencia = -1; // nao esta gerindo ninguem
        if (comissao > 0)
            this.comissao = comissao;
        else
            this.comissao = 0;
    }

    public double calculaSalario(){
        return super.calculaSalario() + comissao;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
    public void setCursoGerencia(){
        this.cursoGerencia = true;
    }
    public void ganhaComissao(double comissaoAdicional){
        if (comissaoAdicional > 0)
            this.comissao += comissaoAdicional;
    }
    public void setEstaGerindo() {
        this.estaGerindo = true;
    }

    public LocalDate getDataIngresso() {return dataIngresso;}
    public int getNumeroAgencia() {return numeroAgencia;}
    public boolean getCursoGerencia() {return cursoGerencia;}
    public double getComissao() {return comissao;}
    public boolean getEstaGerindo() {return estaGerindo;}

}
