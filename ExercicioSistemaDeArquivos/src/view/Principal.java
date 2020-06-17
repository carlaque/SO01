package view;

import java.io.IOException;

import controller.ArquivoController;

public class Principal {
	public static void main(String[] args) throws IOException {
		ArquivoController arq = new ArquivoController();
		String arquivo = "cadatro.csv";
		arq.verificaDirTemp();
		
		arq.insereCadastro(arquivo, 0, "joao", "joao@gmail.com");
		arq.insereCadastro(arquivo, 1, "maria", "maria@gmail.com");
		arq.insereCadastro(arquivo, 2, "cecilia", "cecilia@gmail.com");
		arq.insereCadastro(arquivo, 3, "roberto", "roberto@gmail.com");
		arq.insereCadastro(arquivo, 5, "mauricio", "mauricio@gmail.com");
		
		
	}

}
