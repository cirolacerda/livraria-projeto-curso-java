package br.com.dissemine.livraria.teste;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.CarrinhoCompras;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroDigital;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.dominio.produtos.MiniLivro;
import br.com.dissemine.livraria.dominio.produtos.Revista;

public class RegistroVendaOLD {

	public static void main(String[] args) {
		
		CarrinhoCompras carrinho = new CarrinhoCompras();
		
		Autor autor = new Autor();
		autor.setNome("Martin Fowler");
		
		LivroDigital livroDigital = new LivroDigital(autor, "Padrões de Integração - Digital");
		livroDigital.setValor(100D);
		
		LivroImpresso livroImpresso = new LivroImpresso(autor, "Analysis Patterns - Impresso");
		livroImpresso.setValor(50D);
		
		Livro miniLivro = new MiniLivro(autor, "Padrões de Integração - Mini Livro");
		miniLivro.setValor(20D);
		
		Revista revista =  new Revista();
		revista.setTitulo("Java Magazine");
		revista.setValor(9.9);
		
		carrinho.adiciona(revista);
		carrinho.adiciona(livroDigital);
		carrinho.adiciona(livroImpresso);
		carrinho.adiciona(miniLivro);
		
		carrinho.mostrarItens();
		
		System.out.println("\nTotal da compra: R$ " + carrinho.getValorTotal());
		
	}

}
