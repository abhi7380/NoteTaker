package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Query<Student> query=s.createQuery("from Student",Student.class);
		
		//implementing pagination using Hibernate
		
		query.setFirstResult(0);
		query.setMaxResults(3);
		
		List<Student> li = query.list();
		
		for(Student st:li)
		{
			System.out.println(st.getName()+ " : "+st.getId()+" : "+st.getCity()+ " : "+st.getCerti().getCourse());
		}
		
		
		s.close();		
		factory.close();

	}

}
