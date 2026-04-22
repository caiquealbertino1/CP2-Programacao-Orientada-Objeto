package br.com.fiapdelivery.app;

import br.com.fiapdelivery.model.Caminhao;
import br.com.fiapdelivery.model.Moto;
import br.com.fiapdelivery.model.Pacote;
import br.com.fiapdelivery.model.Rota;

public class Principal {
    public static void main(String[] args) {

        // Entrega 1 — Caminhão
        Caminhao caminhao = new Caminhao("ABC1234", 5000.0, 6);
        Pacote pacotePesado = new Pacote("BR999", 10.5, "Pendente");
        Rota rotaCaminhao = new Rota(pacotePesado, caminhao);
        rotaCaminhao.iniciarEntrega();

        // Entrega 2 — Moto
        Moto moto = new Moto("XYZ5678", 30.0, true);
        Pacote pacoteLeve = new Pacote("SP001", 2.0, "Pendente");
        Rota rotaMoto = new Rota(pacoteLeve, moto);
        rotaMoto.iniciarEntrega();
    }
}

