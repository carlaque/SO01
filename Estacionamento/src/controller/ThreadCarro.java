package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	private int id;
	private Semaphore semaforo;
	private static int posicaoChegada;
	private static int posicaoSaida;
	
	public ThreadCarro(int id, Semaphore s) {
		this.id = id;
		this.semaforo = s;
	}
	
	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroEstacionado();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			semaforo.release();
			carroSaindo();
		}
	}
	private void carroAndando() {
		int distanciaTotal = (int) (Math.random() * 501 )+ 1500;
		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 30;
		
		while(distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + id + " andou " + distanciaPercorrida + "m.");
		}
		posicaoChegada++;
		System.out.println("#" + id + " foi o " + posicaoChegada + "o. a chegar.");
	}
	private void carroEstacionado() {
		System.out.println("#"+id+"estacionou");
		int tempo = (int) ((Math.random() * 401 ) + 100);
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	private void carroSaindo() {
		posicaoSaida++;
		System.out.println("#" + id + "foi o " + posicaoSaida + "o. a sair");
		
	}
}
