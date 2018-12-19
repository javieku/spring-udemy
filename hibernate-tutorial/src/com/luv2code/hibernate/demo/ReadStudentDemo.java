package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			
			Student tmp = new Student("Daffy","Duck","daffy@luv2code.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			System.out.println(tmp);
			session.save(tmp);
			
			session.getTransaction().commit();
			
			System.out.println("Saved student. Generated id: " + tmp.getId());
			System.out.println("Done!");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id: " + tmp.getId());
			Student student = session.get(Student.class, tmp.getId());	
		
			System.out.println("Get complete: " + student);
			
			session.getTransaction().commit();
			
		}catch(Exception e ) {
			factory.close();
		}
	}
	
}
