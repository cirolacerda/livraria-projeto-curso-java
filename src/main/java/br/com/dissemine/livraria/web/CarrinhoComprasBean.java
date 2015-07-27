package br.com.dissemine.livraria.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.dissemine.livraria.dominio.Compra;
import br.com.dissemine.livraria.dominio.ItemCompra;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
@SessionScoped
public class CarrinhoComprasBean {

	private List<ItemCompra> itensCompra = new ArrayList<ItemCompra>();
	private Livro livro;
	
	public CarrinhoComprasBean(){
		
	}

		
		
	

	public void CarregarLivro() {
		Map<String, String> parametros = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();

		String parametroId = parametros.get("id");

		if (parametroId != null) {
			
			EntityManager em = JPAUtil.getEntityManager();
			livro = em.find(Livro.class, Long.valueOf(parametroId));

		}
	
		
		System.out.println("ID PEGO PAR.: " + parametroId);
	}

	public void adicionarItemCompra() {
		
		CarregarLivro();
		ItemCompra itemCompra = new ItemCompra();
		
				
		itemCompra.setLivro(livro);
		itemCompra.setQuantidade(1);
		
		int posicaoItem = itensCompra.indexOf(itemCompra);
		
		
		if( -1 != posicaoItem ){
			ItemCompra ic = new ItemCompra();
		    ic = itensCompra.get(posicaoItem);
		    ic.setQuantidade(1 + ic.getQuantidade());
		}else{

		itensCompra.add(itemCompra);

		}
		System.out.println("TOTAL ITENS: " + posicaoItem );

		
	}

	public void removerItemCompra(ItemCompra itemCompra) {
		System.out.println("Adicionando Item no Carrinho.. LIVRO: "
				+ itemCompra.getLivro().getTitulo());

		itensCompra.remove(itemCompra);

		System.out.println("TOTAL ITENS: " + itensCompra.size());

	}

	public void finalizarCompra() {

		Compra compra = new Compra();
		compra.setItensCompras(this.itensCompra);
		
		EntityManager em = JPAUtil.getEntityManager();
		em.persist(compra);

	}

	public List<ItemCompra> getItensCompra() {
		return itensCompra;
	}

	public void setItensCompra(List<ItemCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}


	public Livro getLivro() {
		
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
