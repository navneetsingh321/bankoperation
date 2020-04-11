package com.springboot.platform.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.springboot.platform.model.Login;

public class Persistence {
	/**
	 * Use this constructor when Spring injects the EntityManager dependency
	 */
	public Persistence() {
	}

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		entityManager = em;
	}

	public void begin() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	public Login findUserByName(String name,String password) {
		List<Login> result = entityManager
				.createQuery("select l from Login l where l.username = :name and l.password = :password",
						Login.class).setParameter("name", name)
						.setParameter("password", password)
						.getResultList();
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
}
