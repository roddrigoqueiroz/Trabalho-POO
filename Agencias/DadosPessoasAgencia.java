package Agencias;
// Esta classe contém as pessoas vinculadas a uma agencia qualquer.
// A ideia é que nela estejam contidos todos os clientes e funcionários 
// que estão vinculados a esta agência
import java.util.ArrayList;
import Pessoas.*;

import java.io.Serializable;
import java.lang.Exception;

public class DadosPessoasAgencia implements Serializable {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private Gerente gerente;

    public DadosPessoasAgencia(Gerente gerente){
        if (gerente.getEstaGerindo() == true)
            throw new Error("Este gerente ja esta gerindo");
        else {
            this.gerente = gerente;
            gerente.setEstaGerindo();
        }
    }

// CLIENTES
    public void addCliente(Cliente novoCliente) throws Exception{
        if (!clientes.contains(novoCliente)){
            clientes.add(novoCliente);
        }
        else
            throw new Exception("Cliente ja existe");
    }
    public void removeCliente(Cliente clienteRemovido){
        clientes.remove(clienteRemovido);
    }
    public boolean existeCliente(Cliente cliente){
        return clientes.contains(cliente);
    }
    public void printClientes(){
        for (Cliente clientePrintado : clientes) {
            System.out.println(clientePrintado.getNome());
        }
    }

// FUNCIONÁRIOS
    public void addFuncionario(Funcionario novoFuncionario) throws Exception{
        if(!funcionarios.contains(novoFuncionario))
            funcionarios.add(novoFuncionario);
        else
            throw new Exception("Funcionario ja existe");
    }
    public void removeFuncionario(Funcionario funcionarioRemovido){
        funcionarios.remove(funcionarioRemovido);
    }
    public boolean existeFuncionario(Funcionario funcionario){
        return funcionarios.contains(funcionario);
    }
    public void printFuncionarios(){
        for (Funcionario funcionarioPrintado : funcionarios) {
            System.out.println(funcionarioPrintado.getNome());
        }
    }

// GERENTE
    public Gerente getGerente(){return gerente;}
    public void setGerente(Gerente gerente){this.gerente = gerente;}
}
