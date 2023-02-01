import Pessoas.*;
import java.util.Scanner;
import Agencias.*;
import Exceptions.*;

import java.io.*;
import java.util.LinkedList;
/**
 * TO DO:
 * - Arrumar pertencimento de conta(cliente possuir as contas)// PRECISO TESTAR MAIS TARDE
 * - CriarConta possui deve perguntar se já é cliente ou não antes de criá-lo
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
    private Administrador administradorAtivo = new Administrador();
    private Cliente clienteAtivo;

    private final String CLIENTE_SER = "lista-cliente.ser";
    private final String CONTA_SER = "lista-conta.ser";
    private final String ADMIN_SER = "lista-admin.ser";
    private final String AGENCIA_SER = "lista-agencia.ser";
    private final String GERENTE_SER = "lista-gerente.ser";
    private final String FUNCIONARIO_SER = "lista-funcionario.ser";
    private final String TRANSACAO_SER = "lista-transacao.ser";
    
    Scanner in = new Scanner(System.in);
    
    Menu(){}

    public void start(){
        int op;
        carregar();
        while(true){
            System.out.printf("\n\nBem vindo a Agencia Bancaria da UFU!!\n");
            System.out.println("1.Fazer login");
            System.out.println("2.Criar conta");
            System.out.println("3.Login administrador");
            System.out.println("4.Criar administrador");
            System.out.println("5.Imprimir administradores");
            System.out.println("0.Salvar e sair");
            System.out.printf("Opcao: ");
            op = in.nextInt();
            System.out.printf("\n");
            switch(op){
                case 1:
                    try {
                        Conta c = loginCliente();
                        opcoesCliente(c);
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
                    for (Administrador a : listaAdministrador) {
                        a.print();
                    }
                    break;
                case 0:
                    in.close();
                    for (Administrador a : listaAdministrador) {
                        a.setDeslogado();
                    }
                    salvar();
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
                    criarConta();
                    break;
                case 2:
                    try {
                        criarAgencia();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    criarFuncionario();
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
    
    public void criarFuncionario(){
        String CPF, nome, endereco, dataNasc, estadoCivil, CLT, RG, cargo;
        double salario;
        char sexo;
        int anoIngresso;

        System.out.printf("\n======Cadastro do Funcionario======\n");

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
        System.out.print("Digite o cargo: ");
        cargo = in.next();
        System.out.print("Digite o sexo(M ou F): ");
        sexo = in.next().charAt(0);
        System.out.print("Digite o salario a ser recebido: ");
        salario = in.nextDouble();
        System.out.print("Digite o ano de ingresso na empresa: ");
        anoIngresso = in.nextInt();

        listaFuncionario.add(new Funcionario( CPF,  nome,  endereco,  dataNasc, estadoCivil,  CLT, RG,  sexo,
        cargo,  salario,  anoIngresso));

        System.out.println("Funcionario criado com sucesso!");

        return;
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

    public Conta loginCliente() throws Exception {
        String login, senha;
        System.out.println("======Login Cliente======");
        System.out.print("Digite seu nome: ");
        login = in.next();
        System.out.print("Digite a senha da conta que deseja acessar: ");
        senha = in.next();

        for (Cliente cliente : listaCliente) {
            if (login.equals(cliente.getNome()) && achaSenha(cliente.getNome(), senha)){
                logado = true;
                return achaContaDono(cliente, senha);
            }
        }

        throw new Exception("Erro!! Usuario inexistente ou senha errada. Tente novamente.");
    }

    public void criarConta(){
         int op, numeroAgencia;
        String nome, CPF, senha;
        Agencia agencia = null;

        System.out.println("\n======Criar Conta======");
        System.out.println("Ja possui uma conta?");
        System.out.println("1.Sim");
        System.out.println("2.Nao");
        System.out.print("Opcao: ");
        op = in.nextInt();

        
        System.out.print("Informar seu nome: ");
        nome = in.next();
        System.out.print("Informar seu CPF: ");
        CPF = in.next();
        System.out.print("Informe o numero da agencia que esta realizando o cadastro: ");
        numeroAgencia = in.nextInt();

        try {
            agencia = buscaAgencia(numeroAgencia);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Tente novamente.");
        }
        if(op == 2){
        Cliente cliente = new Cliente(CPF, nome, agencia);
        listaCliente.add(cliente);
    }
        Cliente cliente = achaNomeCliente(nome); /*esta criacao de cliente serve para o ja com uma conta
        nao precisar criar outro cliente, ja o que criou agora so faz a busca depois de ser adicionado a lista
        e eh selecionado para o resto do processo */
        
        System.out.print("Crie sua senha: ");
        senha = in.next();

        try {
            agencia = buscaAgencia(numeroAgencia);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Tente novamente.");
        }
        
        System.out.println("Escolha o tipo de conta: ");
        System.out.printf("1.Conta Corrente");
        System.out.printf("\n2.Conta Poupanca");
        System.out.printf("\n3.Conta Salario");
        System.out.printf("\nOpcao: ");
        op = in.nextInt();
        switch(op){
            case 1: Conta cc = new ContaCorrente(senha, cliente, numeroDaConta, numeroAgencia, 300, 0.005); // este erro é mentira
                listaConta.add(cc);
                numeroDaConta++;
                break;
            case 2: Conta cpoupanca = new ContaPoupanca(senha, cliente,  numeroDaConta, numeroAgencia, 1.1); 
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
    
    public void salvarLista(LinkedList<?> lista, String nomeArquivo) throws Exception {
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
    public LinkedList<?> carregarLista(String nomeArquivo) throws Exception {    
        File f = new File(nomeArquivo);
        if (f.exists()){
            try {
                ObjectInputStream desserializador = new ObjectInputStream(new FileInputStream(nomeArquivo));
                LinkedList<?> l = (LinkedList<?>)desserializador.readObject();
                desserializador.close();
                return l;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        throw new Exception("Nao foi possivel carregar o arquivo.");
    }

    public boolean salvar(){
        try {
            salvarLista(listaCliente, CLIENTE_SER);
            salvarLista(listaConta, CONTA_SER);
            salvarLista(listaAdministrador, ADMIN_SER);
            salvarLista(listaAgencia, AGENCIA_SER);
            salvarLista(listaGerente, GERENTE_SER);
            salvarLista(listaFuncionario, FUNCIONARIO_SER);
            salvarLista(listaTransacao, TRANSACAO_SER);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean carregar(){
        try {
            carregarLista(CLIENTE_SER);
            carregarLista(CONTA_SER);
            carregarLista(ADMIN_SER);
            carregarLista(AGENCIA_SER);
            carregarLista(GERENTE_SER);
            carregarLista(FUNCIONARIO_SER);
            carregarLista(TRANSACAO_SER);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
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
    public Conta achaContaDono(Cliente cliente, String senha){
        for (Conta conta : listaConta){
            if (cliente.getNome().equals(conta.getDono()) && senha.equals(conta.getSenha())){
                return conta;
            }

        }
        throw new ContaNaoEncontradaException("Conta nao foi encontrada");
    }

    public Cliente achaNomeCliente(String nome){
        for (Cliente cliente : listaCliente){
            if (nome.equals(cliente.getNome())){
                return cliente;
            }
        }
        throw new ContaNaoEncontradaException("Conta nao foi encontrada");
    }
    
    public void opcoesCliente(Conta parametro){
        Conta c = parametro;
        int op;
        double valor;
        String texto;
        Conta recebedor = null;
        if(c.getStatus().equals("Conta Desativada")){
            throw new ContaDesativadaException("Sua conta esta desativada, por favor contatar o suporte do banco");
        }
        while (logado){
            System.out.println(" ===Agencia Bancaria da UFU===");
            System.out.println("1.Fazer Saque");
            System.out.println("2.Fazer Transferencia");
            System.out.println("3.Fazer Deposito");
            System.out.println("4.Checar dados da conta");
            System.out.println("5.Mudar Senha");
            System.out.println("6.Desativar Conta");
            System.out.println("0.Sair");
            System.out.printf("Opcao: ");
            op = in.nextInt();
            System.out.printf("\n");
            if(c.getStatus().equals("Conta Desativada")){
                throw new ContaDesativadaException("Sua conta esta desativada, por favor contatar o suporte do banco");
            }
            switch(op){
                case(1):
                    System.out.println("Qual o valor do saque?"); 
                    valor = in.nextDouble();
                    try{
                        c.saque(valor);
                        System.out.println("Saque concluido com sucesso!!"); }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case(2):
                    System.out.println("Qual o valor da transferencia?");
                    valor = in.nextDouble();
                    System.out.println("Qual o numero da conta destino?");
                    double numeroConta = in.nextDouble();
                    for (Conta conta : listaConta) {
                        if (numeroConta == conta.getNumeroDaConta()){
                            recebedor = conta;
                        }
                    }
                    if(recebedor == null)throw new ContaNaoEncontradaException("Nao foi possivel encontrar a conta");
                    System.out.println("Transferencia concluida com sucesso!!");
                    c.pagamento(valor, recebedor);
                    break;
                case(3):
                    System.out.println("Qual o valor do deposito?"); 
                    valor = in.nextDouble();
                    try{
                        c.deposito(valor);
                        System.out.println("Deposito concluido com sucesso!!"); }
                    catch(Exception e){
                        System.out.println(e);
                    }
                case(4):
                    c.dadosDaConta();
                    break;
                case(5):
                    c.mudarSenha(logado);
                    break;
                case(6):
                    System.out.print("Digite sua senha para confirmar essa operacao\nSenha:");
                    texto = in.next();
                    if(texto.equals(c.getSenha())){
                        c.setStatus(false);
                        logoff();
                    }
                    else throw new SenhaIncorretamenteDigitadaException("Senha incorreta");
                case(0):
                    return;

                default: break;
            }
        }
    }
}
