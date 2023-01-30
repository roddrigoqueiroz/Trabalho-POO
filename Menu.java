import Pessoas.*;
import java.util.Scanner;
import Agencias.*;
import Exceptions.LoginFalsoException;

import java.io.*;
import java.util.LinkedList;
/**
 * TO DO:
 * - Arrumar pertencimento de conta(cliente possuir as contas)// PRECISO TESTAR MAIS TARDE

 * - Login de Administrador
 * - achar um jeito de por erro no login
 * - Criar agencias (login adm) e mostrá-las para método criarConta
 * - Fazer variáveis com nomes para cada construtor
 * - Colocar array de contas do cliente
 */

public class Menu {
    private boolean logado = false;
    private double numeroDaConta = 1; //serve para dar numero para as contas, somando mesmo pois nao entendi o q era p ser
    private LinkedList<Cliente> listaCliente = new LinkedList<Cliente>();
    private LinkedList<Conta> listaConta = new LinkedList<Conta>();
    private LinkedList<Administrador> listaAdministrador = new LinkedList<Administrador>();
    private LinkedList<Agencia> listaAgencia = new LinkedList<Agencia>();
    private LinkedList<Gerente> listaGerente = new LinkedList<Gerente>();
    private LinkedList<Funcionario> listaFuncionario = new LinkedList<Funcionario>();
    private LinkedList<Transacao> listaTransacao = new LinkedList<Transacao>();
    private Administrador administradorAtivo;
    private Cliente clienteAtivo;
    
    Scanner in = new Scanner(System.in);
    
    Menu(){}

