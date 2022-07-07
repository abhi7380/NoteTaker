package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// creating student

		Student st = new Student();
		st.setId(104);
		st.setCity("Ballia");
		st.setName("Abhishek upadhyay");

		// System.out.println(factory);
		// System.out.println(factory.isClosed());
		System.out.println(st);
		
		
		// Creating address object
		Address address= new Address();
		address.setStreet("Post_office");
		address.setCity("Ballia");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(1545);
		// Reading Image
		FileInputStream fs= new FileInputStream("src/main/java/joydeep.jpeg");
		byte[] data=  new byte[fs.available()];
		fs.read(data);
		address.setImage(data);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(address);
		tx.commit();
		session.close();
		System.out.println("done ");

	}
}
