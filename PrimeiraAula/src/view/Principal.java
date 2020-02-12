package view;

import controller.OperacoesController;

public class Principal {
	
	public static void main(String[] args) {
		
		OperacoesController c = new  OperacoesController();
		
		c.OpString();
		c.OpBuffer();
		c.OpFrase("eu amo macarrao com salsicha");
		
	}
}
