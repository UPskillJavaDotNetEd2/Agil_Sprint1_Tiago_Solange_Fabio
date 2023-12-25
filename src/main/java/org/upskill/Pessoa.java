package org.upskill;

/**
 * Classe abstrata que representa uma pessoa.
 * Implementa a interface Comparable para permitir comparação entre pessoas.
 */
public abstract class Pessoa implements Comparable<Pessoa> {
    /**
     * Identificador único da pessoa.
     */
    protected String id;

    /**
     * Nome da pessoa.
     */
    protected String nome;

    /**
     * Género da pessoa.
     */
    protected Genero genero;

    /**
     * Morada da pessoa.
     */
    protected String morada;

    /**
     * Data de nascimento da pessoa.
     */
    protected Data dataNascimento;

    /**
     * Valor padrão para o ID quando não é especificado.
     */
    static final String DEFAULT_ID = "Id inválido";

    /**
     * Valor padrão para o nome quando não é especificado.
     */
    static final String DEFAULT_NOME = "Nome inválido";

    /**
     * Valor padrão para o género quando não é especificado.
     */
    static final Genero DEFAULT_GENERO = Genero.FEMININO;

    /**
     * Valor padrão para a morada quando não é especificada.
     */
    static final String DEFAULT_MORADA = "Morada inválida";

    /**
     * Valor padrão para a data de nascimento quando não é especificada.
     */
    static final Data DEFAULT_DATA_NASCIMENTO = new Data();

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome           O nome da pessoa.
     * @param genero         O género da pessoa.
     * @param morada         O endereço da pessoa.
     * @param dataNascimento A data de nascimento da pessoa.
     */
    public Pessoa(String nome, Genero genero, String morada, Data dataNascimento) {
        this.id = gerarId();
        this.nome           = nome;
        this.genero         = genero;
        this.morada         = morada;
        this.dataNascimento = dataNascimento;
    }

    /**
     * Construtor vazio da classe Pessoa.
     */
    public Pessoa() {
        this.id = gerarId();
        nome                = DEFAULT_NOME;
        genero              = DEFAULT_GENERO;
        morada              = DEFAULT_MORADA;
        dataNascimento      = DEFAULT_DATA_NASCIMENTO;
    }

    /**
     * Obtém o ID da pessoa.
     *
     * @return O ID da pessoa.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o género da pessoa.
     *
     * @return O género da pessoa.
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Obtém a morada da pessoa.
     *
     * @return A morada da pessoa.
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Obtém a data de nascimento da pessoa.
     *
     * @return A data de nascimento da pessoa.
     */
    public Data getDataDeNascimento() {
        return dataNascimento;
    }

    /**
     * Define um novo nome para a pessoa.
     *
     * @param nome O novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define um novo género para a pessoa.
     *
     * @param genero O novo género da pessoa.
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Define uma nova morada para a pessoa.
     *
     * @param morada A nova morada da pessoa.
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Define uma nova data de nascimento para a pessoa.
     *
     * @param dataNascimento A nova data de nascimento da pessoa.
     */
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Método abstrato para gerar um ID único para a pessoa.
     *
     * @return O ID gerado.
     */
    abstract String gerarId();

    /**
     * Compara a igualdade entre duas instâncias de Pessoa.
     *
     * @param obj O objeto a ser comparado.
     * @return true se as instâncias forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (obj instanceof Pessoa == false)
            return false;

        Pessoa outraPessoa = (Pessoa) obj;

        /*
        // com este teste descobrimos que visto os IDs serem gerados no construtor, eles vão ser sempre diferentes
        System.out.println("IDs:");
        System.out.println(String.format("This ID: %s, Other ID: %s", this.id, outraPessoa.getId()));

        System.out.println("Nomes:");
        System.out.println(String.format("This Nome: %s, Other Nome: %s", this.nome, outraPessoa.getNome()));

        System.out.println("Genero:");
        System.out.println(String.format("This Genero: %s, Other Genero: %s", this.genero, outraPessoa.getGenero()));

        System.out.println("Morada:");
        System.out.println(String.format("This Morada: %s, Other Morada: %s", this.morada, outraPessoa.getMorada()));

        System.out.println("Data:");
        System.out.println(String.format("This Data: %s, Other Data: %s", this.dataNascimento, outraPessoa.getDataDeNascimento()));
        */

        return outraPessoa.id.equals(this.id)
                && outraPessoa.nome.equals(this.nome)
                && outraPessoa.genero == getGenero()
                && outraPessoa.morada.equals(this.morada)
                && outraPessoa.dataNascimento.equals(this.dataNascimento);
    }

    /**
     * Retorna uma representação em string da pessoa.
     *
     * @return Uma string que representa a pessoa.
     */
    @Override
    public String toString() {
        return String.format("Pessoa {\n\tID: %s,\n\tNome: %s,\n\tGénero: %s,\n\tMorada: %s,\n\tData de Nascimento: %s }",
                this.id, this.nome, this.genero.toString().toLowerCase(), this.morada, this.dataNascimento.toString());
    }

    /**
     * Compara duas instâncias de Pessoa com base no nome.
     *
     * @param outraPessoa A pessoa a ser comparada.
     * @return Um valor negativo se esta pessoa preceder a outra, um valor positivo se esta pessoa
     * suceder a outra e zero se ambas forem iguais.
     */
    @Override
    public int compareTo(Pessoa outraPessoa) {
        return this.nome.compareTo(outraPessoa.getNome());
    }
}