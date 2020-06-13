package controller;

import java.io.IOException;

public interface IArquivoController {
	public void createFile(String path, String nome, String conteudo) throws IOException;
	public void openFile(String path, String nome) throws IOException;
}
