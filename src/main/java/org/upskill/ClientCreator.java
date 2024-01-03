package org.upskill;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientCreator {
    // 1) menu for each client
    // 2) client specific input
    // 3) validate input & catch exceptions

    private Scanner input;

    private final char charDeCirarCliente = '-';

    public Cliente generateCliente() {
        // 1) sout: choose cliente
        input = new Scanner(System.in);
        Cliente cliente = null;
        boolean validCliente = false;

        // 2) run cliente input method
        Utils.printTitle("Escolher cliente para inserir");
        while (validCliente == false) {
            Utils.printTitle("0-Cliente Regular, 1-Cliente Convidado, 2-Cliente Esporadico", '\'');
            int clientType = getInputInt();

            switch (clientType) {
                case 0:
                    cliente = getClienteRegular();
                    validCliente = true;
                    break;
                case 1:
                    cliente = getClienteConvidao();
                    validCliente = true;
                    break;
                case 2:
                    cliente = getClienteEsporadico();
                    validCliente = true;
                    break;

                default:
                    validCliente = false;
                    System.out.println("Valor inválido: 0-Cliente Regular, 1-Cliente Convidado, 2-Cliente Esporadico");
                    break;
            }
        }

        Utils.printTitle("Cliente Gerado:", true, false);
        System.out.println(cliente.toString());
        System.out.println();
        return cliente;
    }

    private float getInputFloat() {
        float inFloat = 0;

        while (true) {
            try {
                //System.out.print("Enter a float value: ");
                inFloat = input.nextFloat();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor real inválido...");
                input.nextLine();
            }
        }

        return inFloat;
    }

    private double getInputDouble() {
        double inDouble = 0;

        while (true) {
            try {
                //System.out.print("Enter a float value: ");
                inDouble = input.nextDouble();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor real inválido...");
                input.nextLine();
            }
        }

        return inDouble;
    }

    private int getInputInt() {
        int inInt = 0;

        while (true) {
            try {
                //System.out.print("Enter an integer value: ");
                inInt = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inteiro inválido...");
                input.nextLine();
            }
        }

        return inInt;
    }

    private String getStringInput(int minCharacterCount) {
        String str = "";

        while (true) {
            try {
                do {
                    System.out.print("Enter a string with at least " + minCharacterCount + " characters: ");
                    str = input.nextLine();
                } while (str.length() < minCharacterCount);

                return str;
            } catch (InputMismatchException e) {
                System.out.println(String.format("Input inválido. Inserir mínimo de %s characteres", minCharacterCount));
                input.nextLine();
            }
        }
    }

    private boolean getBooleanInput(String inputForTrue, String inputForFalse) {
        while (true) {
            System.out.println("Inserir '" + inputForTrue + "' para VERDADEIRO ou '" + inputForFalse + "' para FALSO: ");
            String choice = input.nextLine().trim();

            if (choice.equalsIgnoreCase(inputForTrue)) {
                return true;
            } else if (choice.equalsIgnoreCase(inputForFalse)) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter '" + inputForTrue + "' or '" + inputForFalse + "'.");
            }
        }
    }



    // =============================================================================
    // ===  CLIENTE
    // public cliente(String nome, Genero genero, String morada, Data dataNascimento,double altura, double peso, int numeroDeAulasHidro)
    // =============================================================================
    private String getInputName() {
        Utils.printTitle("Inserir Nome", ':');
        return getStringInput(5);
    }

    private Genero getInputGenero() {
        Utils.printTitle("Escolher género: 0-Masculino, 1-Feminino, 2-Outro", ':');
        int choice = getInputInt();

        switch (choice) {
            case 0:
                return Genero.MASCULINO;
            case 1:
                return Genero.FEMININO;
            default:
                return Genero.OUTRO;
        }
    }

    private String getInputMorada() {
        Utils.printTitle("Inserir Morada", ':');
        return getStringInput(5);
    }

    private Data getInputDataNascimento() {
        Utils.printTitle("Data de Nascimento", ':');
        Utils.printTitle("Dia", '-');
        int dia = getInputInt();
        Utils.printTitle("Mês", '-');
        int mes = getInputInt();
        Utils.printTitle("Ano", '-');
        int ano = getInputInt();

        return new Data(ano, mes, dia);
    }

    private double getInputAltrua() {
        Utils.printTitle("Inserir Altura", ':');
        return getInputDouble();
    }

    private double getInputPeso() {
        Utils.printTitle("Inserir Peso", ':');
        return getInputDouble();
    }

    private int getInputAulasHidro() {
        Utils.printTitle("Inserir Número de Aulas Hidro", ':');
        return getInputInt();
    }

    // =============================================================================
    // ===  CLIENTE REGULAR
    // public ClienteRegular(String nome, Genero genero, String morada, Data dataNascimento, double altura, double peso, int aulaHidro, double mensalidade, boolean isAtivo, int numeroDeSessoesPT, double precoDePT) {
    // =============================================================================
    public ClienteRegular getClienteRegular() {
        Utils.printTitle("Criar Cliente Regular", '-');

        String nome = getInputName();
        Genero genero = getInputGenero();
        String morada = getInputMorada();
        Data nascimento = getInputDataNascimento();
        double altura = getInputAltrua();
        double peso = getInputPeso();
        int aulasHidro = getInputAulasHidro();

        // double mensalidade, boolean isAtivo, int numeroDeSessoesPT, double precoDePT
        double mensalidade = getInputMensalidade();
        boolean isActive = getInputIsActive();
        int sessoesPT = getInputSessoesPT();
        double precoPT = getInputPrecoPT();

        return new ClienteRegular(nome, genero, morada, nascimento, altura, peso, aulasHidro, mensalidade, isActive, sessoesPT, precoPT);
    }

    private double getInputMensalidade() {
        Utils.printTitle("Inserir Mensalidade", ':');
        return getInputDouble();
    }

    private boolean getInputIsActive() {
        Utils.printTitle("Inserir estado Activo", ':');
        return getBooleanInput("true", "false");
    }

    private int getInputSessoesPT() {
        Utils.printTitle("Inserir Número de Aulas com Personal Trainer", ':');
        return getInputInt();
    }

    private double getInputPrecoPT() {
        Utils.printTitle("Inserir Preço de Sessões com Personal Trainer", ':');
        return getInputInt();
    }

    // =============================================================================
    // ===  CLIENTE ESPORADICO
    // public ClienteEsporadico(String nome, Genero genero, String morada, Data dataNascimento, double altura, double peso, int aulaHidro, double numeroDeHoras, int numeroDeAulas) {
    // =============================================================================
    public ClienteEsporadico getClienteEsporadico() {
        Utils.printTitle("Criar Cliente Esporádico", charDeCirarCliente);

        String nome = getInputName();
        Genero genero = getInputGenero();
        String morada = getInputMorada();
        Data nascimento = getInputDataNascimento();
        double altura = getInputAltrua();
        double peso = getInputPeso();
        int aulasHidro = getInputAulasHidro();

        // double numeroDeHoras, int numeroDeAulas
        double numeroDeHoras = getInputNumeroDeHoras();
        int numeroDeAulas = getInputNumeroDeAulas();

        return new ClienteEsporadico(nome, genero, morada, nascimento, altura, peso, aulasHidro, numeroDeHoras, numeroDeAulas);
    }

    private double getInputNumeroDeHoras() {
        Utils.printTitle("Inserir Número de Horas de Aulas", ':');
        return getInputFloat();
    }

    private int getInputNumeroDeAulas() {
        Utils.printTitle("Inserir Número de Aulas", ':');
        return getInputInt();
    }


    // =============================================================================
    // ===  CLIENTE CONVIDADO
    // public ClienteConvidado(String nome, Genero genero, String morada, Data dataNascimento, double altura, double peso, int aulaHidro, double numeroDeHorasGratuitas, int numeroDeAulas, int numeroDeSessoesPT, double precoDePT) {
    // =============================================================================
    public ClienteConvidado getClienteConvidao() {
        Utils.printTitle("Criar Cliente Convidado", charDeCirarCliente);

        String nome = getInputName();
        Genero genero = getInputGenero();
        String morada = getInputMorada();
        Data nascimento = getInputDataNascimento();
        double altura = getInputAltrua();
        double peso = getInputPeso();
        int aulasHidro = getInputAulasHidro();

        // double numeroDeHorasGratuitas, int numeroDeAulas, int numeroDeSessoesPT, double precoDePT
        double numeroDeHorasGratuitas = getInputNumeroDeHorasGratuitas();
        int numeroDeAulas = getInputNumeroDeAulas();
        int numeroDeSessoesPT = getInputSessoesPT();
        double precoDePT = getInputPrecoPT();

        return new ClienteConvidado(nome, genero, morada, nascimento, altura, peso, aulasHidro, numeroDeHorasGratuitas, numeroDeAulas, numeroDeSessoesPT, precoDePT);
    }

    private double getInputNumeroDeHorasGratuitas() {
        Utils.printTitle("Inserir Número de Horas Gratuitas", ':');
        return getInputDouble();
    }
}
