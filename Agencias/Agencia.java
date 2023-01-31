// Fazer filtro de erros
package Agencias;
import Pessoas.*;

import java.io.*;
import java.lang.Integer;

public class Agencia implements Serializable {
    private int numero;
    private String nome;
    private String endereco;
    private DadosPessoasAgencia pessoasDaAgencia;

    private final String ARQUIVO = "id-agencia.txt";

    public Agencia(String nome, String endereco, Gerente gerente){
        this.nome = nome;
        this.endereco = endereco;
        pessoasDaAgencia = new DadosPessoasAgencia(gerente);
        pessoasDaAgencia.getGerente().setNumeroAgencia(numero);
        this.numero = geraNumero();
    }

    private int geraNumero(){
        File f = new File(ARQUIVO);
        
        if (f.exists()){
            try {
                // Abre arquivo pra leitura
                BufferedReader lerId = new BufferedReader(new FileReader(ARQUIVO));
                int numeroLido = Integer.parseInt(lerId.readLine());
                lerId.close();
                numeroLido++; // atualiza o numero lido
                // Reescreve o numero lido no arquivo
                PrintWriter printaId = new PrintWriter(new FileWriter(ARQUIVO));
                printaId.println(numeroLido);
                printaId.close();
                return numeroLido;
            } catch (Exception e) {
                System.out.println("Nao foi possivel abrir arquivo");
            }
        }
        else {
            try {
                // Cria e já escreve o numero 0 no arquivo
                PrintWriter printaId = new PrintWriter(new FileWriter(ARQUIVO));
                printaId.println(0);
                printaId.close();
                return 0;
            } catch (IOException e) {
                System.out.println("Nao foi possivel criar arquivo");
            }
        }
        return 0;
    }

    public void print(){
        System.out.printf("Numero: %d\nNome ficticio: %s\nEndereco: %s\n",
                            numero, nome, endereco);
    }

    public void addCliente(Cliente novoCliente){
        try {
            pessoasDaAgencia.addCliente(novoCliente);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addFuncionario(Funcionario novFuncionario){
        try{
            pessoasDaAgencia.addFuncionario(novFuncionario);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getNumero() {return numero;}
    public String getNome() {return nome;}
    public String getEndereco() {return endereco;}
    public Gerente getGerente() {return pessoasDaAgencia.getGerente();}

    public void printClientes() {pessoasDaAgencia.printClientes();}
    public void printFuncionarios() {pessoasDaAgencia.printFuncionarios();}
}
