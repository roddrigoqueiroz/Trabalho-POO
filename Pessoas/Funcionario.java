package Pessoas;
import java.time.LocalDate;

import Agencias.Agencia;

public class Funcionario extends Pessoa {
    protected String CLT;
    protected String RG;
    protected char sexo; // M = homem, F = mulher
    protected String cargo; // fazer tabela com possiveis cargos e seus salarios
    protected double salario;
    protected int anoIngresso;

    public Funcionario(String CPF, String nome, String endereco, String dataNasc, 
    String estadoCivil, String CLT, String RG, char sexo,
    String cargo, double salario, int anoIngresso){
        super(CPF, nome, endereco, dataNasc, estadoCivil);
        this.CLT = CLT; // tlvz implementar algoritmo de checagem
        this.RG = RG; // tlvz implementar algoritmo de checagem
        try{
            setSexo(sexo);
        } catch (Error e) {
            System.out.println(e);
        }
        this.cargo = cargo;
        this.salario = salario;
        this.anoIngresso = anoIngresso;
    }

    public Funcionario(String CPF, String nome, String endereco, String dataNasc, 
    String estadoCivil, String CLT, String RG, char sexo,
    String cargo, double salario, Agencia agencia){
        super(CPF, nome, endereco, dataNasc, estadoCivil);
        this.CLT = CLT; // tlvz implementar algoritmo de checagem
        this.RG = RG; // tlvz implementar algoritmo de checagem
        try{
            setSexo(sexo);
        } catch (Error e) {
            System.out.println(e);
        }
        this.cargo = cargo;
        this.salario = salario;
        this.anoIngresso = LocalDate.now().getYear();
        agencia.addFuncionario(this);
    }

    public Funcionario(Agencia agencia){
        super();
        agencia.addFuncionario(this);
    }

    public double calculaSalario(){
        int anoAtual = LocalDate.now().getYear();
        if (anoAtual - anoIngresso >= 15)
            return salario * 1.1;
        else
            return salario;
    }

    public void setSexo(char sexo){
        if (sexo == 'M' || sexo == 'F')
            this.sexo = sexo;
        else
            throw new Error("Sexo invalido");            
    }

    public String getCLT() {return CLT;}
    public String getRG() {return RG;}
    public char getSexo(){return sexo;}
    public String getCargo() {return cargo;}
    public double getSalario() {return calculaSalario();}
    public int getAnoIngresso() {return anoIngresso;}
}
