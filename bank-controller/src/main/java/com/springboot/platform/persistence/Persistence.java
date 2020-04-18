package com.springboot.platform.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import com.springboot.platform.model.Login;
import com.springboot.platform.model.Signup;

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
	
	@Transactional
	public Object saveObjectToDb(Object obj) {
		entityManager.persist(obj);
		entityManager.flush();
		return obj;
	}
	
	public Object mergeObjectToDb(Object obj) {
		return merge(obj, Object.class);
	}
	
	public Signup deleteObjectfromDB(String id) {
		Signup object = null;
		object = entityManager.find(Signup.class, id);
		entityManager.remove(object);
		return object;
	}
	
	private <T> T merge(T object, Class<T> clazz) {
		T result = entityManager.merge(object);
		entityManager.flush();
		return result;
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
	
	public List<Signup> findListSignup(){
		List<Signup> results = entityManager.createQuery("select s from Signup s ",Signup.class).getResultList();
		if(results.size() > 0 ){
			return results;
		}else{
			return null;
		}
	}
	
	public Signup findSignupById(String id){
		List<Signup> results = entityManager.createQuery("select s from Signup s where s.id = :id",Signup.class)
				.setParameter("id", id).getResultList();
		if(results.size() > 0 ){
			return results.get(0);
		}else{
			return null;
		}
	}
}
