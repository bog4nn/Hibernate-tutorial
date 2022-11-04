package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteEmployee {

	public static void main(String[] args) {
		//Create session factory
				SessionFactory factory =  new Configuration()
										  .configure("hibernate.cfg.xml")
										  .addAnnotatedClass(Employee.class)
										  .buildSessionFactory();
				
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId =1;
			// Start session
			session.beginTransaction();
			// Find column by id 
			Employee theEmloyee = session.get(Employee.class,employeeId);
			System.out.println(theEmloyee);
			
			//Delete column
			session.delete(theEmloyee);
			
			// Commit session
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
