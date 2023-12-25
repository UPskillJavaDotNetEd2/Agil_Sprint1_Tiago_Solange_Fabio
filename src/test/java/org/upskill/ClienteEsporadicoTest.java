package org.upskill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEsporadicoTest {

    ClienteEsporadico clienteFabio = new ClienteEsporadico("Fábio", Genero.MASCULINO, "Porto", new Data(1981, 7, 8), 1.86, 100, 4, 42, 9);

    @Test
    void calcularIMC() {
        double expected = 28.90;
        assertEquals(expected, clienteFabio.calcularIMC(), 0.01);
    }

    @Test
    void calcularPagamentoMensal() {
        double expected = 448;
        assertEquals(expected, clienteFabio.calcularPagamentoMensal(), 0.001);
    }

    @Test
    void getNumeroDeAulas() {
        int expected = 4 + 9;
        assertEquals(expected, clienteFabio.getNumeroDeAulas(), 0.001);
    }

    @Test
    void testToString() {
        String s1 = clienteFabio.toString();
        String s2 = new ClienteConvidado().toString();

        System.out.println(s1);
        System.out.println(s2);

        assertNotEquals(s1, s2);
    }

    @Test
    void testEquals() {
        ClienteEsporadico ce = new ClienteEsporadico();
        assertNotEquals(ce, clienteFabio);

        ce = clienteFabio;
        assertEquals(ce, clienteFabio);
    }
}