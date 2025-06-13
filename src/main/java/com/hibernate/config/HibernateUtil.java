package com.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			try {
				// 2. Create Registry
				registry = new StandardServiceRegistryBuilder()
								.configure()
								.build();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return sessionFactory;
	}
	

}
