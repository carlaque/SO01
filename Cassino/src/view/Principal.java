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
			//System.out.println("inicio j >>> " + i);
		}
		jogadores[9].join();
		mesa.showRanking();
		/*boolean rolar = true;
		while(rolar) {			
			for(int i = 0; i < 10; i++) {
				System.out.println(jogadores[i].getPontuacao());
				if(jogadores[i].getPontuacao() == 5) {
					System.out.println("VENCEU O JOGADOR =>>>>" + jogadores[i].getNumero() );
					rolar = false;
				}
			}
			
		}*/
		
	}
}
