package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ProdutoController {

	private final Result result;
	private final ProdutoDao dao;
	private final Validator validator;

	@Deprecated
	ProdutoController() {
		this(null, null, null); // para uso do CDI
	}

	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator) {
		super();
		this.result = result;
		this.dao = dao;
		this.validator = validator;
	}

	@Path("/")
	public void inicio() {

	}

	@Path("/produto/sobre")
	@Get
	public void sobre() {

	}

	@Get
	public List<Produto> lista() {
		return this.dao.lista();
	}

	@Path("produto/formulario")
	@Get
	public void formulario() {

	}

	@Post
	public void adiciona(@Valid Produto produto) {

		/*
		 * this.validator.check(produto.getQuantidade() > 0, new
		 * I18nMessage("erro", "produto.quantidade.negativa"));
		 */

		this.validator.onErrorUsePageOf(this).formulario();

		this.dao.adiciona(produto);

		this.result.include("mensagem", "Produto adicionado com sucesso");
		this.result.redirectTo(this).lista();
	}

	@Path("produto/remove")
	@Delete
	public void remove(Produto produto) {

		this.dao.remove(produto);

		this.result.redirectTo(this).lista();

	}

	@Get
	public void listaXML() {
		this.result.use(Results.xml()).from(this.dao.lista()).serialize();
	}

}
