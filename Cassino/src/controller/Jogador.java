package controller;

public class Jogador extends Thread{
	private int numero;
	private int pontuacao = 0;
	private Mesa mesa;
	
	public Jogador(int numero, Mesa mesa){
		this.numero = numero;
		this.mesa = mesa;
	}
	public int getNumero() {
		return this.numero;
	}
	public int getPontuacao() {
		return this.pontuacao;
	}
	public Mesa getMesa() {
		return mesa;
	}
	
	@Override
	public void run() {
		jogaDados();
	}
	
	public void jogaDados(){
		while(this.pontuacao<5) {
			int soma = (int)(Math.random()*6)+1 + (int)(Math.random()*6)+1;
			if(soma == 7 || soma == 11) 
				this.pontuacao++;
		}
		this.mesa.setColocado(this);
		
	}

}
