package br.com.dissemine.livraria.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Compra {
	
	@Id
	@SequenceGenerator(name = "compraGenerator", sequenceName = "compra_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compraGenerator")
	private Long id;
	
	@OneToMany
	private List<ItemCompra> itensCompras;
	
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemCompra> getItensCompras() {
		return itensCompras;
	}

	public void setItensCompras(List<ItemCompra> itensCompras) {
		this.itensCompras = itensCompras;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
