package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id = 3;
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			System.out.println("Instructor detail: " + detail);
			
			System.out.println("Associated Instructor: " + detail.getInstructor());
			
			System.out.println("Deleting tempInstructorDetail " + detail);
			detail.getInstructor().setInstructorDetails(null);
			session.delete(detail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e ) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
	
}
