package view;

import controller.Jogador;
import controller.Mesa;

public class Principal {
	public static void main(String[] args) throws InterruptedException {
		Mesa mesa = new Mesa();
		Jogador[] jogadores = new Jogador[10];
		for (int i = 0; i < 10; i++) {
			jogadores[i] = new Jogador(i, mesa);
			jogadores[i].start();
		}
		jogadores[9].join();
		mesa.showRanking();
	}
}
