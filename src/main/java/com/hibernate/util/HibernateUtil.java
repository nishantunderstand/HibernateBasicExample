package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Jun 14, 2025,3:41:03 PM
 * com.hibernate.config
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static SessionFactory sessionFactory1;

	static {
		try {
			if (sessionFactory == null) {
				// Default Approach
				Configuration configuration = new Configuration(); // Step 1: Create Configuration object
				configuration = configuration.configure("hibernate.cfg.xml"); // Step 2: Load config file
				sessionFactory = configuration.buildSessionFactory(); // Step 3: Build SessionFactory

				// Optimized Approach
				sessionFactory1 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
		} catch (Exception e) {
			throw new RuntimeException("Error in Creating Session Factory");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
