package Agencias;
import Pessoas.Gerente;

public class Main {
    public static void main(String[] args) {
        Gerente g = new Gerente("15754828608", "Ze", "rua 0", "2022-01-01", "Casado", "0", "0", false, "Abobora", 0, 0, "2022-01-01", 0, false, 0);
        Agencia a = new Agencia("Araguari", "rua 1", g);
        a.print();

        Agencia b = new Agencia("Uberlandia", "rua 2", g);
        b.print();
    }
}
