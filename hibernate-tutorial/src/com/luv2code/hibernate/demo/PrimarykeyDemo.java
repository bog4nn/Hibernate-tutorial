package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimarykeyDemo {

	public static void main(String[] args) {
		//Create session factory
				SessionFactory factory =  new Configuration()
										  .configure("hibernate.cfg.xml")
										  .addAnnotatedClass(Student.class)
										  .buildSessionFactory();
				
				//Create session
				Session session = factory.getCurrentSession();
				
				try {
					// use the session object to save Java object
					
					// create a 3 student object
					System.out.println("Create new student object...");
					Student tempStudent = new Student("John","Doe","John@luv2code.com");
					Student tempStudent2 = new Student("Poly","Wall","PolyWall@luv2code.com");
					Student tempStudent3 = new Student("Jack","Wall","jackwall@luv2code.com");
					//start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student ...");
					session.save(tempStudent);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit  transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				}finally {
					factory.close();
				}
	}

}
