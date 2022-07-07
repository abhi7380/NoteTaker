package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		// getStudent
		 Student student = (Student)session.load(Student.class, 104);
		 Student student1 = (Student)session.load(Student.class, 104);
		 System.out.println(student.getName());

		//Address address = (Address) session.get(Address.class, 1);
		//System.out.println(address.getStreet());

		//Address address11 = (Address) session.get(Address.class, 1);
	//	System.out.println(address11.getStreet());
		session.close();

		factory.close();

	}

}
