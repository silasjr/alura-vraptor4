package br.com.caelum.vraptor.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.model.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
