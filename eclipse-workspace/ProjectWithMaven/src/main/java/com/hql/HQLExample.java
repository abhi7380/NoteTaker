package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		// HQL Syntax

		String query = "from Student as s where s.city=:x and s.name=:n";
		Query q = s.createQuery(query);
		q.setParameter("x", "ballia");
		q.setParameter("n", "Chhayya");
		List<Student> list = q.list();

		for (Student stu : list) {
			System.out.println(stu.getName() + " : " + stu.getCerti().getCourse());
		}

		System.out.println("---------------------------------");
		
		//Delete query
		/*
		 * Query q2 = s.createQuery("delete from Student s where s.city=:c");
		 * q2.setParameter("c", "balliaa"); int r=q2.executeUpdate();
		 * System.out.println("deleted"); System.out.println(r);
		 */
		
		//Update query

		/*
		 * Query q3 = s.createQuery("update Student set city=:c where name=:n");
		 * q3.setParameter("c", "lucknow"); q3.setParameter("n", "chayya");
		 * 
		 * int r = q3.executeUpdate(); System.out.println("updated");
		 * System.out.println(r + " objects updated");
		 */
		
		// Join table query
		
		Query q4 = s.createQuery("select q.question, q.qusetionId, a.answer from Question as q INNER JOIN q.answers as a");
		List<Object []> list3 = q4.getResultList();
		
		for(Object[] arr:list3)
		{
			System.out.println(Arrays.toString(arr));
		}
		
		
		

		tx.commit();
		s.close();

		factory.close();
	}

}
