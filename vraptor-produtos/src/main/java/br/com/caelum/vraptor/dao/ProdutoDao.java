package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.Produto;

public class ProdutoDao {

	private final EntityManager em;

	@Deprecated
	ProdutoDao() {
		this(null);
	}

	@Inject
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void adiciona(Produto produto) {
		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();
	}

	public void remove(Produto produto) {
		this.em.getTransaction().begin();
		this.em.remove(busca(produto));
		this.em.getTransaction().commit();
	}

	public Produto busca(Produto produto) {
		return this.em.find(Produto.class, produto.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Produto> lista() {
		return this.em.createQuery("select p from Produto p").getResultList();
	}
}