package br.com.dissemine.desafio.banco;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String numero, Cliente cliente) {
		super(numero, cliente);

	}

	@Override
	public boolean sacar(double valorSaque) {

		if (valorSaque > 0 && valorSaque < this.saldo) {

			this.saldo -= valorSaque;

			return true;
		}

		return false;
	}

}
