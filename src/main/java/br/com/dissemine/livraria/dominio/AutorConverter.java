package br.com.dissemine.livraria.dominio;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@FacesConverter(forClass = Autor.class)
public class AutorConverter implements Converter {

	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {

		if (string == null || string.isEmpty()) return null;
		Long id = Long.valueOf(string);

		Autor autor = em.find(Autor.class, id);

		return autor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {

		Autor autor = (Autor) object;
		if (autor == null || autor.getId() == null) return null;
		

		return String.valueOf(autor.getId());
	}

}
