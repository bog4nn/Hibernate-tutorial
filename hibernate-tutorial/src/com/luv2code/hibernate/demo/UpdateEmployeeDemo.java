package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class UpdateEmployeeDemo {

	public static void main(String[] args) {
		// Create Session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		try {
			// Start session
			session.beginTransaction();
			
			// New code
			session.createQuery("Update Employee set first_name='Long', last_name='Phi' Where id=2").executeUpdate();
			
			// Commit session
			session.getTransaction().commit();
			
		}finally{
			factory.close();
		}
	}

}
