package br.com.dissemine.livraria.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.dissemine.livraria.dominio.produtos.Produto;

public class CarrinhoCompras {

	private double valorTotal = 0;
	private List<Produto> produtos = new ArrayList<Produto>();

	public void adiciona(Produto produto) {

		// if (produto instanceof Livro) {

		produtos.add(produto);

		// ((Livro) produto).concederDesconto(0.1);

		valorTotal += produto.getValor();

	}

	public void mostrarItens() {
		
		Collections.sort(produtos);
		
		for (Produto produto : produtos) {

			System.out.println(produto.getTitulo() + "       "
					+ "Valor: R$ " + produto.getValor());
		}

	}

	public double getValorTotal() {
		return valorTotal;
	}

}
