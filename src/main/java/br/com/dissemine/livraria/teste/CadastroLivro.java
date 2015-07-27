package br.com.dissemine.livraria.teste;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;

public class CadastroLivro {
	
	public static void main(String[] args) {
		
		double percentualDesconto = 0.1;
				
		Autor autor = new Autor();
		autor.setNome("Kate Sierra") ;
		autor.setEmail("kate@gmail.com");
		
		Editora editora = new Editora();
		editora.setNome("Moderna");
		editora.setEmail("moderna@gmail.com");
		editora.setUrl("www.moderna.com.br");
		
		Livro livro = new LivroImpresso(autor, "Use a cabeça Java");
	   	livro.setEditora(editora);
		livro.setNumeroPaginas(500);
		livro.setValor(59.90); 
		livro.setIsbn("000-000-000");
		livro.mostrarDetalhes();
		boolean descontoConcedido = livro.concederDesconto(percentualDesconto);
		if(descontoConcedido){
			System.out.println("Valor com desconto: " + livro.getValor());
		}
		
		
		percentualDesconto = 0.3;
		
		Autor outroAutor =  new Autor();
		outroAutor.setNome("Deitel");
		outroAutor.setEmail("deitel@gmail.com");
		
		Editora outraEditora = new Editora();
		outraEditora.setNome("Nova Terra");
		outraEditora.setEmail("novaterra@gmail.com");
		outraEditora.setUrl("www.novaterra.com");
		
		Livro outroLivro =  new LivroImpresso(outroAutor, "Java Como Programar");
		outroLivro.setEditora(outraEditora);
		outroLivro.setNumeroPaginas(450);
		outroLivro.setValor(85.90);
		outroLivro.setIsbn("111-000-000");  
		outroLivro.mostrarDetalhes();
		
		descontoConcedido = outroLivro.concederDesconto(percentualDesconto);
		if(descontoConcedido){
			System.out.println("Valor com desconto: " + outroLivro.getValor());
		}
		
	  
	}

}
