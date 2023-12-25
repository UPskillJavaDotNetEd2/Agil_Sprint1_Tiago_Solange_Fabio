package org.upskill;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteRegularTest {

    ClienteRegular clienteSol = new ClienteRegular("Solange", Genero.FEMININO, "Guetto", new Data(1994, 11, 3), 1.6, 58, 7, 30, true, 4, 30);

    @Test
    void calcularIMC() {
        double expected = 22.65;
        assertEquals(expected, clienteSol.calcularIMC(), 0.01);
    }

    @Test
    void isAtivo() {
        boolean expected = true;
        assertEquals(expected, clienteSol.isAtivo());
    }

    @Test
    void calcularPagamentoMensal() {
        double expected = 30 + 4 * 30 + 3 * 5 + 4 * 3; // mensalidade + aulasPT * numAulasPT + numeAulasHidro * precoAulasHidro,
        assertEquals(expected, clienteSol.calcularPagamentoMensal(), 0.001);
    }

    @Test
    void calcularPrecoDeTreinador() {
        double expected = 4 * 30;
        assertEquals(expected, clienteSol.calcularPrecoDeTreinador(), 0.001);
    }

    @Test
    void compare() {
        ClienteRegular cr = new ClienteRegular();
        assertNotEquals(cr, clienteSol);

        // com este teste descobrimos que visto os IDs serem gerados no construtor, eles vão ser sempre diferentes
        ClienteRegular cr2 = new ClienteRegular("Solange", Genero.FEMININO, "Guetto", new Data(1994, 11, 3), 1.6, 58, 7, 30, true, 4, 30);
        assertNotEquals(clienteSol, cr2);
        // assertEquals(clienteSol, cr2); => vai ser sempre falso por causa dos IDs

        ClienteRegular cr3 = clienteSol;
        assertEquals(cr3, clienteSol);
    }

    @Test
    void getNumeroDeAulas() {
        int expected = 7;
        assertEquals(expected, clienteSol.getNumeroDeAulas(), 0.001);
    }

    @Test
    void testToString() {
        String s1 = clienteSol.toString();
        String s2 = new ClienteRegular().toString();

        System.out.println(s1);
        System.out.println(s2);

        assertNotEquals(s1, s2);
    }
}