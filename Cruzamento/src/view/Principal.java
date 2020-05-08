package view;

import java.util.concurrent.Semaphore;

import controller.Carro;

public class Principal {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 0;i < 4; i++) {
			int direcao = (int) ((Math.random() * 4 ) + 1);
			Carro c = new Carro(i, semaforo, direcao);
			c.start();
		}
		
		
	}

}
