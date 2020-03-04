package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OperacoesController {
	
	public OperacoesController() {
		super();
	}

	public void os() {
		String os = System.getProperty("os.name");
		String ver = System.getProperty("os.version");
		String arch = System.getProperty("os.arch");
		
		System.out.println(" os: " + os + "\n ver:" + ver + "\n arch: " + arch ) ;
	}
	
	public void callProcess(String path) {
		try {
			Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if(e.getMessage().contains("740")) {
				StringBuffer b = new StringBuffer();
				b.append("cmd /c");
				b.append(" ");
				b.append(path);
				
				try {
					Runtime.getRuntime().exec(b.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
			}else {
				System.err.print("File not found");
			}
		}
	}
	
	public void readProcess(String command) {
		try {
			Process  p = Runtime.getRuntime().exec(command);
			InputStream stream = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("comando nao encontrado");
		}
		
	}
	
	public void killProcess(String param) {
		String cmdPid = "TASKKILL /PID";
		String cmdNome = "TASKKILL /IM";
		StringBuffer buffer = new StringBuffer();
		int pid = 0;
		
		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		}catch(NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		callProcess(buffer.toString());
	}
}
