package org.upskill;
/**
 * Classe abstrata que representa um Cliente do ginásio.
 * Herda de Pessoa e define atributos e métodos comuns a clientes do ginásio.
 */
public abstract class Cliente extends Pessoa {

    /**
     * Altura do cliente em metros
     */
    protected double altura;

    /**
     * Peso do cliente em quilogramas
     */
    protected double peso;

    /**
     * Número de aulas de hidroginástica frequentadas pelo cliente
     */
    protected int numeroDeAulasHidro;

    /**
     * Valor padrão para a altura quando não é especificada
     */
    private final double DEFAULT_ALTURA = -1;

    /**
     * Valor padrão para o peso quando não é especificado
     */
    private final double DEFAULT_PESO = -1;

    /**
     * Valor padrão para o número de aulas de hidroginástica quando não é especificado
     */
    private final int DEFAULT_AULA_HIDRO = -1;

    /**
     * Contador de instâncias de Cliente criadas
     */
    private static int contadorCliente = 0;

    /**
     * Prefixo utilizado para identificar um Cliente
     */
    final static String prefixo = "CLI-";

    /**
     * Construtor para criar um Cliente com informações básicas
     *
     * @param nome                Nome do cliente
     * @param genero              Género do cliente
     * @param morada              Morada do cliente
     * @param dataNascimento      Data de nascimento do cliente
     * @param altura              Altura do cliente em metros
     * @param peso                Peso do cliente em quilogramas
     * @param numeroDeAulasHidro  Número de aulas de hidroginástica frequentadas pelo cliente
     */
    public Cliente (String nome, Genero genero, String morada, Data dataNascimento,double altura, double peso, int numeroDeAulasHidro)
    {
        super(nome, genero, morada, dataNascimento);

        this.altura             = altura;
        this.peso               = peso;
        this.numeroDeAulasHidro = numeroDeAulasHidro;

        contadorCliente++;
    }

    /**
     * Construtor vazio para um Cliente com informações por defeito
     */
    public Cliente(){
        super();

        this.altura             = DEFAULT_ALTURA;
        this.peso               = DEFAULT_PESO;
        this.numeroDeAulasHidro = DEFAULT_AULA_HIDRO;

        contadorCliente++;
    }

    /**
     * Getters
     */

    /**
     * Obtém a altura do cliente
     * @return a altura do cliente
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Obtém o peso do cliente
     * @return o peso do cliente
     */

    public double getPeso() {
        return peso;
    }

    /**
     * Obtém o numero de aulas de hidro
     * @return o numero de aulas de hidro
     */
    public int getNumeroDeAulasHidro() {
        return numeroDeAulasHidro;
    }

    /**
     * Obtém o contador
     * @return o contador
     */
    public static int getContadorCliente() {
        return contadorCliente;
    }

    /**
     * Setters
     * /

    /**
     * Define a altura do cliente
     * @param altura nova altura  do cliente
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Define o peso do cliente
     * @param peso novo peso do cliente
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Define o numero de aulas de Hidro do cliente
     * @param numeroDeAulasHidro novo nuemro de aulas de hidro do cliente
     */
    public void setNumeroDeAulasHidro(int numeroDeAulasHidro) {
        this.numeroDeAulasHidro = numeroDeAulasHidro;
    }

    
    String gerarId() {

     /**
     * CLI-1
     */
        return String.format("%s%d", prefixo, contadorCliente + 1);
    }

    /**
     * Calcula o Índice de Massa Corporal (IMC) do cliente.
     * 𝐼𝑀𝐶 = 𝑃𝑒𝑠𝑜(𝑘𝑔) / 𝐴𝑙𝑡𝑢𝑟𝑎(𝑚)^2
     * @return O IMC do cliente.
     */
    public double calcularIMC(){
        if(peso <= 0 || altura <=0)
            return 0;

        return  peso / Math.pow(altura, 2);
    }

    /**
     * Calcula o pagamento mensal do cliente (método a ser implementado nas subclasses).
     *
     * @return O valor do pagamento mensal.
     */
    public abstract double calcularPagamentoMensal();

    /**
     * Obtém o número de aulas frequentadas pelo cliente (método a ser implementado nas subclasses).
     *
     * @return O número de aulas frequentadas.
     */
    public abstract int getNumeroDeAulas();

    /**
     * Sobrescrita do método toString para retornar informações do Cliente.
     *
     * @return Uma representação em formato de string do objeto Cliente.
     */
    @Override
    public String toString() {
        // 1- ir buscar a toString() da super classe => "Pessoa: { Nome: ...etc... }";
        String superToString = super.toString();

        // 2- trocar "Pessoa" por "Cliente"
        superToString = superToString.replace("Pessoa", "Cliente");

        // 3- remover ultima chaveta => "Cliente: { Nome: ...etc... "
        superToString = superToString.substring(0, superToString.length() - 2);

        // 4- adicionar variáveis que faltam:
        return String.format("%s,\n\tAltura: %.2fm,\n\tPeso: %.2fkg\n}", superToString, altura, peso);
    }

    /**
     * Sobrescrita do método equals para comparar a igualdade de Clientes.
     *
     * @param obj Objeto a ser comparado com o Cliente.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        // Lógica de comparação de igualdade entre Clientes
        if (obj == null)
            return false;

        if (obj == this)
            return true;

        // remover a repetição de condições nas super classes
        if (super.equals(obj) == false)
            return false;

        if (obj instanceof Cliente == false)
            return false;

        Cliente cliente = (Cliente) obj;
        return Double.compare(altura, cliente.altura) == 0
                && Double.compare(peso, cliente.peso) == 0
                && numeroDeAulasHidro == cliente.numeroDeAulasHidro;
    }
}
