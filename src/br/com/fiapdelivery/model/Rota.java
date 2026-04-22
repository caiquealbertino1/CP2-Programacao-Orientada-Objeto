package br.com.fiapdelivery.model;

public class Rota {

    private Pacote pacote;
    private Veiculo veiculo;

    public Rota(Pacote pacote, Veiculo veiculo) {
        if (pacote == null)
            throw new IllegalArgumentException("Pacote nulo.");
        if (veiculo == null)
            throw new IllegalArgumentException("Veículo nulo.");
        this.pacote  = pacote;
        this.veiculo = veiculo;
    }

    public Pacote  getPacote(){
        return pacote;
    }
    public Veiculo getVeiculo(){
        return veiculo;
    }

    public void iniciarEntrega() {
        pacote.atualizarStatus("Em trânsito");
        System.out.println("=== Iniciando Entrega ===");
        System.out.println("Pacote : " + pacote);
        System.out.println("Veículo: " + veiculo);
        System.out.println("========================");
    }
}

