package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivoController implements IArquivoController{
	String path = "C:\\TEMP";

	@Override
	public void verificaDirTemp() throws IOException {
		File dir = new File(path);
		File arq = new File(path, "cadatro.csv");
		
		if(!dir.exists()) dir.mkdir();
			
		if(dir.isDirectory()) {
			
			if(!arq.exists()) {
				FileWriter writer= new FileWriter(arq);
				PrintWriter print = new PrintWriter(writer);
				print.write("Codigo; Nome; Email;\n");

				print.flush();
				print.close();
				writer.close();
			}
			
		}else {
			throw new IOException();
		}
	}

	@Override
	public boolean verificaRegistro(String arquivo, int codigo) throws IOException {
		File arq = new File(path, arquivo);
		boolean achado = false;
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor); 
			String linha = buffer.readLine();
			
			while(linha != null && !achado) {
				String[] l = linha.split(";");
				if(!l[0].equals("Codigo")) 
					if(Integer.parseInt(l[0]) == codigo) achado = true; 
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		return achado;
	}

	@Override
	public void imprimeCadastro(String arquivo, int codigo) throws IOException {
		File arq = new File(path, arquivo);
		if(verificaRegistro(arquivo, codigo)) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor); 
			String linha = buffer.readLine();
			
			boolean achado = false;
			String resposta = "";
			while(!achado) {
				String[] l = linha.split(";");
				if(l[0] != "Codigo") {
					if(Integer.parseInt(l[0]) == codigo) {
						achado = true;
						resposta = "Codigo: " + l[0] +"\n"
								+ "Nome: " + l[1] + "\n"
								+ "Email: " + l[2] + "\n";
						
					}
				}
				linha = buffer.readLine();
			}			
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("codigo "+codigo+" invalido, nao existe");
		}
	}

	@Override
	public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {
		File arq = new File(path, arquivo);
		if(!verificaRegistro(arquivo, codigo)) {
			String conteudo = codigo + ";" + nome + ";" + email + "\n";
			FileWriter writer= new FileWriter(arq, true);
			PrintWriter print = new PrintWriter(writer);
			
			print.write(conteudo);
			print.flush();
			print.close();
			writer.close();
		}else {
			throw new IOException("codigo "+codigo+" invalido, ja existe");
		}
	}

}
