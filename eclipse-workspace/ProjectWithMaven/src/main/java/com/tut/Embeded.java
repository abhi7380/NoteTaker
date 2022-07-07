package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embeded {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Student student1 = new Student();
		student1.setId(121);
		student1.setName("Chayya");
		student1.setCity("ballia");

		Certficate certificate = new Certficate();
		certificate.setCourse("Spring Framework");
		certificate.setDuration("2 Months");
		
		student1.setCerti(certificate);

		Student student2 = new Student();
		student2.setId(131);
		student2.setName("Chaayya");
		student2.setCity("balliaa");

		Certficate certificate2 = new Certficate();
		certificate2.setCourse("Hibernate Framework");
		certificate2.setDuration("2 Months");
		student2.setCerti(certificate2);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(student1);
		s.save(student2);
		tx.commit();
		s.close();

		factory.close();
	}

}
