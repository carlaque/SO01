package controller;

public class Mesa {
	private Jogador[] ranking = new Jogador[10];
	private int colocado = 0;
	
	public void setColocado(Jogador jogador) {
		this.ranking[this.colocado] = jogador;
		this.colocado++;
	}
	
	public void showRanking() {
		//System.out.println(ranking.length);
		for(int i = 0; i < 3; i ++) {
			System.out.println(i + 1 + "º lugar o Jogador de numero "+ ranking[i].getNumero());
		}
	}
	
}
