package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * Jun 14, 2025,3:41:03 PM
 * com.hibernate.config
 */

import com.hibernate.entity.Student;

public class HibernateUtil_Class {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();

			// 1. DB Connection Properties
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate_db");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "root");
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");

			// 2. Hibernate Properties
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			configuration.setProperty("hibernate.show_sql", "true");
			configuration.setProperty("hibernate.format_sql", "true");

			// 3. Add Annotated Classes
			configuration.addAnnotatedClass(Student.class);

			// 4. Build SessionFactory
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Hibernate session factory creation failed.");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
