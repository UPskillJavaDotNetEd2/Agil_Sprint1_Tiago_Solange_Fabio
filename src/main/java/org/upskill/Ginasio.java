package org.upskill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * Representa um ginásio que contém informações sobre o nome, morada e uma lista de pessoas.
 */
public class Ginasio {
    /** Nome do ginásio. */
    private String nome;

    /** Morada do ginásio. */
    private String morada;

    /** Lista de pessoas associadas ao ginásio. */
    private ArrayList<Pessoa> pessoas;

    /** Nome padrão para quando o nome não é especificado. */
    private static final String DEFAULT_NOME = "INVALID NOME";

    /** Morada padrão para quando a morada não é especificada. */
    private static final String DEFAULT_MORADA = "INVALID MORADA";

    /**
     * Construtor da classe Ginasio que recebe o nome, morada e uma lista de pessoas.
     *
     * @param nome    O nome do ginásio.
     * @param morada  A morada do ginásio.
     * @param pessoas A lista de pessoas associadas ao ginásio.
     */
    public Ginasio(String nome, String morada, ArrayList<Pessoa> pessoas) {
        this.nome = nome;
        this.morada = morada;
        this.pessoas = pessoas; // composição
    }

    /**
     * Construtor da classe Ginasio que recebe apenas o nome e a morada, inicializando a lista de pessoas vazia.
     *
     * @param nome   O nome do ginásio.
     * @param morada A morada do ginásio.
     */
    public Ginasio(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
        this.pessoas = new ArrayList<>();
    }

    /**
     * Construtor da classe Ginasio que inicializa o nome e a morada com valores padrão e a lista de pessoas vazia.
     */
    public Ginasio() {
        this.nome = DEFAULT_NOME;
        this.morada = DEFAULT_MORADA;
        this.pessoas = new ArrayList<>();
    }

    // Métodos de acesso e modificação

    /**
     * Obtém o nome do ginásio.
     *
     * @return O nome do ginásio.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a morada do ginásio.
     *
     * @return A morada do ginásio.
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Obtém uma cópia da lista de pessoas associadas ao ginásio.
     *
     * @return A lista de pessoas associadas ao ginásio.
     */
    public ArrayList<Pessoa> getPessoas() {
        return new ArrayList<>(pessoas);
    }

    /**
     * Obtém a quantidade de pessoas associadas ao ginásio.
     *
     * @return A quantidade de pessoas associadas ao ginásio.
     */
    public int getQuantidadeDePessoas() {
        return pessoas.size();
    }

