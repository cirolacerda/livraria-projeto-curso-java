package br.com.dissemine.desafio;


public class Condicao {

	public static void main(String[] args) {
		int idade = 16;
		char sexo = 'F';

		if (idade == 18 && sexo == 'F') {

			System.out.println("Menor de idade");
		} else {
			System.out.println("Maior de idade");

		}

		for (int i = 0; i <= 100 ; i++) {
			
			if (i % 3 == 0 ) {
				
				System.out.println("i = " + i);
				
			}
			
		}
		
		

	}

}
