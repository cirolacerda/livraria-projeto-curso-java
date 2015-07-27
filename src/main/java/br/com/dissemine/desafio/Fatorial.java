package br.com.dissemine.desafio;

public class Fatorial {
	
	public static int calcular (int numero){
		
		if(numero == 0){
			return 1;
		}
		if(numero == 1){
			return 1;
		}
		
		
		return numero * calcular(numero - 1);
		
	}
	
	public static void main(String[] args) {
		
	
	
	int  fat = calcular(5);
	
	System.out.println("5! = " + fat);
	
	

}	
}
