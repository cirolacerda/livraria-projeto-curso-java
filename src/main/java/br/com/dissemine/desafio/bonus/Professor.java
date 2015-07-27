package br.com.dissemine.desafio.bonus;

public class Professor extends Funcionario {

	private int horasAula;
	
	@Override
	public void calcularBonus() {
		
		// Calcula Bonus fim de ano
		salario += salario * 0.1;
		
		// Calcula adicional professor
		salario += horasAula * 10;
		
		System.out.println("Bonus Concedido: " + salario);		
		
	}
	
	
	public int getHorasAula() {
		return horasAula;
	}


	public void setHorasAula(int horasAula) {
		this.horasAula = horasAula;
	}


	 @Override
	public String toString() {
		
		return "Professor: " + nome + "\n" + "Salario: " + salario;
	}

}
