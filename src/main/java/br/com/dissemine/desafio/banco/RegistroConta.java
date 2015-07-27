package br.com.dissemine.desafio.banco;

public class RegistroConta {

	public static void main(String[] args) {

		Agencia agencia = new Agencia();

		Cliente cliente1 = new Cliente();
		cliente1.setNome("Fulano de Tal");
		cliente1.setCpf("001.222.333-44");

		Cliente cliente2 = new Cliente();
		cliente2.setNome("João da Silva");
		cliente2.setCpf("002.333.444-55");

		Conta conta1 = new ContaCorrente("001", cliente1);

		Conta conta2 = new ContaCorrente("002", cliente2);

		agencia.abrirConta(conta1);
		agencia.abrirConta(conta2);

		conta1 = new ContaCorrente("002", cliente1);
		
		agencia.abrirConta(conta1);
		
		Conta contaMovimentacao = agencia.buscaConta(conta1);
		
		System.out.println("\nConta: "+ contaMovimentacao.getNumero() + "  Cliente: " + contaMovimentacao.getCliente().getNome());
		
		contaMovimentacao.depositar(1000);
		
		System.out.println("Saldo: R$ " + contaMovimentacao.getSaldo());
		
		contaMovimentacao.sacar(100);
		System.out.println("Saldo: R$ " + contaMovimentacao.getSaldo());
		

		contaMovimentacao.sacar(100);
		System.out.println("Saldo: R$ " + contaMovimentacao.getSaldo());
		

		contaMovimentacao.sacar(100);
		System.out.println("Saldo: R$ " + contaMovimentacao.getSaldo());
		

		contaMovimentacao.sacar(100);
		System.out.println("Saldo: R$ " + contaMovimentacao.getSaldo());
		

		contaMovimentacao.sacar(100);
		System.out.println("Saldo: R$ " + contaMovimentacao.getSaldo());
		System.out.println("----------------------------------");
		
		Conta contaMovimentacao2 = agencia.buscaConta(conta2);
		System.out.println("\nConta: "+ contaMovimentacao2.getNumero() + "  Cliente: " + contaMovimentacao2.getCliente().getNome());
		System.out.println("\nSaldo: R$ " + contaMovimentacao2.getSaldo());
		
		contaMovimentacao.transferir(agencia,contaMovimentacao2, 100);
		System.out.println("Saldo: R$ " + contaMovimentacao2.getSaldo());
		System.out.println("----------------------------------");
		
		System.out.println("\nConta: "+ contaMovimentacao.getNumero() + "  Cliente: " + contaMovimentacao.getCliente().getNome());
		System.out.println("\nSaldo: R$ " + contaMovimentacao.getSaldo());
		

	}

}
