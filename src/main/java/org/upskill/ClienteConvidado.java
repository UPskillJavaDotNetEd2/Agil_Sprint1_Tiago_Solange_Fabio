package org.upskill;
/**
 * Representa um cliente convidado do ginásio, uma subclasse de Cliente que também implementa ClienteComPersonalTrainer
 */
public class ClienteConvidado extends Cliente implements ClienteComPersonalTrainer {
    /**
     * O número de horas gratuitas atribuídas ao cliente convidado
     */
    private double  numeroDeHorasGratuitas;

    private int     numeroDeAulas;
    private int     numeroDeSessoesPT;
    private double  precoDePT;

    /**
     * Valor padrão para o número de horas
     */
    private double  DEFAULT_NUMERO_DE_HORAS     = -1;
    /**
     * Valor padrão para o número aulas
     */
    private int     DEFAULT_NUMERO_DE_AULAS     = -1;
    /**
     * Valor padrão para o número sessões
     */
    private int     DEFAULT_NUMERO_SESSOES_PT   = -1;
    /**
     * Valor padrão para o preço
     */
    private double  DEFAULT_PRECO_PT            = -1;
    /**
     * Preço padrão por aula para clientes convidados.
     */
    private static double precoPorAula          = 6;

    /**
     * Preço padrão por hora extra para clientes convidados.
     */
    private static double precoPorHoraExtra     = 6;
    /**
     * Preço padrão por aula de hidroginástica para clientes convidados.
     */
    private static double precoPorAulaHidro     = 7;
    /**
     * Contador para clientes convidados.
     */
    private static int contadorClienteConvidado = 0;
    /**
     * Sufixo para identificação do tipo de cliente como CONVIDADO.
     */
    private final static TipoDeCliente SUFIXO   = TipoDeCliente.CONVIDADO;

    /**
     * Construtor para criar um ClienteConvidado com informações básicas
     *
     * @param nome                 Nome do cliente convidado
     * @param genero               Gênero do cliente convidado
     * @param morada               Morada do cliente convidado
     * @param dataNascimento       Data de nascimento do cliente convidado
     * @param altura               Altura do cliente convidado em metros
     * @param peso                 Peso do cliente convidado em quilogramas
     * @param aulaHidro            Número de aulas de hidroginástica frequentadas pelo cliente convidado
     * @param numeroDeHorasGratuitas   Número de horas gratuitas disponíveis para o cliente convidado
     * @param numeroDeAulas        Número total de aulas frequentadas pelo cliente convidado
     * @param numeroDeSessoesPT    Número de sessões com personal trainer do cliente convidado
     * @param precoDePT            Preço por sessão do personal trainer para o cliente convidado
     */
    public ClienteConvidado(String nome, Genero genero, String morada, Data dataNascimento, double altura, double peso, int aulaHidro, double numeroDeHorasGratuitas, int numeroDeAulas, int numeroDeSessoesPT, double precoDePT) {
        super(nome, genero, morada, dataNascimento, altura, peso, aulaHidro);
        this.numeroDeHorasGratuitas = numeroDeHorasGratuitas;
        this.numeroDeAulas          = numeroDeAulas;
        this.numeroDeSessoesPT      = numeroDeSessoesPT;
        this.precoDePT              = precoDePT;
    }

    /**
     * Construtor vazio para um ClienteConvidado sem informações
     */
    public ClienteConvidado() {
        super();
        this.numeroDeHorasGratuitas = DEFAULT_NUMERO_DE_HORAS;
        this.numeroDeAulas          = DEFAULT_NUMERO_DE_AULAS;
        this.numeroDeSessoesPT      = DEFAULT_NUMERO_SESSOES_PT;
        this.precoDePT              = DEFAULT_PRECO_PT;
    }

    public double getNumeroDeHorasGratuitas() {
        return numeroDeHorasGratuitas;
    }

    public int getNumeroDeSessoesPT() {
        return numeroDeSessoesPT;
    }

    public double getPrecoDePT() {
        return precoDePT;
    }

    public void setNumeroDeHorasGratuitas(double numeroDeHorasGratuitas) {
        this.numeroDeHorasGratuitas = numeroDeHorasGratuitas;
    }

    public void setNumeroDeAulas(int numeroDeAulas) {
        this.numeroDeAulas = numeroDeAulas;
    }

    public void setNumeroDeSessoesPT(int numeroDeSessoesPT) {
        this.numeroDeSessoesPT = numeroDeSessoesPT;
    }

    public void setPrecoDePT(double precoDePT) {
        this.precoDePT = precoDePT;
    }



    public static double getPrecoPorAula() {
        return precoPorAula;
    }

