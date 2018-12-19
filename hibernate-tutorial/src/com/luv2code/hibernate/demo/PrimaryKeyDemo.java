package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			
			Student tmp1 = new Student("John","Doe","john@luv2code.com");
			Student tmp2 = new Student("Mary","Public","mary@luv2code.com");
			Student tmp3 = new Student("Bonita","Applebum","bonita@luv2code.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			session.save(tmp1);
			session.save(tmp2);
			session.save(tmp3);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e ) {
			factory.close();
		}
	}
	
}