    public void start(){
        int op;
        while(true){
            System.out.printf("\n\nBem vindo a Agencia Bancaria da UFU!!\n");
            System.out.println("1.Fazer login");
            System.out.println("2.Criar conta");
            System.out.println("3.Login Administrador");
            System.out.println("4.Criar Administrador");
            System.out.println("5.Sair");
            System.out.printf("Opcao: ");
            op = in.nextInt();
            System.out.printf("\n");
            switch(op){
                case 1:
                    try {
                        loginCLiente();
                    } catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    criarConta();
                    break;
                case 3:
                    try {
                        loginAdministrador();
                        opcoesAdministrador();
                        break;
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 4:
                    criarAdministrador();
                    break;
                case 5:
                    in.close();
                    return;
                default:System.out.println("Valor digitado invalido");
        }
    }
}
    public void loginAdministrador() throws Exception {
        if (administradorAtivo.estaLogado())
            return;
        System.out.print("Digite seu login de Administrador: ");
        String loginAdm = in.next();

        System.out.print("Digite sua senha de Administrador: ");
        String senhaAdm = in.next();

        for (Administrador administrador : listaAdministrador) {
            if (loginAdm.equals(administrador.getLogin()) && 
                senhaAdm.equals(administrador.getSenha())){
                administradorAtivo = administrador;
                administradorAtivo.setLogado();
                return;
            }
        }

        throw new Exception("Erro!! Administrador inexistente ou senha errada. Tente novamente.");
    }

    public void criarAdministrador(){
        System.out.print("Crie seu login: ");
        String loginAdm = in.next();

        System.out.print("Crie sua senha: ");
        String senhaAdm = in.next();


        Administrador adm = new Administrador(loginAdm, senhaAdm);
        administradorAtivo = adm;
        listaAdministrador.add(adm);
        administradorAtivo.setLogado();
    }

    public void opcoesAdministrador() throws Exception {
        if (!administradorAtivo.estaLogado())
            throw new LoginFalsoException("Erro!! Voce nao fez o login");
        
        int op;
        while(true){
            System.out.printf("\n\n=======MENU ADMINISTRADOR======\n");
            System.out.println("1.Cadastrar novo cliente");
            System.out.println("2.Cadastrar nova agencia");
            System.out.println("3.Cadastrar novo funcionario");
            System.out.println("4.Cadastrar novo gerente");
            System.out.println("5.Voltar ao menu anterior");
            System.out.print("Opcao: ");
            op = in.nextInt();

            switch(op){
                case 1:
                    break;
                case 2:
                    try {
                        criarAgencia();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    break;
                case 4:
                    criarGerente();
                    break;
                case 5:
                    return;
                default: System.out.println("Valor digitado invalido");
            }
        }
    }

    // problema com endereço por causa do espaço
    public void criarGerente(){
        String CPF, nome, endereco, dataNasc, estadoCivil, CLT, RG, dataIngresso;
        char sexo;
        boolean cursoGerencia;
        double salario, comissao;
        int anoIngresso;

        System.out.printf("\n======Cadastro do Gerente======\n");

        System.out.print("Digite o CPF: ");
        CPF = in.next();
        System.out.print("Digite o nome: ");
        nome = in.next();
        System.out.print("Digite o endereco: ");
        endereco = in.next();
        System.out.print("Digite a data de nascimento: ");
        dataNasc = in.next();
        System.out.print("Digite o estado civil(Solteiro, Casado, Separado, Divorciado, Viuvo): ");
        estadoCivil = in.next();
        System.out.print("Digite a CLT: ");
        CLT = in.next();
        System.out.print("Digite o RG: ");
        RG = in.next();
        System.out.print("Digite o sexo(M ou F): ");
        sexo = in.next().charAt(0);
        System.out.print("Digite o salario a ser recebido: ");
        salario = in.nextDouble();
        System.out.print("Digite a comissao por vendas: ");
        comissao = in.nextDouble();
        System.out.print("Digite o ano de ingresso na empresa: ");
        anoIngresso = in.nextInt();
        System.out.print("Digite a data de ingresso como gerente: ");
        dataIngresso = in.next();
        System.out.print("Esta fazendo curso de gerencia?(true ou false): ");
        cursoGerencia = in.nextBoolean();

        listaGerente.add(new Gerente(CPF, nome, endereco, dataNasc, estadoCivil, CLT, RG, sexo, salario, anoIngresso, dataIngresso, cursoGerencia, comissao));

        System.out.println("Gerente criado com sucesso!");

        return;
    }

    public void criarAgencia() throws Exception {
        boolean existeGerente = false;
        Gerente gerenteDaAgencia = null;

        System.out.printf("\n=======Criar Agencia======\n");
        while(!existeGerente){
            System.out.print("Digite o nome do gerente da agencia: ");
            String nomeGerente = in.next();

            for (Gerente gerente : listaGerente) {
                if (nomeGerente.equals(gerente.getNome()) && !gerente.getEstaGerindo()){
                    existeGerente = true;
                    gerenteDaAgencia = gerente;
                    break;
                }
            }
            if (!existeGerente){
    
                throw new Exception("Erro!! Este gerente nao existe ou ja esta gerindo alguma agencia. Tente novamente.");
            }
        }
        System.out.print("Digite o nome da agencia: ");
        String nomeAgencia = in.next();
        System.out.print("Digite o endereco da agencia: ");
        String enderecoAgencia = in.next();

        listaAgencia.add(new Agencia(nomeAgencia, enderecoAgencia, gerenteDaAgencia));
        return;
    }

    public void loginCLiente() throws Exception {
        if (logado)
            return;

        String login, senha;
        System.out.println("======Login Cliente======");
        System.out.print("Digite seu nome: ");
        login = in.nextLine();
        System.out.print("Digite a senha da conta que deseja acessar: ");
        senha = in.nextLine();

        for (Cliente cliente : listaCliente) {
            if (login.equals(cliente.getNome()) && achaSenha(cliente.getNome(), senha)){
                logado = true;
                return;
            }
        }

        throw new Exception("Erro!! Usuario inexistente ou senha errada. Tente novamente.");
    }
    // public void mudarSenha(){}

    public void criarConta(){
        int op, numeroAgencia;
        String nome, CPF, senha;
        Agencia agencia = null;

        System.out.println("\n======Criar Conta======");

        System.out.printf("Informar seu nome: ");
        nome = in.next();
        System.out.printf("\nInformar seu CPF: ");
        CPF = in.next();
        System.out.printf("\nInforme o numero da agencia que esta realizando o cadastro: ");
        numeroAgencia = in.nextInt();

        try {
            agencia = buscaAgencia(numeroAgencia);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Tente novamente.");
        }

        Cliente cliente = new Cliente(nome, CPF, agencia);
        listaCliente.add(cliente);

        System.out.printf("\nCrie sua senha: ");
        senha = in.nextLine();
        
        System.out.println("Escolha o tipo de conta: ");
        System.out.printf("1.Conta Corrente");
        System.out.printf("\n2.Conta Poupanca");
        System.out.printf("\n3.Conta Salario");
        System.out.printf("\nOpcao: ");
        op = in.nextInt();
        switch(op){
            case 1: Conta cc = new ContaCorrente(senha, cliente, numeroDaConta, numeroAgencia, 300, 1.3); // este erro é mentira
                listaConta.add(cc);
                numeroDaConta++;
                break;
            case 2: Conta cpoupanca = new ContaPoupanca(senha, cliente,  numeroDaConta, numeroAgencia, 1); 
                listaConta.add(cpoupanca);
                numeroDaConta++;
                break;
            case 3: Conta cs = new ContaSalario(senha, cliente,  numeroDaConta, numeroAgencia, 2000,  600);
                listaConta.add(cs);
                numeroDaConta++;
                break;
            default:System.out.println("Valor digitado invalido");
        }
        System.out.println("Conta criada com sucesso!!");

    
    }

    public Agencia buscaAgencia(int numeroAgencia) throws Exception {
        for (Agencia agencia : listaAgencia) {
            if (numeroAgencia == agencia.getNumero())
                return agencia;
        }
        throw new Exception("Erro!! Numero errado ou agencia inexistente");
    }
    
    public void salvarLista(LinkedList<Object> lista, String nomeArquivo) throws Exception {
        if (lista.isEmpty())
            throw new Exception("Lista vazia. Nao foi possivel salvar.");

        try {
            ObjectOutputStream serializador = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            serializador.writeObject(lista);
            serializador.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void logoff(){
        logado = false;
    }

    private boolean achaSenha(String nome, String senha){
        for (Conta conta : listaConta){
            if (senha.equals(conta.getSenha()) && nome.equals(conta.getDono()))
                return true;
        }
        return false;
    }
    
}