    public static double getPrecoPorHoraExtra() {
        return precoPorHoraExtra;
    }

    public static double getPrecoPorAulaHidro() {
        return precoPorAulaHidro;
    }

    public static int getContadorClienteConvidado() {
        return contadorClienteConvidado;
    }

    public static void setPrecoPorAula(double precoPorAula) {
        ClienteConvidado.precoPorAula = precoPorAula;
    }

    public static void setPrecoPorHoraExtra(double precoPorHoraExtra) {
        ClienteConvidado.precoPorHoraExtra = precoPorHoraExtra;
    }

    public static void setPrecoPorAulaHidro(double precoPorAulaHidro) {
        ClienteConvidado.precoPorAulaHidro = precoPorAulaHidro;
    }

    /**
     * {@inheritDoc}
     * Método para gerar um identificador único para um ClienteConvidado.
     * Este método sobrescrito implementa a lógica para criar o ID específico para um ClienteConvidado.
     *
     * @return O ID gerado para o ClienteConvidado
     */
    @Override
    String gerarId() {
        String id = String.format("%s%s-%d", prefixo, SUFIXO, contadorClienteConvidado); // CLI-SUFIXO-contadorClienteConvidado
        contadorClienteConvidado++;
        return id;
    }

    /**
     * {@inheritDoc}
     * Método para calcular o pagamento mensal de um ClienteConvidado.
     * Este método sobrescrito implementa a lógica para calcular o valor mensal que um ClienteConvidado deve pagar.
     *
     * @return O valor total a ser pago mensalmente pelo ClienteConvidado
     */
    @Override
    public double calcularPagamentoMensal() {
        // Implementação da lógica para calcular o pagamento mensal do ClienteConvidado

        double valorTotal = 0;
        int totalHorasGratuitas = (int) Math.ceil(numeroDeHorasGratuitas);

        // hidro
        valorTotal += numeroDeAulasHidro * precoPorAulaHidro;

        // aulas
        valorTotal += numeroDeAulas * precoPorAula;

        // horas Extra
        //int horasExtra = Math.abs(totalHorasGratuitas - numeroDeAulas);
        int horasExtra = totalHorasGratuitas - numeroDeAulas;

        if (horasExtra > 0)
            valorTotal += horasExtra * precoPorHoraExtra;

        valorTotal += calcularPrecoDeTreinador();

        return valorTotal;
    }

    /**
     * {@inheritDoc}
     * Método para calcular o preço do treinador para um ClienteConvidado.
     * Este método implementa a lógica para calcular o custo do personal trainer para o ClienteConvidado.
     *
     * @return O preço do treinador para o ClienteConvidado
     */
    @Override
    public double calcularPrecoDeTreinador() {
        // Implementação da lógica para calcular o preço do treinador para o ClienteConvidado

        return numeroDeSessoesPT * precoDePT;
    }

    /**
     * {@inheritDoc}
     * Método para obter o número total de aulas frequentadas pelo cliente.
     * Este método implementa a lógica para obter o número total de aulas do ClienteConvidado.
     *
     * @return O número total de aulas frequentadas pelo cliente convidado
     */
    @Override
    public int getNumeroDeAulas() {
        return numeroDeAulasHidro + numeroDeAulas;
    } // calcularNumeroDeAulas()

    /**
     * {@inheritDoc}
     * Método para representar o objeto ClienteConvidado em formato de string.
     *
     * @return Uma representação em formato de string do objeto ClienteConvidado
     */
    @Override
    public String toString() {

        String superToString = super.toString();

        superToString = superToString.replace("Cliente", "Cliente Convidado");

        superToString = superToString.substring(0, superToString.length() - 2);

        return String.format("%s,\n\tNumero De Horas Gratuitas: %.2f,\n\tNumero De Aulas: %d,\n\tNumero De Sessoes PT: %d,\n\tPreço De PT: %.2f€\n}",
                superToString, numeroDeHorasGratuitas, numeroDeAulas, numeroDeSessoesPT, precoDePT);
    }

    /**
     * {@inheritDoc}
     * Método para verificar a igualdade entre objetos ClienteConvidado.
     *
     * @param obj Objeto a ser comparado com o ClienteConvidado
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        if (!super.equals(obj))
            return false;

        ClienteConvidado outroCliente = (ClienteConvidado) obj;
        return Double.compare(numeroDeHorasGratuitas, outroCliente.numeroDeHorasGratuitas) == 0
                && numeroDeAulas == outroCliente.numeroDeAulas
                && numeroDeSessoesPT == outroCliente.numeroDeSessoesPT
                && Double.compare(precoDePT, outroCliente.precoDePT) == 0;
    }
}