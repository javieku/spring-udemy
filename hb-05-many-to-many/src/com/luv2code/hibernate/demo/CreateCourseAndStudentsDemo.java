package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course course = new Course("Pacman - How to Score One Million Points");
			session.save(course);
			
			Student student1 = new Student("John","Doe","john@luv2code.com");
			Student student2 = new Student("Mary","Public","mary@luv2code.com");
			
			course.addStudent(student1);
			session.save(student1);
			
			course.addStudent(student2);
			session.save(student2);
			
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
