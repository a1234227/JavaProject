package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {
	
	public static void main(String[] args) {
		
		System.out.println(getdb());
		
	}
	
	public static EntityManager getdb() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gjun");
		EntityManager em=emf.createEntityManager();
		return em;
	}

}
