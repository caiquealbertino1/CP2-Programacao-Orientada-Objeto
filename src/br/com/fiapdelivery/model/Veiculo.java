package br.com.fiapdelivery.model;

public abstract class Veiculo {

    private String placa;
    private double capacidadeKg;

    public Veiculo(String placa, double capacidadeKg) {
        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("Placa inválida.");
        if (capacidadeKg <= 0)
            throw new IllegalArgumentException("Capacidade deve ser positiva.");
        this.placa = placa;
        this.capacidadeKg = capacidadeKg;
    }

    public String getPlaca(){
        return placa;
    }
    public double getCapacidadeKg(){
        return capacidadeKg;
    }

    public String toString() {
        return "Veículo [placa=" + placa + ", capacidade=" + capacidadeKg + "kg]";
    }
}
