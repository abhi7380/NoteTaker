package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
	    String q="select * from student";
	    
	    NativeQuery nq = s.createSQLQuery(q);
	    List <Object []> li = nq.list();
	    
	    for(Object[] st: li)
	    {
	    	System.out.println(Arrays.toString(st));
	    }
	    
		
		s.close();
		
		factory.close();

	}

}
