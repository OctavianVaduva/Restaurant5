package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}
		catch (Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
