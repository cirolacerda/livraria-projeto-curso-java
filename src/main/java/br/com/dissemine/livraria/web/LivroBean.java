package br.com.dissemine.livraria.web;

import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class LivroBean {

		
	private List<Livro> livros = Collections.emptyList();

	private String titulo;

	EntityManager em = JPAUtil.getEntityManager();

	// Getters and Setters
	@SuppressWarnings("unchecked")
	public List<Livro> carregarLivros() {
		if (livros == null) {

			Query query = em.createNamedQuery(Livro.LIVROS_EM_ESTOQUE,
					Livro.class);
			query.setParameter("tituloLivro", "%" + titulo + "%");
			this.livros = query.getResultList();

		}

		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Livro> getLivros() {
		carregarLivros();
		return livros;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
