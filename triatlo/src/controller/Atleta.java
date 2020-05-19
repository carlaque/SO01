package controller;

import java.util.concurrent.Semaphore;

public class Atleta extends Thread{
	private int numero;
	private int pontuacao;
	private Ranking ranking;
	private Semaphore semaforo;
	public static int pontuacaoGeral = 250;
	public static int posicaoChegada;
	
	public Atleta(int num, Semaphore semaforo, Ranking ranking) {
		this.numero = num;
		this.semaforo = semaforo;
		this.ranking = ranking;
	}
	public int getPontuacao() {
		return this.pontuacao;
	}
	public int getNumero() {
		return this.numero;
	}
	
	@Override
	public void run() {
		
		corrida();
		try {
			semaforo.acquire();
			tiro();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {			
			semaforo.release();
			ciclismo();
		}
		
	}
	
	public void corrida() {
		System.out.println("#" + this.numero + " começou a correr.");
		int percurso = 3000; // 3km 
		int percorrido = 0;
		int velocidade = (int) (Math.random() * 5) + 20;
		
		while(percorrido < percurso) {
			percorrido += velocidade;
			try {
				sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("#" + this.numero + " correu " + percorrido + "m.");
		}
		//vai para o tiro
	}
	
	public void tiro() {
		System.out.println("#" + this.numero +" vai atirar");
		int tiros = 0;
		while(tiros < 3) {
			try {
				sleep( (int) (Math.random() * 2500) + 500 ); // espera em segundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int pontos = (int) (Math.random() * 10);
			System.out.println("#" + this.numero + " atirou e marcou " + pontos + " pontos." );
			tiros ++;
			this.pontuacao += pontos;
		}
		// vai para ciclismo
	}
	
	public void ciclismo() {
		System.out.println("#" + this.numero + " começou o ciclismo.");
		int percurso = 5000; // 5km 
		int percorrido = 0;
		int velocidade = ((int) (Math.random() * 10) + 31);
		
		while(percorrido < percurso) {
			percorrido += velocidade;
			try {
				sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("#" + this.numero + " percorreu " + percorrido + "m. de bicicleta");
		}
		this.pontuacao += pontuacaoGeral ;
		this.ranking.setColocado(this);
		System.out.println("#" + this.numero + " terminou na posicao "+ posicaoChegada++ + "º e fez "+  this.pontuacao +" pontos.");
		pontuacaoGeral -= 10;
		
	}
	
	
}
