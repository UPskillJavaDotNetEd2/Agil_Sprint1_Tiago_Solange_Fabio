package org.upskill;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class ClientInput {
    // 1) menu for each client
    // 2) client specific input
    // 3) validate input & catch exceptions

    public Cliente StartClienteGenerator() {

        // 1) sout: choose cliente
        // 2) run cliente input method
        Utils.printTitle("Escolher cliente para inserir:");
        return null;
    }

    private String getName() {
        Utils.printTitle("Inserir Nome:");
        Scanner input = new Scanner(System.in);
        String name = "";

        try {
            do {
                name = input.nextLine();
            } while (name.length() <= 0);

            return name;
        } catch (Exception e) {
            return "NO NAME"; 
        }
    }
}
