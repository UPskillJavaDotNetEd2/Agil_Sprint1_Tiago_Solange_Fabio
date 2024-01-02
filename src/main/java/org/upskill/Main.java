package org.upskill;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe principal que contém o método `main` para execução do programa.
 */
public class Main {
    static Random random = new Random();

    /**
     * Método principal que inicia a execução do programa.
     *
     * @param args Os argumentos de linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {

        // criação de uma instância da classe Ginásio;
        Ginasio ginasio = gerarGinasio();
        ArrayList<Pessoa> clientesDoGinasio = ginasio.getPessoasQueFrequentamOGinasio();

        System.out.println(ginasio);

        // criação de uma listagem de Treinadores, apresentando o nome dos Treinadores, a sua idade,
        // o número de sessões como Personal Trainer e o seu vencimento no final do mês;
        calcularApresentarTreinadores(ginasio);

        // apresentação da quantidade de instâncias de clientes criados, sem percorrer o contentor;
        Utils.printTitle("Quantidade de Clientes", ':', true, false);
        System.out.println(String.format("Quantidade de clientes: %d", Cliente.getContadorCliente()));

        // calcular e apresentar o valor a pagar por cada tipo de cliente, percorrendo apenas uma vez o
        //contentor. Deve ser também calculado e apresentado o valor total a pagar por todos os
        //clientes;
        calcularApresentarMensalidadeDeClientes(ginasio);

        // calcular e apresentar o saldo obtido pelo ginásio nesse mês mediante as receitas dos clientes
        //            e custos com os seus Funcionários e Treinadores;
        // 1- já temos mensalidade de clientes
        // 2- descobrir valor a pagar aos treinadores e funcionarios
        // 3- subtrair (diferença)
        calcularReceitaMensalDeGinasio(ginasio);

        // calcular e apresentar, para cada género, a média do seu IMC;
        calcularMediaDeIMCPorGenero(clientesDoGinasio);
    }

    /**
     * Gera uma instância da classe Ginasio com pessoas aleatórias.
     *
     * @return Uma instância da classe Ginasio.
     */
    public static Ginasio gerarGinasio() {
        Ginasio ginasio = new Ginasio("UpGym", "Amarante");
        int quantidadeDePessoas = random.nextInt(9, 20);
        for (int i = 0; i < quantidadeDePessoas; i++) {
            ginasio.addPessoa(getRandomPessoa());
        }
        return ginasio;
    }

    /**
     * Calcula e apresenta a listagem de Treinadores com nome, idade, número de sessões como Personal Trainer
     * e vencimento no final do mês.
     *
     * @param ginasio A instância da classe Ginasio.
     */
    public static void calcularApresentarTreinadores(Ginasio ginasio) {
        Utils.printTitle("Listagem de Treinadores com Vencimento", ':', true, false);
        ArrayList<Treinador> treinadores = ginasio.getTreinadores();
        for (Treinador t : treinadores) {
            System.out.println(String.format("Treinador: %s, Idade: %d, Nº Sessões: %d, Vencimento: %.2f€",
                    t.getNome(), Data.calcularAnos(t.dataNascimento, Data.now()), t.getSessoesDePT(), t.calcularVencimento()));
        }
    }

    /**
     * Calcula e apresenta o valor a pagar por cada tipo de cliente, percorrendo apenas uma vez o contentor.
     * Deve ser também calculado e apresentado o valor total a pagar por todos os clientes.
     *
     * @param ginasio A instância da classe Ginasio.
     * @return O valor total a pagar por todos os clientes.
     */
    public static double calcularApresentarMensalidadeDeClientes(Ginasio ginasio) {
        ArrayList<Cliente> clientes = ginasio.getClientes();

        Utils.printTitle("Mensalidade de Clientes", ':', true, false);
        double mensalidadeTotalClientes = 0;
        for (Cliente cliente : clientes) {
            if (cliente == null || cliente instanceof Cliente == false)
                continue;

            double mensalidade = cliente.calcularPagamentoMensal();
            mensalidadeTotalClientes += mensalidade;

            System.out.println(String.format("Cliente: %s, Mensalidade: %.2f€", cliente.getNome(), mensalidade));
        }

        System.out.println(String.format("\nMensalidade Total: %.2f€", mensalidadeTotalClientes));
        return mensalidadeTotalClientes;
    }

