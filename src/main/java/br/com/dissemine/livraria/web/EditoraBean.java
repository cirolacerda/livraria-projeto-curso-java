package br.com.dissemine.livraria.web;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class EditoraBean {

	private Editora editora = new Editora();

	private List<Editora> editoras;
	
	EntityManager em = JPAUtil.getEntityManager();

	public EditoraBean() {

		Map<String, String> parametros = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();

		String parametroId = parametros.get("id");

		if (parametroId != null) {
			
			editora = em.find(Editora.class, Long.valueOf(parametroId));
			
		}

	}

	public String salvar() {
		
		if (editora.getId() == null) {
			em.persist(editora);	
		}else {
			em.merge(editora);
		}
		
		
		return "listaEditoras.xhtml?faces-redirect=true";

	}

	public void excluir(Editora editora) {
		
		Editora editoraGerenciada = em.merge(editora);
		em.remove(editoraGerenciada);
		
		editoras = null;

	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result
				+ ((editoras == null) ? 0 : editoras.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EditoraBean other = (EditoraBean) obj;
		if (editora == null) {
			if (other.editora != null)
				return false;
		} else if (!editora.equals(other.editora))
			return false;
		if (editoras == null) {
			if (other.editoras != null)
				return false;
		} else if (!editoras.equals(other.editoras))
			return false;
		return true;
	}

	// Getters and Setters
	@SuppressWarnings("unchecked")
	public List<Editora> getEditoras() {
		if (editoras == null) {
			
			Query query = em.createQuery("select a from Editora a",
					Editora.class);

			this.editoras = query.getResultList();

			
		}

		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
