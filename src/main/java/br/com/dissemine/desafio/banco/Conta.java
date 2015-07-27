package br.com.dissemine.desafio.banco;

public abstract class Conta implements Comparable<Conta> {

	protected String numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(String numero, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;

	}

	public abstract boolean sacar(double valorSaque);

	public boolean depositar(double valorDeposito) {

		if (valorDeposito > 0) {

			this.saldo += valorDeposito;
			System.out.println("\n+ Deposita R$ " + valorDeposito);
			return true;
		}

		return false;
	}

	public boolean transferir(Agencia agencia, Conta conta,
			double valorTranferencia) {

		if (valorTranferencia > 0 && valorTranferencia < this.saldo) {
			
			this.saldo -= valorTranferencia;

			Conta contaCreditar = agencia.buscaConta(conta);
			contaCreditar.setSaldo((contaCreditar.getSaldo() + valorTranferencia));
			System.out.println("+ Transfere R$ "+ valorTranferencia + " da conta: "+ this.getNumero());
			return true;
		}

		return false;

	}

	public double consultarSaldo(Conta conta) {

		return this.saldo;

	}

	@Override
	public int compareTo(Conta outraConta) {

		return this.getCliente().getCpf()
				.compareTo(outraConta.getCliente().getCpf());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}

	// Getters and Setters
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
