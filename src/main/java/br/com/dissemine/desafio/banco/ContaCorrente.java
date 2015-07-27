package br.com.dissemine.desafio.banco;

public class ContaCorrente extends Conta{
	
	private int quantidadeSaque = 0;

	public ContaCorrente(String numero, Cliente cliente) {
		super(numero, cliente);
		
	}
	
	//Getters and Setters
	public int getQuantidadeSaque() {
		return quantidadeSaque;
	}

	public void setQuantidadeSaque(int quantidadeSaque) {
		this.quantidadeSaque = quantidadeSaque;
	}

	@Override
	public boolean sacar(double valorSaque) {
		
		if(valorSaque > 0 && valorSaque < this.saldo){
			
			if(quantidadeSaque >= 4){
			
				this.saldo -= valorSaque + 1;
				quantidadeSaque++;
				System.out.println("- Saca R$ "+ valorSaque);
				return true;
			}else {
				
				this.saldo -= valorSaque;
				quantidadeSaque++;
				System.out.println("- Saca R$ "+ valorSaque);
				return true;
			}
			
		}
		
		return false;
	}
	

}
