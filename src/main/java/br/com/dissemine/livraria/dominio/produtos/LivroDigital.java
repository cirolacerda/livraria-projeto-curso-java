package br.com.dissemine.livraria.dominio.produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.dissemine.livraria.dominio.Autor;

@Entity
@DiscriminatorValue(value= "digital")
public class LivroDigital extends Livro {
	
	private String marcaDagua;
	
	public LivroDigital() {
		super();
	}
	
	public LivroDigital(Autor autor, String titulo){
		super(autor, titulo);
		
	}

	
	@Override
	public boolean concederDesconto(Double percentualDesconto) {
		
		if(percentualDesconto <= 0.2){
		valor -= valor * percentualDesconto;
		System.out.println("Valor com desconto - Digital: " + valor);
		return true;
		}
		return false;
		
	}
	
	
	// GETTERs and SETTERs
	public String getMarcaDagua() {
		return marcaDagua;
	}

	public void setMarcaDagua(String marcaDagua) {
		this.marcaDagua = marcaDagua;
	}

}
