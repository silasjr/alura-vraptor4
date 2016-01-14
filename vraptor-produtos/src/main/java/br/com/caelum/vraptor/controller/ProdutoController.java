package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {

	private Result result;
	
	@Deprecated
	ProdutoController() {
	    this(null); // para uso do CDI
	}
	
	@Inject
	public ProdutoController(Result result) {
		super();
		this.result = result;
	}

	@Path("/")
	public void inicio() {

	}

	@Path("/produto/sobre") @Get
	public void sobre() {

	}

	@Get
	public List<Produto> lista() {
		final EntityManager em = JPAUtil.criaEntityManager();
		final ProdutoDao dao = new ProdutoDao(em);
		return dao.lista();
	}

	@Path("produto/formulario") @Get
	public void formulario() {

	}

	@Post
	public void adiciona(Produto produto) {
		final EntityManager em = JPAUtil.criaEntityManager();
		final ProdutoDao dao = new ProdutoDao(em);
		em.getTransaction().begin();
		dao.adiciona(produto);
		em.getTransaction().commit();
		
		this.result.include("mensagem", "Produto adicionado com sucesso");
		this.result.redirectTo(this).lista();
	}

	@Path("produto/remove") @Delete
	public void remove(Produto produto) {
		final EntityManager em = JPAUtil.criaEntityManager();
		final ProdutoDao dao = new ProdutoDao(em);
		em.getTransaction().begin();
		dao.remove(produto);
		em.getTransaction().commit();
		
		this.result.redirectTo(this).lista();
	}
	
	@Get
	public void listaXML() {
		final EntityManager em = JPAUtil.criaEntityManager();
		final ProdutoDao dao = new ProdutoDao(em);
		
		this.result.use(Results.xml()).from(dao.lista()).serialize();
	}

}
