package br.com.dissemine.desafio.banco;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

	private String numero;
	private List<Conta> contas = new ArrayList<Conta>();

	public boolean abrirConta(Conta conta) {

		if (contaExiste(conta)) {

			System.out.println("O Cliente '" + conta.getCliente().getNome()
					+ "' já tem uma conta deste tipo");

			return false;
		}

		System.out.println("A conta do cliente '"
				+ conta.getCliente().getNome() + "' foi aberta!");
		contas.add(conta);

		return true;
	}

	public boolean contaExiste(Conta outraConta) {

		for (Conta conta : contas) {

			if (conta.equals(outraConta)) {

				return true;
			}

		}

		return false;
	}

	public Conta buscaConta(Conta outraConta) {

		for (Conta conta : contas) {

			if (conta.equals(outraConta)) {

				return conta;
			}

		}

		return null;

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
}
