package br.com.dissemine.livraria.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.Part;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class LivroImpressoBean {
	
	private static final String DIRETORIO_UPLOAD = "C:/javabasis/tools/apache-tomcat-7.0.62/webapps/uploads";

	private LivroImpresso livroImpresso = new LivroImpresso();
	
	private Autor autor = new Autor();
	
	private Part imagemCapa;
	
	private List<LivroImpresso> livrosImpressos;
	
	EntityManager em = JPAUtil.getEntityManager();

	public LivroImpressoBean() {
		
		


	}
	
	private String salvarImagemUpload(){
		
		InputStream is;
		try {
			
			is = imagemCapa.getInputStream();
			Path temporario = Files.createTempFile(Paths.get(DIRETORIO_UPLOAD), "livroimpresso-", ".jpg");
			Files.copy(is, temporario, StandardCopyOption.REPLACE_EXISTING);
			is.close();
						
			return "/uploads/" + temporario.getFileName().toString();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
		
	}

	public String salvar() {
		
		
		
		if (livroImpresso.getId() == null) {
			
			String urlImagemCapa = salvarImagemUpload();
			livroImpresso.setUrlImagemCapa(urlImagemCapa);
			
			livroImpresso.adicionarAutor(autor);
			
			
			em.persist(livroImpresso);	
			
		}else {
			em.merge(livroImpresso);
		}
		
		
		return "listaLivros.xhtml?faces-redirect=true";

	}

	public void excluir(LivroImpresso livroImpresso) {
		
		LivroImpresso livroImpressoGerenciado = em.merge(livroImpresso);
		em.remove(livroImpressoGerenciado);
		
		livrosImpressos = null;

	}

	// Getters and Setters
	@SuppressWarnings("unchecked")
	public List<LivroImpresso> getLivrosImpressos() {
		
		
		
		if (livrosImpressos == null) {
			
			Query query = em.createQuery("select a from LivroImpresso a join a.autores autor",
					LivroImpresso.class);

			this.livrosImpressos = query.getResultList();

			
		}

		return livrosImpressos;
	}

	public LivroImpresso getLivroImpresso() {
		return livroImpresso;
	}

	public void setLivroImpresso(LivroImpresso livroImpresso) {
		this.livroImpresso = livroImpresso;
	}

	public void setLivrosImpressos(List<LivroImpresso> livrosImpressos) {
		this.livrosImpressos = livrosImpressos;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Part getImagemCapa() {
		return imagemCapa;
	}

	public void setImagemCapa(Part imagemCapa) {
		this.imagemCapa = imagemCapa;
	}

	

}
