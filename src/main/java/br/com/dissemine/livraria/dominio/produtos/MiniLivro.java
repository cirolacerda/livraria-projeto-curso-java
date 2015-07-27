package br.com.dissemine.livraria.dominio.produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.dissemine.livraria.dominio.Autor;

@Entity
@DiscriminatorValue(value="mini")
public class MiniLivro extends Livro {

	public MiniLivro() {
		super();
	}
	
	public MiniLivro(Autor autor, String titulo) {
		super(autor, titulo);
	}

	@Override
	public boolean concederDesconto(Double percentualDesconto) {
		
		System.out.println("Desconto não concedido!");
		System.out.println("Valor sem desconto - Mini Livro: " + valor);
		return false;
	}

}
