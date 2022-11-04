package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		// Create Session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			//Create new employee object
			Employee theEmployee = new Employee("Jack","Wall","FPT");
			Employee theEmployee2 = new Employee("Neo","Dawn","VBC");
			Employee theEmployee3 = new Employee("Gumble","Westerson","CN");
			
			//begin transaction
			session.beginTransaction();
			
			//save session
			System.out.println("save new data");
			session.save(theEmployee);
			session.save(theEmployee2);
			session.save(theEmployee3);


			//commit session
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			factory.close();
		}
	}

}
