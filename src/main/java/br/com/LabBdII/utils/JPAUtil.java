package br.com.LabBdII.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LabBdII-Hibernate");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public void close() {
		emf.close();
	}
}
