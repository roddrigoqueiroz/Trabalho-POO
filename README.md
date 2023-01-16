# Requisitos de implementação

Este arquivo contém os requisitos de implementação do sistema de agência bancária para o trabalho de POO da UFU.

# Detalhes de Conta

- Superclasse asbtrata de: Corrente, Poupança e Salário
- Exigir senha para fazer transações
- Contas inativas são mantidas
- Contas devem ter pelo menos 1 cliente associado (podem ter mais de um -> conta conjunta)
- O mesmo cliente pode ter mais de uma conta
- **Atributos de Conta:**
    - número da conta;
    - saldo atual;
    - data de abertura;
    - data da última modificação;
    - nome/nro da agência;
    - ativa (sim/não)
    - senha
    - cliente(s) dono(s)

## Detalhes de Conta Corrente

- **Atributos da conta corrente**
    - limite do cheque especial;
    - taxa de administração;

## Detalhes de Conta Poupança

- **Atributos da conta poupança**
    - rendimento do mês atual

## Detalhes de Conta Salário

- **Atributos da conta salário**
    - limite de saque;
    - limite de transferência;


# Detalhes de Pessoa

- Superclasse abstrata de Cliente, Funcionário e Gerente
- **Atributos em comum:**
    - CPF
    - nome completo;
    - endereço completo;
    - estado civil;
    - data de nasc
- **Métodos em comum:**
    - Validação de CPF

## Detalhes de Cliente

- Classe final
- Herda Pessoa
- Podem fazer transações bancárias
- Construtor de cliente recebe nome e CPF
- Construtor padrão (sem argumentos) para cliente
- **Atributos de Cliente:**
    - escolaridade;
    - talvez agencia em que foi cadastrado
- **Métodos de Cliente:**
    - ainda não sei

## Detalhes de Funcionário

- Classe final e superclasse de Gerente
- Herda Pessoa
- **Atributos de Funcionário:**
    - número da CLT;
    - RG;
    - sexo;
    - cargo;
    - salário;
    - ano de ingresso
- **Métodos de Funcionário:**
    - calcula salário (salário base + 10% se +15 de empresa)

## Detalhes de Gerente

- Classe final
- Herda Funcionário
- Apenas um gerente pra cada agência
- calcula salário usa calcula salário de funcionário + comissão
- **Atributos de Gerente:**
    - data de ingresso como gerente
    - nome ou exclusivo número da agência gerenciada;
    - curso de gerência (sim/não)
    - comissão
- **Métodos de Gerente:**
    - get/set de comissão
    - calcula salário

# Detalhes de Transação

- Não entendi pra que serve
    - Se cada método que realizar uma transação (saque, depósito, consulta e pagamento) estiver contindo em Conta e, a cada chamada destes métodos, for criado e retornado um objeto do tipo Transação, essa classe faz sentido

- Classe final
- Construtor recebe conta e data
- Transação pode mexer no valor do saldo
- Armazenar o saldo da transação, mas não armazenar o tipo
- Transações só podem ser dos tipos descritos

- Transação gera - talvez tenham que ser atributos:
    - data;
    - valor da transação;
    - canal (internet banking, caixa eletrônico ou caixa físico)
- Tipos de transações - talvez tenham que ser métodos:
    - saque -> limitado por saldo em conta;
    - depósito -> precisa ser > 0;
    - cosultar saldo;
    - efetuar pagamento -> limitado por saldo em conta;

# Detalhes de Agência

- Classe final
- Deve existir para oprações que envolvem agência funcionarem (eu acho)
- **Atributos das agências**
    - número;
    - nome fictício;
    - endereço -> cidade, bairro e estado são muito usados p/ busca
    - gerente;

# Detalhes de implementação

- Implementar algoritmo real de validação de CPF
- Toda classe deve ter pelo menos um construtor
- Implementar usando herança onde estiver marcado neste arquivo
- Implementar classe Pessoa como abstrata
- Criar um requisito pra criar uma classe abstrata -> Feito -> classe abstrata conta