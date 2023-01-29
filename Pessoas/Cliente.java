// Checar se agencia existe pra criar cliente
// Colocar array de contas do cliente
package Pessoas;
import Agencias.*;
public class Cliente extends Pessoa {
    private String escolaridade;
    private int numeroAgencia;

    private final String[] escolaridadePermitida = {
        "Fundamental - Incompleto", "Fundamental - Completo", 
        "Medio - Incompleto", "Medio - Completo",
        "Superior - Incompleto", "Superior - Completo", 
        "Pos-graduacao - Incompleto",
        "Pos-graduacao - Completo"
    };

    public Cliente(String CPF, String nome, String endereco, String dataNasc, 
    String estadoCivil, String escolaridade, Agencia agencia){
        super(CPF, nome, endereco, dataNasc, estadoCivil);
        try {
            testarEscolaridade(escolaridade);
        } catch (Error e) {
            System.out.println(e);
        }
        agencia.addCliente(this);
        numeroAgencia = agencia.getNumero();
    }

    public Cliente(String CPF, String nome, Agencia agencia){
        super(CPF, nome);
        agencia.addCliente(this);
    }

    public Cliente(){
        super();
        escolaridade = "Medio - Completo";
        numeroAgencia = 0;
    }

    private boolean testarEscolaridade(String escolaridade){
        for (int i = 0; i < this.escolaridadePermitida.length; i++){
            if (this.escolaridadePermitida[i].equals(escolaridade))
                return true;
        }
        throw new Error("ERRO: escolaridade invalida");
    }

    public String getEscolaridade(){return escolaridade;}
    public int getNumeroAgencia(){return numeroAgencia;}

    public void setEsolaridade(String escolaridade){
        try {
            testarEscolaridade(escolaridade);
            this.escolaridade = escolaridade;
        } catch (Error e) {
            System.out.println(e);
        }
    }
}