    /**
     * Define o nome do ginásio.
     *
     * @param nome O novo nome do ginásio.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define a morada do ginásio.
     *
     * @param morada A nova morada do ginásio.
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Define a lista de pessoas associadas ao ginásio.
     *
     * @param pessoas A nova lista de pessoas associadas ao ginásio.
     */
    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas.clear();
        //this.pessoas.addAll(pessoas);
        this.pessoas.addAll(new ArrayList<>(pessoas));
    }

    /**
     * Adiciona uma pessoa à lista de pessoas do ginásio.
     *
     * @param pessoa A pessoa a ser adicionada.
     * @return true se a pessoa foi adicionada com sucesso, false caso contrário.
     */
    public boolean addPessoa(Pessoa pessoa) {
        if (pessoa == null || pessoas.contains(pessoa)) {
            return false;
        }

        pessoas.add(pessoa);
        return true;
    }

    /**
     * Remove uma pessoa da lista de pessoas do ginásio.
     *
     * @param pessoa A pessoa a ser removida.
     * @return true se a pessoa foi removida com sucesso, false caso contrário.
     */
    public boolean removePessoa(Pessoa pessoa) {
        return pessoas.remove(pessoa);
    }

    // Métodos específicos

    /**
     * Retorna o valor total dos vencimentos de todos os funcionários do ginásio.
     *
     * @return O valor total dos vencimentos dos funcionários.
     */
    public double getVencimentoDeTodosOsFuncionarios() {
        double total = 0;

        for (Pessoa pessoa : pessoas) {
            if (pessoa == null || !(pessoa instanceof Funcionario)) {
                continue;
            }

            Funcionario funcionario = (Funcionario) pessoa;
            total += funcionario.calcularVencimento();
        }

        return total;
    }

    /**
     * Retorna o valor total dos vencimentos de todos os treinadores do ginásio.
     *
     * @return O valor total dos vencimentos dos treinadores.
     */
    public double getVencimentoDeTodosOsTreinadores() {
        double total = 0;

        for (Pessoa pessoa : pessoas) {
            if (pessoa == null || !(pessoa instanceof Treinador)) {
                continue;
            }

            Treinador treinador = (Treinador) pessoa;
            total += treinador.calcularVencimento();
        }

        return total;
    }

    /**
     * Retorna uma lista de pessoas que frequentam o ginásio, ordenada alfabeticamente por nome.
     *
     * @return A lista de pessoas ordenada por nome.
     */
    public ArrayList<Pessoa> getPessoasQueFrequentamOGinasio() {
        ArrayList<Pessoa> listaDeClientes = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa == null || !(pessoa instanceof Cliente)) {
                continue;
            }

            listaDeClientes.add(pessoa);
        }

        Collections.sort(listaDeClientes);

        return listaDeClientes;
    }

    /**
     * Retorna uma lista de clientes regulares ativos, por ordem decrescente do valor a pagar no final do mês.
     *
     * @return A lista de clientes regulares ativos ordenada por valor a pagar no final do mês.
     */
    public ArrayList<ClienteRegular> getClientesRegularesAtivosDecrescente() {
        ArrayList<ClienteRegular> listaDeClientes = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa == null || !(pessoa instanceof ClienteRegular)) {
                continue;
            }

            ClienteRegular clienteRegular = (ClienteRegular) pessoa;
            if (clienteRegular.isAtivo()) {
                listaDeClientes.add(clienteRegular);
            }
        }

        Comparator<ClienteRegular> comparator = Comparator.comparingDouble(ClienteRegular::calcularPagamentoMensal).reversed();
        listaDeClientes.sort(comparator);

        return listaDeClientes;
    }

    /**
     * Retorna uma lista de clientes ordenada por IMC de forma decrescente.
     *
     * @return A lista de clientes ordenada por IMC de forma decrescente.
     */
    public ArrayList<Cliente> getClientesDecrescenteIMC() {
        ArrayList<Cliente> listaDeClientes = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa == null || !(pessoa instanceof Cliente)) {
                continue;
            }

            Cliente cliente = (Cliente) pessoa;
            listaDeClientes.add(cliente);
        }

        Comparator<Cliente> criterioIMC = Comparator.comparingDouble(Cliente::calcularIMC).reversed();
        listaDeClientes.sort(criterioIMC);

        return listaDeClientes;
    }

    // Métodos de obtenção de listas específicas

    /**
     * Obtém uma lista de todos os clientes do ginásio.
     *
     * @return A lista de clientes.
     */
    public ArrayList<Cliente> getClientes() {
        return getTipoDePessoa(Cliente.class);
    }

    /**
     * Obtém uma lista de todos os treinadores do ginásio.
     *
     * @return A lista de treinadores.
     */
    public ArrayList<Treinador> getTreinadores() {
        return getTipoDePessoa(Treinador.class);
    }

    /**
     * Obtém uma lista de todos os funcionários do ginásio.
     *
     * @return A lista de funcionários.
     */
    public ArrayList<Funcionario> getFuncionarios() {
        return getTipoDePessoa(Funcionario.class);
    }

    /**
     * Obtém uma lista de todos os funcionários base do ginásio.
     *
     * @return A lista de funcionários base.
     */
    public ArrayList<FuncionarioBase> getFuncionariosBase() {
        return getTipoDePessoa(FuncionarioBase.class);
    }

    /**
     * Obtém uma lista específica de pessoas com base na classe fornecida.
     *
     * @param type A classe da pessoa desejada.
     * @param <T>  O tipo de pessoa.
     * @return A lista de pessoas do tipo especificado.
     */
    public <T> ArrayList<T> getTipoDePessoa(Class<T> type) {
        ArrayList<T> result = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (type.isInstance(pessoa)) {
                result.add(type.cast(pessoa));
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Ginásio: {\n\tNome: %s,\n\tMorada: %s,", nome, morada));

        stringBuilder.append("\n\nPessoas do Ginásio [\n");
        for (int i = 0; i < pessoas.size(); i++) {
            String pessoaToString = pessoas.get(i).toString();
            stringBuilder.append(String.format("» %s\n", pessoaToString));
        }

        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ginasio ginasio = (Ginasio) obj;
        return Objects.equals(nome, ginasio.nome) && Objects.equals(morada, ginasio.morada) && Objects.equals(pessoas, ginasio.pessoas); // ordenar arraylist antes de fazer a comparação
    }
}
