package org.upskill;

import java.util.Objects;
/**
 * Representa um treinador que é uma pessoa e também um funcionário base.
 */
public class Treinador extends Pessoa implements FuncionarioBase {
    /** Número de sessões de treinamento pessoal. */
    private int sessoesDePT;

    /** Valor por sessão de treinamento pessoal. */
    private double valorPorSessaoPT;

    /** Vencimento do treinador. */
    private double vencimento;

    /** Número padrão de sessões de treinamento pessoal. */
    private static final int DEFAULT_SESSOES_DE_PT = -1;

    /** Valor padrão por sessão de treinamento pessoal. */
    private static final int DEFAULT_VALOR_POR_SESSAO_PT = -1;

    /** Vencimento padrão do treinador. */
    private static final int DEFAULT_VENCIMENTO = -1;

    /** Contador de treinadores. */
    private static int contadorTreinador = 0;

    /** Prefixo para o ID do treinador. */
    private final String prefixo = "TREI-";

    // Construtor completo
    public Treinador(String nome, Genero genero, String morada, Data dataNascimento, int sessoesDePT, double valorPorSessaoPT, double vencimento) {
        super(nome, genero, morada, dataNascimento);

        this.sessoesDePT        = sessoesDePT;
        this.valorPorSessaoPT   = valorPorSessaoPT;
        this.vencimento         = vencimento;
    }

    // Construtor Vazio
    public Treinador() {
        super();

        this.sessoesDePT        = DEFAULT_SESSOES_DE_PT;
        this.valorPorSessaoPT   = DEFAULT_VALOR_POR_SESSAO_PT;
        this.vencimento         = DEFAULT_VENCIMENTO;
    }
    /**
     * Obtém o número de sessões de treinamento pessoal.
     *
     * @return O número de sessões de treinamento pessoal.
     */
    public int getSessoesDePT() {
        return sessoesDePT;
    }
    /**
     * Define o número de sessões de treinamento pessoal.
     *
     * @param sessoesDePT O novo número de sessões de treinamento pessoal.
     */
    public void setSessoesDePT(int sessoesDePT) {
        this.sessoesDePT = sessoesDePT;
    }
    /**
     * Obtém o valor por sessão de treinamento pessoal.
     *
     * @return O valor por sessão de treinamento pessoal.
     */
    public double getValorPorSessaoPT() {
        return valorPorSessaoPT;
    }
    /**
     * Define o valor por sessão de treinamento pessoal.
     *
     * @param valorPorSessaoPT O novo valor por sessão de treinamento pessoal.
     */
    public void setValorPorSessaoPT(double valorPorSessaoPT) {
        this.valorPorSessaoPT = valorPorSessaoPT;
    }
    /**
     * Obtém o vencimento do treinador.
     *
     * @return O vencimento do treinador.
     */
    public double getVencimento() {
        return vencimento;
    }
    /**
     * Define o vencimento do treinador.
     *
     * @param vencimento O novo vencimento do treinador.
     */
    public void setVencimento(double vencimento) {
        this.vencimento = vencimento;
    }
    /**
     * Obtém o contador de treinadores.
     *
     * @return O contador de treinadores.
     */
    public static int getContadorTreinador() {
        return contadorTreinador;
    }

    @Override
    String gerarId() {
        // TREI-1
        String id = String.format("%s%d", prefixo, contadorTreinador + 1);
        contadorTreinador++;
        return id;
    }
    /**
     * Gera um ID único para o treinador.
     *
     * @return O ID gerado para o treinador.
     */
    @Override
    public double calcularVencimento() {

        return vencimento + sessoesDePT * valorPorSessaoPT;
    }

    /**
     * Calcula o vencimento total do treinador, incluindo o vencimento fixo e o valor das sessões de treinamento pessoal.
     *
     * @return O vencimento total do treinador.
     */
    @Override
    public String toString() {

        String superToString = super.toString();
        superToString = superToString.replace("Pessoa", "Treinador");
        superToString = superToString.substring(0, superToString.length()-2);

        return String.format("%s,\n\tSessões De PT: %d,\n\tValor Por SessaoPT: %.2f€,\n\tVencimento: %.2f€\n}",
                superToString, sessoesDePT, valorPorSessaoPT, vencimento);
    }

    /**
     * Verifica se dois treinadores são iguais.
     *
     * @param obj O objeto a ser comparado.
     * @return true se os treinadores são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        if (!super.equals(obj))
            return false;

        Treinador treinador = (Treinador) obj;
        return sessoesDePT == treinador.sessoesDePT && Double.compare(valorPorSessaoPT, treinador.valorPorSessaoPT) == 0 && Double.compare(vencimento, treinador.vencimento) == 0 && Objects.equals(prefixo, treinador.prefixo);
    }
}

