package br.com.dissemine.livraria.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class CombosAutorLivroBean {

	List<Livro> livros;

	List<Autor> autores;
	
	Livro livro;
		
	Autor autor = new Autor();

	@SuppressWarnings("unchecked")
	public List<Livro> getLivros() {

		
			Query query = JPAUtil.getEntityManager().createNamedQuery(Livro.LIVROS_POR_AUTOR, Livro.class);
		
			query.setParameter("idAutor", autor.getId());

			this.livros = query.getResultList();
		

		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@SuppressWarnings("unchecked")
	public List<Autor> getAutores() {

		if (this.autores == null) {
			Query query = JPAUtil.getEntityManager().createQuery(
					"select a from Autor a", Autor.class);

			this.autores = query.getResultList();

		}

		return autores;

	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	

	
}
