package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstCacheDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		// First cache by default enabled
		
		Student st = s.get(Student.class, 104);
		System.out.println(st);
		
		System.out.println("hello");
		
		Student st1 = s.get(Student.class, 104);
		System.out.println(st1);
		
		System.out.println(s.contains(st1));
		
		s.close();
		factory.close();
	}

}
