package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Principal {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(3);
		
		for(int i = 0; i < 10; i++) {
			ThreadCarro carro = new ThreadCarro(i, s);
			carro.start();
		}
	}
}
