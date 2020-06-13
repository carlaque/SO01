package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ArquivoController implements IArquivoController{

	@Override
	public void createFile(String path, String nome, String conteudo) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome );
		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			FileWriter writer= new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(writer);
			print.write(conteudo);
			print.flush();
			print.close();
			writer.close();
		}else {
			throw new IOException();
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		}else {
			throw new IOException("Arquivo invalido");
		}
		
	}
	
	public void transformarTxtParaCsv(String path, String nomeTxt, String nomeCsv) throws IOException {
		File arq = new File(path, nomeTxt);
		String txt = "";
		if(arq.exists() && arq.isFile()){
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo, "UTF8");
			BufferedReader buffer = new BufferedReader(leitor); 
			String linha = buffer.readLine();
			while(linha != null) {
				txt += linha + '\n';
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			txt = txt.replaceAll(" ", ";");
			createFile(path, nomeCsv, txt);
			System.out.println("Convertido para .csv com sucesso");
		}else {
			throw new IOException("Arquivo invalido");
		}
	}
	
}
