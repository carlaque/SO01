package view;

import java.util.concurrent.Semaphore;

import controller.Atleta;
import controller.Ranking;

public class Principal {
	public static void main(String[] args) {
		Ranking ranking = new Ranking();
		Semaphore semaforo = new Semaphore(5);
		Atleta[] atletas = new Atleta[25];
		for (int i = 0; i < 25; i++) {
			atletas[i] = new Atleta(i, semaforo, ranking);
			atletas[i].start();
		}
		
		
		for (Thread t : atletas) {
            try {
                t.join();
            }catch (InterruptedException e) {
            	return ;
            }
		}
		
		ranking.showRanking();
		
	}
}
