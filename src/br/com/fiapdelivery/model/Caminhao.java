package br.com.fiapdelivery.model;

public class Caminhao extends Veiculo {

    private int numeroDeEixos;

    public Caminhao(String placa, double capacidadeKg, int numeroDeEixos) {
        super(placa, capacidadeKg);
        if (numeroDeEixos <= 0)
            throw new IllegalArgumentException("Número de eixos inválido.");
        this.numeroDeEixos = numeroDeEixos;
    }

    public int getNumeroDeEixos() { return numeroDeEixos; }

    public String toString() {
        return "Caminhão [placa=" + getPlaca() + ", capacidade=" + getCapacidadeKg() + "kg, eixos=" + numeroDeEixos + "]";
    }
}

