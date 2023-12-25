package org.upskill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    Funcionario funcionario = new Funcionario("Aldina", Genero.OUTRO, "Celourico da Beira", new Data(), 17);

    @Test
    void calcularVencimento() {
        // sal base = 800, preco cliente = 20
        double expected = 800 + 17 * 20;
        assertEquals(expected, funcionario.calcularVencimento(), 0.001);

        // sal base = 640, preco cliente = 16
        Funcionario.setVencimentoBase(640);
        Funcionario.setAcrescimoPorCliente(16);
        expected = 640 + 17 * 16;
        assertEquals(expected, funcionario.calcularVencimento(), 0.001);
    }

    @Test
    void testToString() {
        String s1 = funcionario.toString();
        String s2 = new Funcionario().toString();

        System.out.println(s1);
        System.out.println(s2);

        assertNotEquals(s1, s2);
    }

    @Test
    void testEquals() {
        Funcionario f = new Funcionario();
        assertNotEquals(f, funcionario);

        f = funcionario;
        assertEquals(f, funcionario);
    }
}