package view;

import controller.ArquivoController;

public class Principal {
	public static void main(String[] args) {
		ArquivoController arqCon = new ArquivoController();
		String path = ".\\";
		String nometxt = "relatorio.txt";
		String nomeCsv = "relatorio.csv";
		
		try {
			arqCon.transformarTxtParaCsv(path, nometxt, nomeCsv);
			arqCon.openFile(path, nomeCsv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
