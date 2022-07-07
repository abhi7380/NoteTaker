package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Question q1 = new Question();
		q1.setQusetionId(56);
		q1.setQuestion("What is swing framework");
		
		Answer ans = new Answer(25,"used for development");
		Answer ans1 = new Answer(26,"desktop");
		Answer ans2 = new Answer(27,"application");
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		q1.setAnswers(list);
		Transaction tx = s.beginTransaction();
		s.save(q1);
		/*
		 * s.save(ans); s.save(ans1); s.save(ans2);
		 */
		tx.commit();
		
		
		s.close();		
		factory.close();

	}

}
