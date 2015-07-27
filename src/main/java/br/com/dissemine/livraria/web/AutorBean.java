package br.com.dissemine.livraria.web;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();
	
	private List<Autor> autores;
	
	EntityManager em = JPAUtil.getEntityManager();
	
	public AutorBean(){
		
		Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		String parametroId = parametros.get("id");
		
		if( parametroId != null){
			
			autor = em.find(Autor.class, Long.valueOf(parametroId));
			
		}
		
	}
	
	public String salvar(){
		
		if(autor.getId() == null){
			em.persist(autor);
		}else {
			em.merge(autor);
		}
		
		
		return "listaAutores.xhtml?faces-redirect=true";
		
			
	}
	
	public void excluir(Autor autor){
		
		Autor autorGerenciado = em.merge(autor);
		em.remove(autorGerenciado);
		autores = null;
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Autor> getAutores(){
		if(this.autores == null){
		Query query = em.createQuery("select a from Autor a", Autor.class);
		
		
		this.autores = query.getResultList();
		
		
		}
		
		return autores;
	}

	//Getters e Setters
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
		
	
	
}
