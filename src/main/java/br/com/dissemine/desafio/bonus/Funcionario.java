package br.com.dissemine.desafio.bonus;

public abstract class Funcionario {
	
	protected String nome;
	protected String cpf;
	protected int matricula;
	protected double salario;
	
	
	
	public abstract void calcularBonus();



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}



	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	} 

}
