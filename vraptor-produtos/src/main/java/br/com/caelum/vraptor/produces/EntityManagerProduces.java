package br.com.caelum.vraptor.produces;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.util.JPAUtil;

public class EntityManagerProduces {

	// @Produces
	// @RequestScoped
	public EntityManager produces() {
		return JPAUtil.criaEntityManager();
	}

}
