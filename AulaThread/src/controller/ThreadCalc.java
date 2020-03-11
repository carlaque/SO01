package controller;

public class ThreadCalc extends Thread{
	private int a, b, op;
	public ThreadCalc(int a, int b, int op) {
		this.a = a;
		this.b = b;
		this.op = op;
	}
	
	@Override
	public void run() {
		calc();
	}
	
	private void calc() {
		try {
			sleep(op * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int res = 0;
		String operacao = "";
		
		switch (op) {
		case 0:
			res = this.a + this.b;
			operacao = "+";
			break;
		case 1:
			res = this.a - this.b;
			operacao = "-";
			break;

		case 2:
			res = this.a * this.b;
			operacao = "*";
			break;

		case 3:
			res = this.a / this.b;
			operacao = "/";
			break;
		}
		
		System.out.println(getId() + " ==>>>  " + a + " " + operacao + " " + b + " = " + res  ); 	
	}
	
}