    /**
     * Calcula e apresenta o saldo obtido pelo ginásio nesse mês mediante as receitas dos clientes
     * e custos com os seus Funcionários e Treinadores.
     *
     * @param ginasio A instância da classe Ginasio.
     * @return O saldo obtido pelo ginásio.
     */
    public static double calcularReceitaMensalDeGinasio(Ginasio ginasio) {
        double totalidadeDeDespesa = 0;
        double mensalidadeTotalClientes = calcularApresentarMensalidadeDeClientes(ginasio);
        double diferenca;

        Utils.printTitle("Vencimento de todos os Funcionários do Ginásio", ':', true, false);
        for (Pessoa pessoa : ginasio.getPessoas()) {
            if (pessoa != null && pessoa instanceof FuncionarioBase) {
                FuncionarioBase funcionarioBase = (FuncionarioBase) pessoa;
                double vencimento = funcionarioBase.calcularVencimento();

                if (Funcionario.class.isInstance(funcionarioBase))
                    System.out.println(String.format("Vencimento de Funcionário %s: %.2f", pessoa.getNome(), vencimento));
                else if (Treinador.class.isInstance(funcionarioBase))
                    System.out.println(String.format("Vencimento de Treinador %s: %.2f", pessoa.getNome(), vencimento));

                totalidadeDeDespesa += vencimento;
            }
        }

        diferenca = mensalidadeTotalClientes - totalidadeDeDespesa;

        Utils.printTitle("Receita Mensal do Ginásio", ':', true, false);
        System.out.println(String.format("Saldo Obtido: %.2f€ \nDespesa: %.2f€ \nLucro: %.2f€", mensalidadeTotalClientes, totalidadeDeDespesa, diferenca));

        return diferenca;
    }

    /**
     * Calcula e apresenta, para cada género, a média do seu IMC.
     *
     * @param clientes A lista de clientes.
     */
    public static void calcularMediaDeIMCPorGenero(ArrayList<Pessoa> clientes) {
        Utils.printTitle("Média de IMC Por Género", ':', true, false);
        double totalMasculino = 0, totalFeminino = 0, totalOutro = 0;
        int qtdMasculino = 0, qtdFeminino = 0, qtdOutro = 0;

        for (int i = 0; i < clientes.size(); i++) {
            Genero genero = clientes.get(i).getGenero();
            double imc = ((Cliente) clientes.get(i)).calcularIMC();

            switch (genero) {
                case MASCULINO -> {
                    totalMasculino += imc;
                    qtdMasculino++;
                }
                case FEMININO -> {
                    totalFeminino += imc;
                    qtdFeminino++;
                }
                case OUTRO -> {
                    totalOutro += imc;
                    qtdOutro++;
                }
            }
        }

        double mediaMasculino = qtdMasculino > 0 ? totalMasculino / qtdMasculino : 0;
        double mediaFeminino = qtdFeminino > 0 ? totalFeminino / qtdFeminino : 0;
        double mediaOutro = qtdOutro > 0 ? totalOutro / qtdOutro : 0;

        System.out.println(String.format("Média Masculino: %.2f", mediaMasculino));
        System.out.println(String.format("Média Feminino: %.2f", mediaFeminino));
        System.out.println(String.format("Média Outro: %.2f", mediaOutro));
    }

    /**
     * Gera uma pessoa aleatória (Cliente, Treinador ou Funcionário).
     *
     * @return Uma instância de Pessoa aleatória.
     */
    public static Pessoa getRandomPessoa() {
        int randPessoaID = random.nextInt(3);

        switch (randPessoaID) {
            case 0:
                return getRandomCliente();
            case 1:
                return getRandomTreinador();
            case 2:
                return getRandomFuncionario();
            default:
                return getRandomCliente();
        }
    }

