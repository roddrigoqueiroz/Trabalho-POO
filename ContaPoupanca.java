import java.util.Random;

public class ContaPoupanca extends Conta{
    private double rendimento = 1;

    ContaPoupanca(String senha, Cliente cliente, double numeroDaConta, double numeroAgencia, double rendimento){
        super(senha, cliente, numeroDaConta, numeroAgencia);
        simulaVariacaoRendimento();//substituir pela linha de baixo mais tarde
        //this.rendimento = rendimento;
    }

    protected void dadosDaConta(){
        System.out.println(super.dadosDaContaSuper() + "\n" +
            "Rendimento: " + rendimento + "\n");
    }
    //COLOCAR ESSA FUNCAO NO MENU CENTRAL DE OPERACOES PARA TODAS CONTAS USAREM O MESMO RENDIMENTO
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void simulaVariacaoRendimento(){ //utilizar toda vez que houver uma transacao
        Random r = new Random();
        rendimento = 1; //rendimento volta para 1 pois poderia ficar ridiculamente alto caso contrario
        rendimento = rendimento * r.nextDouble(1,1.3); /*gera um numero entre 1 e 1.3 toda vez que a funcao
                                                            *for chamada para simular a variacao do rendimento */                                                 
    }

    public double getRendimento(){
        return rendimento;
    }

    public void setRendimento(double rendimento){
        this.rendimento = rendimento;
    }
    
}
