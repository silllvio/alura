package financas.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("financasBD01");

	 public EntityManager getEntityManager() {
	        return entityManagerFactory.createEntityManager();
	    }

}
