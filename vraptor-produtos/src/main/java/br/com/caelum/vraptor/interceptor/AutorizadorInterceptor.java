package br.com.caelum.vraptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Public;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.controller.UsuarioLogado;

@Intercepts
public class AutorizadorInterceptor {

	private final UsuarioLogado usrLogado;
	private final Result result;
	private final ControllerMethod method;

	@Deprecated
	AutorizadorInterceptor() {
		this(null, null, null);
	}

	@Inject
	public AutorizadorInterceptor(UsuarioLogado usrLogado, Result result, ControllerMethod method) {
		this.usrLogado = usrLogado;
		this.result = result;
		this.method = method;
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {

		if (this.usrLogado.getUsuario() == null) {
			this.result.redirectTo(LoginController.class).formulario();
			return;
		}

		stack.next();
	}

	@Accepts
	public boolean accepts() {
		return !this.method.containsAnnotation(Public.class);
	}

}
