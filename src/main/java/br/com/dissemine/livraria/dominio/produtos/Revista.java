package br.com.dissemine.livraria.dominio.produtos;

import br.com.dissemine.livraria.dominio.Editora;

public class Revista implements Produto {
	
	private String titulo;
	private Editora editora;
	private Double valor;
	
	

	@Override
	public int compareTo(Produto outro) {
	
		return this.getTitulo().compareTo(outro.getTitulo());
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
