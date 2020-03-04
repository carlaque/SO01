package view;

import controller.OperacoesController;

public class Principal {
	public static void main(String[] args) {
		OperacoesController oc = new OperacoesController();
		//oc.os();
		
		//String path = "regedit.exe";
		//oc.callProcess(path);
		
//		String command = "TRACERT www.fateczl.edu.br";
		//String command = "ping 8.8.8.8";
		//oc.readProcess(command);
		String param = "notepad.exe";
		oc.killProcess(param);
	}
}
