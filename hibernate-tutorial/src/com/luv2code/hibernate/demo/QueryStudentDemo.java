package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory =  new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Student.class)
								  .buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// Query Student
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//Display Student
			displayStudents(theStudents);
			// Query student : lastName="Doe";
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
			
			//Display Student
			System.out.println("Student who have last name : doe");
			displayStudents(theStudents);
			
			// Query student : lastName='Doe' OR firstName='Poly';
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Poly'").list();
			
			//Display Student
			System.out.println("Student who have lastname : Doe or lastName = Poly");
			displayStudents(theStudents);
			
			// Query student where email LIKE '%luv2code.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list();
			
			//Display Student
			System.out.println("Student who have email luv2code");
			displayStudents(theStudents);
			// commit  transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
