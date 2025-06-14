package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

/**
 * Jun 14, 2025,12:52:39 PM
 */
public class App {
	public static void main(String[] args) {
		System.out.println("===  Hibernate Working ====");
		
		
		// 1 
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//System.out.println(sessionFactory);
		
		// 2
		Student student = new Student();
		student.setName("Ankit");
		student.setCollege("GGSIPU");
		student.setActive(true);
		student.setPhone("1234");
		student.setFatherName("Dk");
		
		// 3
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		//4
		try {
			transaction=session.beginTransaction();
			session.persist(student); // Return Void
			transaction.commit();
			System.out.println("== Student Saved Successfully === ");
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
		
	}

}
