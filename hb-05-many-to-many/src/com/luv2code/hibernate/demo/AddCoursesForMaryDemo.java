package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	
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
			
			int id = 2;
			Student mary = session.get(Student.class, id);
			
			System.out.println("Student loaded: " + mary);
			System.out.println("Courses: " + mary.getCourses());
			
			Course course1 = new Course("Rubik cube - How to Speed Cube");
			course1.addStudent(mary);
			session.save(course1);
			
			Course course2 = new Course("Atari 2600 - Game Development");
			course2.addStudent(mary);
			session.save(course2);			
			
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
