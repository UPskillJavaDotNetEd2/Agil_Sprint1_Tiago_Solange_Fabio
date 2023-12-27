package org.upskill;

/**
 * Classe que representa um Cliente Esporádico no ginásio.
 */
public class ClienteEsporadico extends Cliente {

    /**
     * Número de horas que o cliente permanecu no ginaáio.
     */
    private double numeroDeHoras;

    /**
     * Numero de Aulas frequentadas pelo cliente.
     */
    private int numeroDeAulas;

    // Variaveis de Omissao
    private final int DEFAULT_NUMERO_HORAS = -1;

    /**
     * Valor por omissão para numeros de aulas não especificado.
     */
    private final int DEFAULT_NUMERO_AULAS = -1;

    // Declaração de variáveis estáticas padrão

    /**
     * Preço por aula regular
     */
    private static double precoPorAula      = 5;

    /**
     * Preço por Hora Extra.
     */
    private static double precoPorHoraExtra = 5;

    /**
     * Preço por hora de permanecia no Ginasio
     */
    private static double precoPorHora      = 5;

    /**
     * 
     */
    private static double precoPorHoraHidro = 7;
    private static double tempoDeAula       = 1;

    private static int contadorClientesEsporadico = 0;
    private final static TipoDeCliente SUFIXO = TipoDeCliente.ESPORADICO;

    /**
     * Construtor para criar um Cliente Esporádico com detalhes específicos.
     *
     * @param nome            Nome do cliente.
     * @param genero          Gênero do cliente.
     * @param morada          Morada do cliente.
     * @param dataNascimento  Data de nascimento do cliente.
     * @param altura          Altura do cliente.
     * @param peso            Peso do cliente.
     * @param aulaHidro       Número de aulas de hidroginástica frequentadas pelo cliente.
     * @param numeroDeHoras   Número de horas que o cliente permaneceu no ginásio.
     * @param numeroDeAulas   Número de aulas frequentadas pelo cliente.
     */
    public ClienteEsporadico(String nome, Genero genero, String morada, Data dataNascimento, double altura, double peso, int aulaHidro, double numeroDeHoras, int numeroDeAulas) {
        super(nome, genero, morada, dataNascimento, altura, peso, aulaHidro);

        this.numeroDeHoras = numeroDeHoras;
        this.numeroDeAulas = numeroDeAulas;
    }

    /**
     * Construtor padrão para um Cliente Esporádico.
     */
    public ClienteEsporadico() {
        super();

        this.numeroDeHoras = DEFAULT_NUMERO_HORAS;
        this.numeroDeAulas = DEFAULT_NUMERO_AULAS;
    }

    /**
     *Getters Instância
     * @return
     */
    public double getNumeroDeHoras() {
        return numeroDeHoras;
    }

    // Setters Instância
    public void setNumeroDeHoras(int numeroDeHoras) {
        this.numeroDeHoras = numeroDeHoras;
    }


    // Getters Classe
    public static double getPrecoPorAula() {
        return precoPorAula;
    }

    public static double getPrecoPorHora() {
        return precoPorHora;
    }

    public static double getPrecoPorHoraHidro() {
        return precoPorHoraHidro;
    }

    public static int getContadorClientesEsporadico() {
        return contadorClientesEsporadico;
    }

    public void setNumeroDeHoras(double numeroDeHoras) {
        this.numeroDeHoras = numeroDeHoras;
    }

    public void setNumeroDeAulas(int numeroDeAulas) {
        this.numeroDeAulas = numeroDeAulas;
    }

    public static double getPrecoPorHoraExtra() {
        return precoPorHoraExtra;
    }

    public static void setPrecoPorHoraExtra(double precoPorHoraExtra) {
        ClienteEsporadico.precoPorHoraExtra = precoPorHoraExtra;
    }

    public static double getTempoDeAula() {
        return tempoDeAula;
    }

    public static void setTempoDeAula(double tempoDeAula) {
        ClienteEsporadico.tempoDeAula = tempoDeAula;
    }

    // Setters Classe
    public static void setPrecoPorAula(double precoPorAula) {
        ClienteEsporadico.precoPorAula = precoPorAula;
    }

    public static void setPrecoPorHora(double precoPorHora) {
        ClienteEsporadico.precoPorHora = precoPorHora;
    }

    public static void setPrecoPorHoraHidro(double precoPorHoraHidro) {
        ClienteEsporadico.precoPorHoraHidro = precoPorHoraHidro;
    }

    public int getTotalDeAulas() {
        return numeroDeAulas + numeroDeAulasHidro;
    }

    @Override
    String gerarId() {
        // CLI-
        String id = String.format("%s%s-%d", prefixo, SUFIXO, contadorClientesEsporadico);
        contadorClientesEsporadico++;
        return id;
    }

    /**
     * Método para calcular o pagamento mensal de um Cliente Esporádico.
     *
     * @return O valor total a ser pago mensalmente pelo Cliente Esporádico.
     */
    @Override
    public double calcularPagamentoMensal() {
        //  Caso o cliente tenha permanecido nas instalações do ginásio 1 hora e meia, terá de pagar 2 horas
        int totalDeHoras    = (int)Math.ceil(numeroDeHoras);
        int horasDeAula     = (int)Math.ceil(numeroDeAulas * tempoDeAula);
        //int horasExtra      = Math.abs(totalDeHoras - horasDeAula);
        int horasExtra      = totalDeHoras - horasDeAula;

        return  // O valor resulta do número de horas (assuma um valor inteiro) que o cliente utilizou as instalações, multiplicado pelo preço à hora
                totalDeHoras * precoPorHora

                // Caso estes clientes frequentem aulas, pagam 6 euros por cada aula, exceto as aulas
                // hidroginástica que tem um valor de 7 euros. Apesar de todas as aulas terem uma duração de
                // minutos, assuma (para simplificação) que cada aula tem a duração de 1 hora. Caso o cliente tenh
                // aulas, poderá permanecer nas instalações 2 horas sem ter de pagar mais do que o valor dessas d
                // aulas
                + numeroDeAulas * precoPorAula

                // hidro normal
                + numeroDeAulasHidro * precoPorHoraHidro

                // horas extra
                + horasExtra * precoPorHoraExtra;
    }

    /**
     * Obtém o número total de aulas, incluindo aulas de hidroginástica e aulas regulares.
     @return O número total de aulas.
     */
    public int getNumeroDeAulas() {
        return numeroDeAulasHidro + numeroDeAulas;
    }



    /**
     * Verifica se dois clientes esporádicos são iguais.
     *
     * @param obj O objeto a ser comparado.
     * @return true se os clientes esporádicos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        if (!super.equals(obj))
            return false;

        ClienteEsporadico outroCliente = (ClienteEsporadico) obj;
        return Double.compare(numeroDeHoras, outroCliente.numeroDeHoras) == 0
                && numeroDeAulas == outroCliente.numeroDeAulas;
    }
}