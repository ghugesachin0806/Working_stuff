package com.OnetoMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunClass {
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		/////////////////////////////////////////////////////////////////////////
		
		Question q1 = new Question();
		q1.setQuestionId(4569);
		q1.setQuestion("Area of PICT college ?");
		
		Question q2 = new Question();
		q2.setQuestionId(4588);
		q2.setQuestion("Where is SWARGATE ?");
		
		Answer a1 = new Answer();
		a1.setAnswerId(111);
		a1.setAnswer("Dhankawadi");
		a1.setQuestion(q1);
		
		Answer a2 = new Answer();
		a2.setAnswerId(222);
		a2.setAnswer("Katraj");
		a2.setQuestion(q1);
		
		Answer a3 = new Answer();
		a3.setAnswerId(333);
		a3.setAnswer("Shivajinagar");
		a3.setQuestion(q2);
		
		Answer a4 = new Answer();
		a4.setAnswerId(444);
		a4.setAnswer("PUNE");
		a4.setQuestion(q2);
		
		List<Answer> list1 = new ArrayList<Answer>();
		list1.add(a1);
		list1.add(a2);
		
		q1.setAnswers(list1);
		
		List<Answer> list2 = new ArrayList<Answer>();
		list2.add(a4);
		list2.add(a3);
		
		q2.setAnswers(list2);
		
		
		session.beginTransaction();

		// Object saved in database during transaction
		session.save(q1);
		session.save(q2);
		session.save(a1);
		session.save(a2);
		session.save(a3);
		session.save(a4);

		// Transaction committed
		session.getTransaction().commit();
		
		/////////////////////////////////////////////////////////////////////////
		// Fetching data 
		
		Question question = (Question) session.get(Question.class, 4588);
		
		System.out.println(question.getQuestion());
		
		for(Answer answer : question.getAnswers())
		{
			System.out.println(answer.getAnswer());
		}
		
		session.close();
		factory.close();
	}

}
