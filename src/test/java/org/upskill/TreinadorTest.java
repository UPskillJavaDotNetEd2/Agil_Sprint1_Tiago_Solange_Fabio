package org.upskill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreinadorTest {

    Treinador treinador = new Treinador("Jorge Barracha", Genero.MASCULINO, "Albuquerque", new Data(1957, 2, 10), 24, 35, 950);

    @Test
    void calcularVencimento() {
        double expected = 950 + 24 * 35;
        assertEquals(expected, treinador.calcularVencimento(), 0.001);
    }

    @Test
    void testToString() {
        String s1 = treinador.toString();
        String s2 = new Treinador().toString();

        System.out.println(s1);
        System.out.println(s2);

        assertNotEquals(s1, s2);
    }

    @Test
    void testEquals() {
        Treinador t = new Treinador();
        assertNotEquals(t, treinador);

        t = treinador;
        assertEquals(t, treinador);
    }
}