package view;

import controller.ThreadCalc;

public class Principal {
	
	public static void main(String[] args) {
		int a  = 10;
		int b = 2;
		//int op = 2;
		
		for (int i = 0; i < 4; i++) {
			
			ThreadCalc t = new ThreadCalc(a, b, i);
			t.start();
		}
		
	}

}
