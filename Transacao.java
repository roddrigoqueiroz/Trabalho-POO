import java.time.LocalDate;

public class Transacao {

    private LocalDate data;
    private Conta c;
    private double valorAux;
    private String canal;

    Transacao(Conta c, LocalDate data, String canal){
        this.data = data;
        this.c = c;
        this.canal = canal;
    }

    public void saque(double valor){
        if(c.getSaldo()<valor){throw new Error("Erro!! Saldo insuficiente!");}
        else {
            valorAux = c.getSaldo();
            c.setSaldo(-valor);}
        printRecibo();
    }

    public void deposito(double valor){
        if(valor>0){
        valorAux = c.getSaldo();
        c.setSaldo(c.getSaldo()+valor);}
        else{throw new Error("Erro!! O valor deve ser maior que 0");}
        printRecibo();
    }

    public double consultarSaldo(){
        return c.getSaldo();
    }

    public void pagamento(double valor){ //eh a mesma coisa que saque...
        if(valor>c.getSaldo()){throw new Error("Erro!! Saldo insuficiente!");}
        else{
            valorAux = c.getSaldo();
            c.setSaldo(-valor);
        }
        printRecibo();
    }

    public String printRecibo(){
        return  "Recibo" + "\n" +
                "Saldo anterior: " + valorAux + "\n" +
                "Saldo atual: " + c.getSaldo() + "\n" +
                "Data: " + data +
                "Canal: " + canal;
    }
}
