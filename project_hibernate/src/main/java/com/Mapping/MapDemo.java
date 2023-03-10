package com.Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		/////////////////////////////////////////////////////////////////////////

		Questions questions1 = new Questions();

		questions1.setQuestionId(111);
		questions1.setQuestion("What is JAVA ?");

		Answers answers1 = new Answers();
		answers1.setAnswerId(2111);
		answers1.setAnswer("Java is langauge...");
		questions1.setAnswer(answers1);
		answers1.setQuestions(questions1);

		Questions questions2 = new Questions();

		questions2.setQuestionId(222);
		questions2.setQuestion("What is Dog ?");

		Answers answers2 = new Answers();
		answers2.setAnswerId(2222);
		answers2.setAnswer("Dog is animal...");
		questions2.setAnswer(answers2);
		answers2.setQuestions(questions2);

		session.beginTransaction();

		// Object saved in database during transaction
		session.save(questions1);
		session.save(questions2);
		session.save(answers1);
		session.save(answers2);

		// Transaction committed
		session.getTransaction().commit();
		
		////////////////////////////////////////////////////////////////////////////
		// fetching data
		
		
		Questions q1 = (Questions)   session.get(Questions.class, 222);
		
		System.out.println(q1.getQuestion());
		System.out.println(q1.getAnswer().getAnswer());

		/////////////////////////////////////////////////////////////////////////
		session.close();
		factory.close();
	}

}
