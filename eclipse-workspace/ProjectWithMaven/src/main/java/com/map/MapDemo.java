package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		  
		/*
		 * Question q1 = new Question(); q1.setQusetionId(1212);
		 * q1.setQuestion("What is java");
		 * 
		 * // Creating answer
		 * 
		 * Answer ans = new Answer(); ans.setAnswerId(343);
		 * ans.setAnswer("java is a programming language"); ans.setQuestion(q1);
		 * 
		 * Answer ans1 = new Answer(); ans1.setAnswerId(33);
		 * ans1.setAnswer("object oriented language"); ans1.setQuestion(q1);
		 * 
		 * 
		 * Answer ans2 = new Answer(); ans2.setAnswerId(34);
		 * ans2.setAnswer("java has diferent types of frameworks");
		 * ans2.setQuestion(q1);
		 * 
		 * List<Answer> list=new ArrayList<Answer>(); list.add(ans); list.add(ans1);
		 * list.add(ans2);
		 * 
		 * q1.setAnswers(list);
		 */
		 

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		
		/*  s.save(q1); s.save(ans); s.save(ans1); s.save(ans2);  */
		 

		Question q = (Question) s.get(Question.class, 1212);
		System.out.println(q.getQusetionId());
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswers().size());
		
		//System.out.println(q.getAnswers().size());
		
		/*
		 * System.out.println(q.getQuestion()); for (Answer a : q.getAnswers()) {
		 * System.out.println(a.getAnswer()); }
		 */

		tx.commit();
		s.close();
		factory.close();

	}

}
