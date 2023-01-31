package Pessoas;
import Agencias.Agencia;

public class Main {
    public static void main(String[] args) {
        Gerente g = new Gerente("76886069004", "Ze", "rua 0", "2022-01-01", 
        "Casado", "0", "0", 'M', 0, 
        0, "2022-01-01", 0, false, 0);
        
        Agencia a = new Agencia("santander", "aqui", g);
        Cliente c = new Cliente("49188699048", "pedro", a);
        Funcionario f = new Funcionario(a);

        a.print();
        a.printClientes();
        a.printFuncionarios();
    }
}
