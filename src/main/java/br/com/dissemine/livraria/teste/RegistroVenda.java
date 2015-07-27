package br.com.dissemine.livraria.teste;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.CarrinhoMapa;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroDigital;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.dominio.produtos.MiniLivro;
import br.com.dissemine.livraria.dominio.produtos.Revista;

public class RegistroVenda {

	public static void main(String[] args) {
		CarrinhoMapa carrinho = new CarrinhoMapa();

		Autor autor = new Autor();
		autor.setNome("Martin Fowler");

		Livro livroDigital = new LivroDigital(null,
				"Padrões de integração - Digital");
		livroDigital.setValor(100D);
		carrinho.adiciona(livroDigital, 1);

		Livro livroImpresso = new LivroImpresso(autor,
				"Padrãoes de integração - Impresso");
		livroImpresso.setValor(50D);
		Livro miniLivro = new MiniLivro(autor, "Analysis Patterns");
		miniLivro.setValor(20D);

		Revista revista = new Revista();
		revista.setTitulo("Java Magazine");
		revista.setValor(9.9);

		carrinho.adiciona(livroImpresso, 2);
		carrinho.adiciona(miniLivro, 3);
		carrinho.adiciona(revista, 4);

		carrinho.mostrarItens();

		System.out.println("Total da compra: " + carrinho.getTotalCompra());
	}
}
