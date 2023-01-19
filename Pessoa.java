// filtrar melhor os erros do try-catch com uma classe especifica
// fonte pra criar a classe: https://rollbar.com/blog/java-exceptions-hierarchy-explained/#

import java.time.LocalDate;
import java.lang.Integer;

public abstract class Pessoa {
    protected String CPF;
    protected String nome;
    protected String endereco;
    protected String estadoCivil;
    protected LocalDate dataNasc;

    private final String[] estadoCivilPermitido = {"Solteiro", "Casado", "Separado", "Divorciado", "Viuvo"};

    public Pessoa(String CPF, String nome, String endereco, String dataNasc, String estadoCivil) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNasc = LocalDate.parse(dataNasc);
        
        try {
            testarCPF(CPF);
            this.CPF = CPF;
            testarEstadoCivil(estadoCivil);
            this.estadoCivil = estadoCivil;
        } 
        catch (Error e){
            System.out.println(e);
        }
    }

    public Pessoa(String CPF, String nome){
        this.CPF = CPF; // mudar inserindo o algoritmo de validação
        this.nome = nome;
    }



// MÉTODOS DE TESTE DE ATRIBUTOS

    // Espera receber um CPF sem pontos e traços
    protected boolean testarCPF(String strCPF) {
        int soma;
        int resto;
        soma = 0;   
        //strCPF  = RetiraCaracteresInvalidos(strCPF,11);
        if (testarCPFUnidigito(strCPF) || strCPF.length() != 11)
            throw new Error("ERRO: CPF invalido");

        for (int i = 1; i <= 9; i++)
            soma = soma + Integer.parseInt(strCPF.substring(i-1, i)) * (11 - i); 
        
        resto = (soma * 10) % 11;
        if ((resto == 10) || (resto == 11)) 
            resto = 0;
        
        if (resto != Integer.parseInt(strCPF.substring(9, 10)) )
            throw new Error("ERRO: CPF invalido");
        
        soma = 0;
        for (int i = 1; i <= 10; i++)
           soma = soma + Integer.parseInt(strCPF.substring(i-1, i)) * (12 - i);
        
        resto = (soma * 10) % 11;
        if ((resto == 10) || (resto == 11)) 
            resto = 0;
        if (resto != Integer.parseInt(strCPF.substring(10, 11) ) )
            throw new Error("ERRO: CPF invalido");
        return true;
    }

    private boolean testarEstadoCivil(String estadoCivil) {
        for (int i = 0; i < this.estadoCivilPermitido.length; i++){
            if (this.estadoCivilPermitido[i].equals(estadoCivil))
                return true;
        }
        throw new Error("ERRO: estado civil invalido");
    }

    // true se CPF for unidígito, false caso contrário
    // TÁ RETORNANDO ALGUMA COISA ERRADA
    private boolean testarCPFUnidigito(String strCPF){
        for (int i = 1; i <= strCPF.length(); i++){
            if (strCPF.substring(0,1) != strCPF.substring(i-1, i))
                return false;
        }
        return true;
    }


// GETS
    public String getCPF(){return CPF;}
    public String getNome(){return nome;}
    public String getEndereco(){return endereco;}
    public String getEstadoCivil(){return estadoCivil;}
    public LocalDate getDataNasc(){return dataNasc;}

// SETS
    public void setNome(String nome){this.nome = nome;}
    public void setEndereco(String endereco){this.endereco = endereco;}
    
    public void setEstadoCivil(String estadoCivil){
        // tentar substituir pro try-catch
        try {
            testarEstadoCivil(estadoCivil);
            this.estadoCivil = estadoCivil;
        }
        catch(Error e){ 
            System.out.println(e);
        }
    }

    // Não temos outros sets, pq semanticamente não fazem sentido
}
