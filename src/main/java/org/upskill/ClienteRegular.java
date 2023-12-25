package org.upskill;
import java.util.Comparator;
import java.util.Objects;

/**
 * Representa um cliente regular que estende a classe Cliente e implementa a interface ClienteComPersonalTrainer.
 * Implementa também a interface Comparator para permitir comparação entre clientes regulares.
 */
public class ClienteRegular extends Cliente implements ClienteComPersonalTrainer, Comparator<ClienteRegular> { // não usar o Comparator (modifica a classe) = meter em classe à parte

    /**
     * Mensalidade do cliente regular.
     */
    private double mensalidade;

    /**
     * Indica se o cliente regular está ativo.
     */
    private boolean isAtivo;

    /**
     * Número de sessões com personal trainer do cliente regular.
     */
    private int numeroDeSessoesPT;

    /**
     * Preço por sessão com personal trainer do cliente regular.
     */
    private double precoDePT;

    /**
     * Valor padrão para a mensalidade.
     */
    private final double DEFAULT_MENSALIDADE = -1;

    /**
     * Valor padrão para o status de ativo.
     */
    private final boolean DEFAULT_IS_ATIVO = false;

    /**
     * Valor padrão para o número de sessões com personal trainer.
     */
    private int DEFAULT_NUMERO_SESSOES_PT = -1;

    /**
     * Valor padrão para o preço por sessão com personal trainer.
     */
    private double DEFAULT_PRECO_PT = -1;

    /**
     * Preço das aulas de hidroginástica até o limite.
     */
    private static double precoAulasHidroAteLimite = 5;

    /**
     * Preço das aulas de hidroginástica após o limite.
     */
    private static double precoAulasHidroDepoisDeLimite = 3;

    /**
     * Limite de aulas de hidroginástica.
     */
    private static int limiteDeAulasHidro = 3;

    /**
     * Contador de clientes regulares.
     */
    private static int contadorClienteRegular = 0;

    /**
     * Sufixo para a geração de ID.
     */
    private static final TipoDeCliente SUFIXO = TipoDeCliente.REGULAR;

    /**
     * Construtor da classe ClienteRegular.
     *
     * @param nome             O nome do cliente regular.
     * @param genero           O gênero do cliente regular.
     * @param morada           O endereço do cliente regular.
     * @param dataNascimento   A data de nascimento do cliente regular.
     * @param altura           A altura do cliente regular.
     * @param peso             O peso do cliente regular.
     * @param aulaHidro        O número de aulas de hidroginástica do cliente regular.
     * @param mensalidade      A mensalidade do cliente regular.
     * @param isAtivo          Indica se o cliente regular está ativo.
     * @param numeroDeSessoesPT O número de sessões com personal trainer do cliente regular.
     * @param precoDePT        O preço por sessão com personal trainer do cliente regular.
     */
    public ClienteRegular(String nome, Genero genero, String morada, Data dataNascimento, double altura, double peso, int aulaHidro, double mensalidade, boolean isAtivo, int numeroDeSessoesPT, double precoDePT) {
        super(nome, genero, morada, dataNascimento, altura, peso, aulaHidro);

        this.mensalidade = mensalidade;
        this.isAtivo = isAtivo;
        this.numeroDeSessoesPT = numeroDeSessoesPT;
        this.precoDePT = precoDePT;
    }

    /**
     * Construtor vazio da classe ClienteRegular.
     */
    public ClienteRegular() {
        super();

        this.mensalidade = DEFAULT_MENSALIDADE;
        this.isAtivo = DEFAULT_IS_ATIVO;
        this.numeroDeSessoesPT = DEFAULT_NUMERO_SESSOES_PT;
        this.precoDePT = DEFAULT_PRECO_PT;
    }

    /**
     * Obtém a mensalidade do cliente regular.
     *
     * @return A mensalidade do cliente regular.
     */
    public double getMensalidade() {
        return mensalidade;
    }

    /**
     * Verifica se o cliente regular está ativo.
     *
     * @return true se o cliente regular está ativo, false caso contrário.
     */
    public boolean isAtivo() {
        return isAtivo;
    }

