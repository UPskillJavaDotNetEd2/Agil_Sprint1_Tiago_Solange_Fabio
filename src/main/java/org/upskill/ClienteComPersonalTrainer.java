package org.upskill;

/**
 * Interface que define o comportamento de um cliente com personal trainer.
 * Define um método para calcular o preço do treinador.
 */
public interface ClienteComPersonalTrainer {

    /**
     * Calcula o preço do treinador para o cliente.
     *
     * @return O preço do treinador para o cliente.
     */
    public double calcularPrecoDeTreinador();
}
