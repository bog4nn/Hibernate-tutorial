package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory =  new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(Student.class)
								  .buildSessionFactory();
		
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId =1;
			
			// find out the student's id :primary key
			System.out.println("Saved student. Genarated id :" + studentId);
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			System.out.println("\nGetting student with id:" + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			//Delete the student
			System.out.println("Deleting student"+myStudent);
			session.delete(myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}finally {
			factory.close();
		}
		
	}

}
