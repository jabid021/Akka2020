package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {
	private EntityManagerFactory emf = null;
	private static Context singleton = null;

	private Context() {
		emf = Persistence.createEntityManagerFactory("baseDemoJPA");
	}

	public static Context getInstance() {
		if (singleton == null) {
			singleton = new Context();
		}
		return singleton;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public static void destroy() {
		if (singleton != null) {
			singleton.emf.close();
			singleton = null;
		}
	}

}
