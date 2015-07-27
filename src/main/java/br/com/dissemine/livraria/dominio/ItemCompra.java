package br.com.dissemine.livraria.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.dissemine.livraria.dominio.produtos.Livro;

@Entity
public class ItemCompra {
	
	@Id
	@SequenceGenerator(name = "itemCompraGenerator", sequenceName = "itemCompra_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemCompraGenerator")
	private Long id;
	
	@ManyToOne
	private Livro livro;
	
	private Integer quantidade;
	
			
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		ItemCompra other = (ItemCompra) obj;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (0 != livro.compareTo(other.livro))
			return false;
		return true;
	}
	// GETTERs and SETTERs
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
