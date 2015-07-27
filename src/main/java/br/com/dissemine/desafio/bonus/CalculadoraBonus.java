package br.com.dissemine.desafio.bonus;

public class CalculadoraBonus {
	
	public static void main(String[] args) {
		
		Professor professor = new Professor();
		professor.setNome("João de Tal");
		professor.setMatricula(00001);
		professor.setCpf("005.002.896-48");
		professor.setSalario(3500);
		
		professor.setHorasAula(20);
		
		System.out.println(professor);
		
		professor.calcularBonus();
		
		System.out.println(professor);
		
		
		
	}
	

}
