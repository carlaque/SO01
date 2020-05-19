package controller;

public class Ranking {
	private Atleta[] ranking = new Atleta[25];
	private int colocado = 0;
	
	public void setColocado(Atleta atleta) {
		this.ranking[this.colocado] = atleta;
		this.colocado++;
	}
	
	public void showRanking() {
		for(int i=0; i < ranking.length -1; i++) {
			for(int j=0; j < ranking.length -1; j++) {
				if(ranking[j].getPontuacao() < ranking[j+1].getPontuacao()) {
					Atleta aux = ranking[j];
					ranking[j] = ranking[j + 1];
					ranking[j+1] = aux; 
				}
			}
		}
		System.out.println("\n");
		for(int i = 0; i < 25; i++) {
			System.out.println(i + 1 + "o. lugar o atleta numero "+ ranking[i].getNumero() + " e fez " + ranking[i].getPontuacao() +" pontos no total");
		}
	}
	
}
