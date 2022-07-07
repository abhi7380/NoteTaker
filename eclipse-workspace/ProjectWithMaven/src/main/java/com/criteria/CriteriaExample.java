package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Criteria c=s.createCriteria(Student.class);
		
		c.add(Restrictions.eq("certi.course", "android"));
		List <Student> list = c.list();
		for(Student st:list)
		{
			System.out.println(st);
		}
		s.close();
		factory.close();
	}

}
