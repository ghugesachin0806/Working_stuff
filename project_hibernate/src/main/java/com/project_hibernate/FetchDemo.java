package com.project_hibernate;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		
		
		/////////////////////////////////////////////////////////////////////////////////////////

		// session opened and session object returned
		Session session = factory.openSession();
		
		Student student =(Student)session.get(Student.class, 111);
		System.out.println(student);
		
		
		Student student1 =(Student)session.load(Student.class, 222);
		System.out.println(student1);
		
		// session saved
		session.close();
		
		factory.close();
	}

}
