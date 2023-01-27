import java.util.Scanner;
import java.util.LinkedList;
/**
 * TO DO:
 * - Arrumar taxa
 * - Arrumar pertencimento de conta(cliente possuir as contas)
 * - Achar pra que usa a taxa
 * - Implementar limite do saque na conta salario
 * - Fazer a lista funcionar
 */

public class Menu {
    private boolean logado;
    private double numeroAgencia = 58274913;
    private double numeroDaConta = 0; 
    private LinkedList<Cliente> lista = new LinkedList<Cliente>();
    
    Menu(){}
    public void start(){
        Scanner in = new Scanner(System.in);
        int op;
        while(true){
        System.out.println("Bem vindo a Agencia Bancaria da UFU!!");
        System.out.println("1.Fazer login");
        System.out.println("2.Registrar");
        System.out.printf("Opcao:");
        op = in.nextInt();
        System.out.printf("\n");
        switch(op){
            case 1:
                login();
                break;
            case 2:
                registrar();
                break;
            default:System.out.println("Valor digitado invalido");
        }


        while(true){
        System.out.println("=== Agencia Bancaria da UFU ===");
        }
    }
}
    public void login(){// incompleta
        
        Scanner in = new Scanner(System.in);
        String digitado = "";
        System.out.println("Por favor faca login");
        System.out.println("Digite o nome: ");
        digitado = in.nextLine();
        while(digitado != lista.peek().getNome()){//quero que veja o proximo, mas acho que o pop tira o elemento
            lista.pop();
            //AQUI CONTINUAA USANDO  FAZER FUNCAO DE BUSCA
        }
        System.out.println("Digite a senha: ");
        digitado = in.nextLine();
        //if(digitado == c.getSenha){
            logado = true;
            in.close();
        //}
        //else{in.close(); throw new Error("Erro!! Senha incorreta");}
    }
    public void recolocarSenha(){}

    public void registrar(){ //implementar junto com cliente
        int op;
        Scanner in = new Scanner(System.in);
        String buffer, buffer2, bufferSenha; //buffer da senha serve para "colocar" a senha antes de escolher o tipo de conta
        System.out.printf("\nInformar seu nome: ");
        buffer = in.nextLine();
        System.out.printf("\nInformar seu CPF: ");
        buffer2 = in.nextLine();
        Cliente cliente = new Cliente(buffer, buffer2);
        lista.add(cliente);
        System.out.printf("\nDigite sua senha desejada: ");
        bufferSenha = in.nextLine();
        System.out.printf("\n1.Conta Corrente");
        System.out.printf("\n2.Conta Poupanca");
        System.out.printf("\n3.Conta Salario");
        System.out.printf("\nOpcao: ");
        op = in.nextInt();
        switch(op){
            case 1: Conta cc = new ContaCorrente(bufferSenha, cliente, numeroDaConta, numeroAgencia, 300, 1.3);
                numeroDaConta++;
                break;
            case 2: Conta cpoupanca = new ContaPoupanca(bufferSenha, cliente,  numeroDaConta, numeroAgencia, 1); 
                numeroDaConta++;
                break;
            case 3: Conta cs = new ContaSalario(bufferSenha, cliente,  numeroDaConta, numeroAgencia, 2000,  600);
                numeroDaConta++;
                break;
            default:System.out.println("Valor digitado invalido");
        }
        System.out.println("Conta criada com sucesso!!");
        login();

    
    }

    protected void logoff(){
        logado = false;
    }
    
}
