package br.com.dissemine.livraria.dominio.produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.dissemine.livraria.dominio.Autor;

@Entity
@DiscriminatorValue(value = "impresso")
public class LivroImpresso extends Livro {

	private Double peso;
	private Double altura;
	private Double largura;

	public LivroImpresso() {
	    super();
	}

	public LivroImpresso(Autor autor, String titulo) {
		super(autor, titulo);
	}

	@Override
	public boolean concederDesconto(Double percentualDesconto) {

		if (percentualDesconto <= 0.3) {
			valor -= valor * percentualDesconto;
			System.out.println("Valor com desconto - Livro: " + valor);
			return true;
		}
		return false;

	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + ((largura == null) ? 0 : largura.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroImpresso other = (LivroImpresso) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (largura == null) {
			if (other.largura != null)
				return false;
		} else if (!largura.equals(other.largura))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}

	// GETTERs and SETTERs
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	
	
}
