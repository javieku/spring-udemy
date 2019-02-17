package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class EmployeeDemo {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new employee object...");
			
			Employee tmp = new Employee("Paul","Wall","Red Hat");
			
			session.beginTransaction();
			
			System.out.println("Saving the employee...");
			session.save(tmp);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			tmp.setFirstName("John");
			
			session.getTransaction().commit();
			
			Employee another = session.get(Employee.class, tmp.getId());
			
			System.out.println("another employee? " + another );
			
			System.out.println("Done!");
			
		}catch(Exception e ) {
			factory.close();
		}
	}
	
}
