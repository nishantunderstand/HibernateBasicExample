package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil_Class;
import com.hibernate.util.HibernateUtil_XML;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Hibernate Working ===");

        // 1. Get SessionFactory from HibernateUtil
        SessionFactory sessionFactory1 = HibernateUtil_XML.getSessionFactory();
        SessionFactory sessionFactory = HibernateUtil_Class.getSessionFactory();

        // 2. Create Student by Setter 
        // DO NOT set studentId manually
        Student student1 = new Student();
        student1.setName("Tullu");
        student1.setCollege("ABC");
        student1.setPhone("931123");
        student1.setFatherName("ABC");
        student1.setActive(false);
        student1.setAbout("ssllsjjfjlsjfjsl");

        // 3. Create Student by Constructor 
        Student student2 = new Student("Alice", "XYX", "92223", "Mr John", true, "Alice is really smart.");

        // 4. Batch insert using constructor - Java 8
        List<Student> students = new ArrayList<>();
        students.add(new Student("Zendaya1", "NYU", "10001", "Mr. Smith", true, "Zendaya loves acting and dancing."));
        students.add(new Student("Zendaya2", "Harvard", "10002", "Mr. Johnson", true, "Zendaya is passionate about science."));
        students.add(new Student("Zendaya3", "Stanford", "10003", "Mr. Lee", true, "Zendaya excels in computer science."));
        students.add(new Student("Zendaya4", "MIT", "10004", "Mr. Adams", true, "Zendaya enjoys AI and robotics."));
        students.add(new Student("Zendaya5", "UCLA", "10005", "Mr. Brooks", true, "Zendaya is a creative artist and singer."));
        // 5. Batch insert using constructor - Java 9
        List<Student> students1 = List.of(
        	    new Student("Emma Watson", "Oxford", "20001", "Mr. Watson", true, "Emma excels in literature and activism."),
        	    new Student("Robert Downey", "Cambridge", "20002", "Mr. Downey", true, "Robert is passionate about engineering and AI."),
        	    new Student("Scarlett Johansson", "Yale", "20003", "Mr. Johansson", false, "Scarlett is a talented actor and speaker."),
        	    new Student("Chris Evans", "Princeton", "20004", "Mr. Evans", true, "Chris enjoys physics and playing the piano."),
        	    new Student("Natalie Portman", "Columbia", "20005", "Mr. Portman", false, "Natalie is focused on neuroscience and research.")
        	);

        
        // 5. Open Session
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        // 6. Persist Data
        try {
            transaction = session.beginTransaction();

            // Insert single students
            session.persist(student1);
            session.persist(student2);

            // Batch Insert
            for (Student s : students) {
                session.persist(s);
            }

            // Batch Insert-1
            for (Student s : students1) {
                session.persist(s);
            }
            
            transaction.commit();
            System.out.println("== Students Saved Successfully ==");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
