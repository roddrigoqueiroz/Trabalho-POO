import java.time.LocalDate;

public abstract class Pessoa {
    protected String CPF;
    protected String nome;
    protected String endereco;
    protected String estadoCivil;
    protected LocalDate dataNasc;

    private final String[] estadoCivilPermitido = {"Solteiro", "Casado", "Separado", "Divorciado", "Viuvo"};

    public Pessoa(String CPF, String nome, String endereco, String dataNasc, String estadoCivil) {
        this.CPF = CPF; // mudar inserindo o algoritmo de validação
        this.nome = nome;
        this.endereco = endereco;
        this.dataNasc = LocalDate.parse(dataNasc);
        
        // tentar usar try-cacth aqui
        if (testarEstadoCivil(estadoCivil))
            this.estadoCivil = estadoCivil;
        else 
            System.out.println("ERRO: estado civil invalido");
    }

    public Pessoa(String CPF, String nome){
        this.CPF = CPF; // mudar inserindo o algoritmo de validação
        this.nome = nome;
    }

    private boolean testarEstadoCivil(String estadoCivil) {
        for (int i = 0; i < this.estadoCivilPermitido.length; i++){
            if (this.estadoCivilPermitido[i].equals(estadoCivil))
                return true;
        }
        return false;
    }

    // Gets
    public String getCPF(){return CPF;}
    public String getNome(){return nome;}
    public String getEndereco(){return endereco;}
    public String getEstadoCivil(){return estadoCivil;}
    public LocalDate getDataNasc(){return dataNasc;}

    // Sets
    public void setNome(String nome){this.nome = nome;}
    public void setEndereco(String endereco){this.endereco = endereco;}
    
    public void setEstadoCivil(String estadoCivil){
        if (testarEstadoCivil(estadoCivil))
            this.estadoCivil = estadoCivil;
        else 
            System.out.println("ERRO: estado civil invalido");
    }

    // Não temos outros sets, pq semanticamente não fazem sentido
}