    /**
     * Gera um cliente aleatório (ClienteRegular, ClienteConvidado ou ClienteEsporadico).
     *
     * @return Uma instância de Cliente aleatório.
     */
    public static Cliente getRandomCliente() {
        int randClientID = random.nextInt(3);

        switch (randClientID) {
            case 0:
                return getRandomClienteRegular();
            case 1:
                return getRandomClienteConvidado();
            case 2:
                return getRandomClienteEsporadico();
            default:
                return getRandomClienteRegular();
        }
    }

    /**
     * Gera um ClienteRegular aleatório.
     *
     * @return Uma instância de ClienteRegular aleatório.
     */
    public static ClienteRegular getRandomClienteRegular() {
        return new ClienteRegular(
                Utils.getRandomNomeCompleto(),                      // nome
                getRandomGenero(),                                  // genero
                Utils.getRandomMorada(),                            // morada
                getRandomData(),                                    // data
                random.nextDouble(1, 2),                 // altura
                random.nextDouble(30, 120),              // peso
                random.nextInt(10),                           // aulas hidro
                random.nextDouble(15, 35),               // mensalidade
                Utils.nextTrueOrFalse(),                            // is ativo
                random.nextInt(2, 50),                   // sessões pt
                random.nextDouble(50, 70)                // preço pt
        );
    }

    /**
     * Gera um ClienteConvidado aleatório.
     *
     * @return Uma instância de ClienteConvidado aleatório.
     */
    public static ClienteConvidado getRandomClienteConvidado() {
        return new ClienteConvidado(
                Utils.getRandomNomeCompleto(),                      // nome
                getRandomGenero(),                                  // genero
                Utils.getRandomMorada(),                            // morada
                getRandomData(),                                    // data
                random.nextDouble(1, 2),                 // altura
                random.nextDouble(30, 120),              // peso
                random.nextInt(10),                           // aulas hidro
                random.nextDouble(12, 24),               // horas gratuitas
                random.nextInt(10),                           // numero de aulas
                random.nextInt(2, 20),                   // numero de sessões pt
                random.nextDouble(50, 70)                // preço de PT
        );
    }

    /**
     * Gera um ClienteEsporadico aleatório.
     *
     * @return Uma instância de ClienteEsporadico aleatório.
     */
    public static ClienteEsporadico getRandomClienteEsporadico() {
        return new ClienteEsporadico(
                Utils.getRandomNomeCompleto(),                      // nome
                getRandomGenero(),                                  // genero
                Utils.getRandomMorada(),                            // morada
                getRandomData(),                                    // data
                random.nextDouble(1, 2),                 // altura
                random.nextDouble(30, 120),              // peso
                random.nextInt(10),                           // aulas hidro
                random.nextDouble(12, 24),               // horas gratuitas
                random.nextInt(10)                            // numero de aulas
        );
    }

    /**
     * Gera um Treinador aleatório.
     *
     * @return Uma instância de Treinador aleatório.
     */
    public static Treinador getRandomTreinador() {
        // (String nome, Genero genero, String morada, Data dataNascimento, int sessoesDePT, double valorPorSessaoPT, double vencimento)
        return new Treinador(
                Utils.getRandomNomeCompleto(),                      // nome
                getRandomGenero(),                                  // genero
                Utils.getRandomMorada(),                            // morada
                getRandomData(),                                    // data
                random.nextInt(15),                            // sessoes pt
                random.nextDouble(15, 30),                // valor por sessão
                random.nextDouble(450, 850)               // vencimento
        );
    }

    /**
     * Gera um Funcionário aleatório.
     *
     * @return Uma instância de Funcionário aleatório.
     */
   

    /**
     * Gera um valor aleatório do enum Genero.
     *
     * @return Um valor aleatório do enum Genero.
     */
    

    /**
     * Gera uma instância de Data com valores de ano, mês e dia aleatórios dentro de um intervalo específico.
     *
     * @return Uma instância de Data com valores aleatórios.
     */
    public static Data getRandomData() {
        return new Data(random.nextInt(1980, 2001), random.nextInt(13), random.nextInt(31));
    }


}