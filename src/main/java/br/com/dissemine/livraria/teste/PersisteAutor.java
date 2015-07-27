package br.com.dissemine.livraria.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

public class PersisteAutor {

	public static void main(String[] args) {
		
		
		EntityManager em =  JPAUtil.getEntityManager();
		
		Autor autor = new Autor();
		autor.setNome("Fulano de Tal");
		autor.setEmail("fulano@gmail.com");
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(autor);
		
		tx.commit();
		
		em.close();
		
		
		
		
		
	}
	
}