    /**
     * Define a mensalidade do cliente regular.
     *
     * @param mensalidade A nova mensalidade do cliente regular.
     */
    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    /**
     * Define o status de ativo do cliente regular.
     *
     * @param ativo O novo status de ativo do cliente regular.
     */
    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
    }

    /**
     * Obtém o preço das aulas de hidroginástica até o limite.
     *
     * @return O preço das aulas de hidroginástica até o limite.
     */
    public static double getPrecoAulasHidroAteLimite() {
        return precoAulasHidroAteLimite;
    }

    /**
     * Obtém o preço das aulas de hidroginástica após o limite.
     *
     * @return O preço das aulas de hidroginástica após o limite.
     */
    public static double getPrecoAulasHidroDepoisDeLimite() {
        return precoAulasHidroDepoisDeLimite;
    }

    /**
     * Obtém o limite de aulas de hidroginástica.
     *
     * @return O limite de aulas de hidroginástica.
     */
    public static int getLimiteDeAulasHidro() {
        return limiteDeAulasHidro;
    }

    /**
     * Obtém o contador de clientes regulares.
     *
     * @return O contador de clientes regulares.
     */
    public static int getContadorClienteRegular() {
        return contadorClienteRegular;
    }

    /**
     * Define o preço das aulas de hidroginástica até o limite.
     *
     * @param precoAulasHidroAteLimite O novo preço das aulas de hidroginástica até o limite.
     */
    public static void setPrecoAulasHidroAteLimite(double precoAulasHidroAteLimite) {
        ClienteRegular.precoAulasHidroAteLimite = precoAulasHidroAteLimite;
    }

    /**
     * Define o preço das aulas de hidroginástica após o limite.
     *
     * @param precoAulasHidroDepoisDeLimite O novo preço das aulas de hidroginástica após o limite.
     */
    public static void setPrecoAulasHidroDepoisDeLimite(double precoAulasHidroDepoisDeLimite) {
        ClienteRegular.precoAulasHidroDepoisDeLimite = precoAulasHidroDepoisDeLimite;
    }

    /**
     * Define o limite de aulas de hidroginástica.
     *
     * @param limiteDeAulasHidro O novo limite de aulas de hidroginástica.
     */
    public static void setLimiteDeAulasHidro(int limiteDeAulasHidro) {
        ClienteRegular.limiteDeAulasHidro = limiteDeAulasHidro;
    }

    /**
     * Gera um ID único para o cliente regular.
     *
     * @return O ID gerado para o cliente regular.
     */
    @Override
    String gerarId() {
        // CLI-REGULAR-Contador
        String id = String.format("%s%s-%d", prefixo, SUFIXO.toString(), contadorClienteRegular);
        contadorClienteRegular++;
        return id;
    }

    /**
     * Calcula o pagamento mensal do cliente regular, considerando a mensalidade, aulas de hidroginástica
     * e o preço do personal trainer, se ativo.
     *
     * @return O valor total do pagamento mensal do cliente regular.
     */
    @Override
    public double calcularPagamentoMensal() {
        if (isAtivo)
            return mensalidade + calcularPrecoAulasHidro() + calcularPrecoDeTreinador();
        else
            return 0;
    }

    /**
     * Calcula o preço das aulas de hidroginástica com base no número de aulas e nos preços estabelecidos.
     *
     * @return O preço total das aulas de hidroginástica.
     */
    private double calcularPrecoAulasHidro() {
        double total = 0;

        for (int i = 0; i < numeroDeAulasHidro; i++) {
            if (i < 3)
                total += precoAulasHidroAteLimite;
            else
                total += precoAulasHidroDepoisDeLimite;
        }

        return total;
    }

    /**
     * Calcula o preço total do personal trainer com base no número de sessões e no preço estabelecido.
     *
     * @return O preço total do personal trainer.
     */
    @Override
    public double calcularPrecoDeTreinador() {
        return numeroDeSessoesPT * precoDePT;
    }

    /**
     * Compara dois clientes regulares com base no pagamento mensal.
     *
     * @param clienteUm   O primeiro cliente regular a ser comparado.
     * @param clienteDois O segundo cliente regular a ser comparado.
     * @return Um valor negativo se o primeiro cliente paga menos, um valor positivo se paga mais,
     *         ou zero se ambos pagam o mesmo.
     */
    @Override
    public int compare(ClienteRegular clienteUm, ClienteRegular clienteDois) {
        return Double.compare(clienteUm.calcularPagamentoMensal(), clienteDois.calcularPagamentoMensal());
    }

    /**
     * Obtém o número de aulas de hidroginástica do cliente regular.
     *
     * @return O número de aulas de hidroginástica.
     */
    public int getNumeroDeAulas() {
        return numeroDeAulasHidro;
    }

    /**
     * Converte a representação do cliente regular em uma string formatada.
     *
     * @return A string formatada representando o cliente regular.
     */
    @Override
    public String toString() {
        String superToString = super.toString();

        superToString = superToString.replace("Cliente", "Cliente Regular");

        superToString = superToString.substring(0, superToString.length() - 2);

        return String.format("%s,\n\tMensalidade: %.2f€,\n\tEstá Ativo: %b,\n\tNº Sessoes PT: %d,\n\tPreço De PT: %.2f€\n}",
                superToString, mensalidade, isAtivo, numeroDeSessoesPT, precoDePT);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (super.equals(obj) == false)
            return false;

        if (obj instanceof ClienteRegular == false)
            return false;

        ClienteRegular outroCliente = (ClienteRegular) obj;
        return Double.compare(mensalidade, outroCliente.mensalidade) == 0
                && isAtivo == outroCliente.isAtivo
                && numeroDeSessoesPT == outroCliente.numeroDeSessoesPT
                && Double.compare(precoDePT, outroCliente.precoDePT) == 0;
    }
}
