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

    public Cliente(String CPF, String nome){
        super(nome, CPF);
    }

    private boolean testarEscolaridade(String escolaridade){
        for (int i = 0; i < this.escolaridadePermitida.length; i++){
            if (this.escolaridadePermitida[i].equals(escolaridade))
                return true;
        }
        return false;
    }

    public String getEscolaridade(){return escolaridade;}
    public int getNumeroAgencia(){return numeroAgencia;}

    public void setEsolaridade(String escolaridade){
        if (testarEscolaridade(escolaridade))
            this.escolaridade = escolaridade;
        else
            System.out.println("ERRO: escolaridade invalida");
    }
}
