package org.upskill;

import java.util.Objects;

/**
 * Representa um funcionário que estende a classe Pessoa e implementa a interface FuncionarioBase.
 */
public class Funcionario extends Pessoa implements FuncionarioBase {

    /**
     * Número de clientes angariados pelo funcionário.
     */
    private int clientesAngariados;

    /**
     * Vencimento base do funcionário.
     */
    private static int vencimentoBase = 800;

    /**
     * Acréscimo no vencimento por cliente angariado.
     */
    private static int acrescimoPorCliente = 20;

    /**
     * Valor padrão para o número de clientes angariados.
     */
    private final int DEFAULT_CLIENTE_ANGARIADO = -1;

    /**
     * Valor padrão para o vencimento base.
     */
    private final int DEFAULT_VENCIMENTO_BASE = 0;

    /**
     * Valor padrão para o acréscimo por cliente angariado.
     */
    static final int DEFAULT_ACRESCIMO_POR_CLIENTE = 0;

    /**
     * Contador de funcionários.
     */
    private static int contadorFuncionario = 0;

    /**
     * Prefixo para a geração de ID.
     */
    private final String prefixo = "FUNC-";

    /**
     * Construtor completo da classe Funcionario.
     *
     * @param nome              O nome do funcionário.
     * @param genero            O gênero do funcionário.
     * @param morada            O endereço do funcionário.
     * @param dataNascimento    A data de nascimento do funcionário.
     * @param clienteAngariado  O número de clientes angariados pelo funcionário.
     */
    public Funcionario(String nome, Genero genero, String morada, Data dataNascimento, int clienteAngariado) {
        super(nome, genero, morada, dataNascimento);
        this.clientesAngariados = clienteAngariado;
        contadorFuncionario++;
    }

    /**
     * Construtor vazio da classe Funcionario.
     */
    public Funcionario() {
        super();
        this.clientesAngariados = DEFAULT_CLIENTE_ANGARIADO;
        contadorFuncionario++;
    }

    /**
     * Obtém o número de clientes angariados pelo funcionário.
     *
     * @return O número de clientes angariados.
     */
    public int getClientesAngariados() {
        return clientesAngariados;
    }

    /**
     * Obtém o vencimento base do funcionário.
     *
     * @return O vencimento base do funcionário.
     */
    public static int getVencimentoBase() {
        return vencimentoBase;
    }

    /**
     * Define o vencimento base do funcionário.
     *
     * @param vencimentoBase O novo vencimento base do funcionário.
     */
    public static void setVencimentoBase(int vencimentoBase) {
        Funcionario.vencimentoBase = vencimentoBase;
    }

    /**
     * Obtém o acréscimo no vencimento por cliente angariado.
     *
     * @return O acréscimo no vencimento por cliente angariado.
     */
    public static int getAcrescimoPorCliente() {
        return acrescimoPorCliente;
    }

    /**
     * Define o acréscimo no vencimento por cliente angariado.
     *
     * @param acrescimoPorCliente O novo acréscimo no vencimento por cliente angariado.
     */
    public static void setAcrescimoPorCliente(int acrescimoPorCliente) {
        Funcionario.acrescimoPorCliente = acrescimoPorCliente;
    }

    /**
     * Obtém o contador de funcionários.
     *
     * @return O contador de funcionários.
     */
    public static int getContadorFuncionario() {
        return contadorFuncionario;
    }

    /**
     * Obtém o prefixo para a geração de ID.
     *
     * @return O prefixo para a geração de ID.
     */
    public String getPrefixo() {
        return prefixo;
    }

    /**
     * Gera um ID único para o funcionário.
     *
     * @return O ID gerado para o funcionário.
     */
    @Override
    String gerarId() {
        // FUNC-contadorFuncionario
        return String.format("%s%d", prefixo, contadorFuncionario + 1);
    }

    /**
     * Calcula o vencimento do funcionário, considerando o vencimento base e o acréscimo por cliente angariado.
     *
     * @return O vencimento total do funcionário.
     */
    @Override
    public double calcularVencimento() {
        return vencimentoBase + clientesAngariados * acrescimoPorCliente;
    }

    /**
     * Converte a representação do funcionário em uma string formatada.
     *
     * @return A string formatada representando o funcionário.
     */
    @Override
    public String toString() {
        String superToString = super.toString();

        superToString = superToString.replace("Pessoa", "Funcionario");

        superToString = superToString.substring(0, superToString.length() - 2);

        return String.format("%s,\n\tCliente Angariado: %d\n}", superToString, clientesAngariados);
    }

    /**
     * Verifica se dois funcionários são iguais com base nos atributos.
     *
     * @param obj O objeto a ser comparado.
     * @return true se os funcionários são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        if (!super.equals(obj))
            return false;

        Funcionario otherFuncionario = (Funcionario) obj;
        return clientesAngariados == otherFuncionario.clientesAngariados && Objects.equals(prefixo, otherFuncionario.prefixo);
    }
}
