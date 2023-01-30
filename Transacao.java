import java.time.LocalDate;

public class Transacao {

    private LocalDate data;
    private Conta c;
    private String canal;

    Transacao(Conta c, LocalDate data, String canal){
        this.data = data;
        this.c = c;
        this.canal = canal;
    }

    public String printRecibo(){
        return  "Recibo" + "\n" +
                "Saldo anterior: " + c.getValorAux() + "\n" +
                "Saldo atual: " + c.getSaldo() + "\n" +
                "Data: " + data +
                "Canal: " + canal;
    }
}
