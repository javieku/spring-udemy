package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			/*
			Instructor instructor = new Instructor("Chad","Darby","darby@luv2code.com");
			
			InstructorDetail details = new InstructorDetail("http://www.luv2code.com/youtube",
											"Luv 2 code!!!");
			
			instructor.setInstructorDetails(details);
			*/
			
			Instructor instructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
			
			InstructorDetail details = new InstructorDetail("http://www.youtube.com",
											"Guitar");
			
			instructor.setInstructorDetails(details);
			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + instructor);

			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e ) {
			factory.close();
		}
	}
	
}
