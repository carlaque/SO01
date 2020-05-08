package controller;

import java.util.concurrent.Semaphore;

public class Carro extends Thread{
	private static int sentido; // INDICARÁ QUAL SENTIDO ESTA LIVRE
								// cima para baixo 1
								// baixo para cima 2
								// direita para esquerda 3
								// esquerda para direita 4
	private int id;
	private Semaphore semaforo; 
	private int direcao;
	
	public Carro(int id, Semaphore s, int direcao) {
		this.id = id;
		this.semaforo = s;
		this.direcao = direcao;
	}
	
	@Override
	public void run(){
		esperando();
		try {
			semaforo.acquire();
			andando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
			atravessou();
			
			sentido = (int) ((Math.random() * 4 ) + 1); 
		}
	}
	
	private void esperando() {
		try {
			sleep((int) ((Math.random() * 1000 ) + 100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#" + id +" esta esperando sua vez ");
	}
	
	private void andando() {
		try {
			sleep((int) ((Math.random() * 1000 ) + 100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("#" + id + " esta atravessando");
	}
	
	private void atravessou(){
		String aux = " ";
		
		switch (direcao) {
		case 1: 
			aux = "de cima para baixo";
			break;
		case 2:
			aux = "de baixo para cima";
			break;
		case 3: 
			aux = "da direita para esquerda";
			break;
		case 4: 
			aux = "da esquerda para a direita";
			break;
		}
		System.out.println("#" + id + " atravessou " + aux);
	}	 
}
