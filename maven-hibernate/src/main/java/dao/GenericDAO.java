package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import mavenhibernate.HibernateUtil;

public class GenericDAO <E>{
	
	private EntityManager entityManager = HibernateUtil.geEntityManager();
	
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade); // persistir é salvar
		transaction.commit();
	}
	
	
//
}
