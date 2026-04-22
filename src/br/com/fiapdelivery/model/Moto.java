package br.com.fiapdelivery.model;

public class Moto extends Veiculo {

    private boolean possuiBau;

    public Moto(String placa, double capacidadeKg, boolean possuiBau){
        super(placa, capacidadeKg);
        this.possuiBau = possuiBau;
    }

    public boolean isPossuiBau(){
        return possuiBau;
    }

    public String toString() {
        return "Moto [placa=" + getPlaca() + ", capacidade=" + getCapacidadeKg() + "kg, baú=" + (possuiBau ? "sim" : "não") + "]";
    }
}

