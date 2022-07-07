package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certficate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Transient state
		// Persistent state
		// Detached State
		// Remove state

		System.out.println("Example");

		// Create session Factory

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// Creating student object

		Student student = new Student();
		student.setId(141);
		student.setName("abhi");
		student.setCity("Ballia");
		student.setCerti(new Certficate("Java", "2 months"));
		// Transient state

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();
		s.save(student);
		// Persistent State

		student.setName("Chhayya");

		tx.commit();
		s.close();
		// Detached State
		student.setName("Julie");
		System.out.println(student);
		factory.close();
	}

}
