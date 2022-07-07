package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;



public class SecondCacheExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Student student1 = s.get(Student.class, 104);
		System.out.println(student1);
		s.close();
		
		Session s2 = factory.openSession();
		Student student2 = s2.get(Student.class, 104);
		System.out.println(student2);
		s2.close();
		
		
		
		factory.close();

	}

}
