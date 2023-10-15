package org.infinite.dbutils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			// Create the configuration object.
			Configuration configuration = new Configuration();
			// Initialize the configuration object with the configuration file
			// data
			configuration.configure("hibernate.cfg.xml");
			// Get the SessionFactory object from configuration.
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
