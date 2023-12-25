package org.upskill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteConvidadoTest {

    ClienteConvidado clienteTi = new ClienteConvidado("Tiago", Genero.MASCULINO, "Alcobaça", new Data(1996, 3, 13), 1.7, 64, 5, 24, 3, 7, 70);

    @Test
    void calcularIMC() {
        double expected = 22.14;
        assertEquals(expected, clienteTi.calcularIMC(), 0.01);
    }

    @Test
    void calcularPagamentoMensal() {
        double expected = 669;
        assertEquals(expected, clienteTi.calcularPagamentoMensal(), 0.001);
    }

    @Test
    void calcularPrecoDeTreinador() {
        double expected = 7 * 70;
        assertEquals(expected, clienteTi.calcularPrecoDeTreinador(), 0.001);
    }

    @Test
    void getNumeroDeAulas() {
        int expected = 5 + 3; // aulas hidro + aulas normais
        assertEquals(expected, clienteTi.getNumeroDeAulas(), 0.001);
    }

    @Test
    void testToString() {
        String s1 = clienteTi.toString();
        String s2 = new ClienteConvidado().toString();

        System.out.println(s1);
        System.out.println(s2);

        assertNotEquals(s1, s2);
    }

    @Test
    void testEquals() {

        ClienteConvidado cv = new ClienteConvidado();
        assertNotEquals(cv, clienteTi);

        cv = clienteTi;
        assertEquals(cv, clienteTi);
    }
}