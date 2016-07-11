package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("22-Gradebook");

	public static EntityManagerFactory getEmFactory() {
		return emf;

	}

}

