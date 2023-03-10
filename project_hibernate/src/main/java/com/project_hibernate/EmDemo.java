package com.project_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		/////////////////////////////////////////////////////////////////////////////////////////

		// session opened and session object returned
		Session session = factory.openSession();

		Student student = new Student();

		student.setId(888);
		student.setName("Karn");
		student.setCity("Ayodhya");

		Certificate certificate = new Certificate();
		certificate.setCourse("Hibernate");
		certificate.setDuration("11 Months");
		student.setCertificate(certificate);

		Student student1 = new Student();

		student1.setId(999);
		student1.setName("Krishna");
		student1.setCity("vanket");

		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Java");
		certificate1.setDuration("10 Months");

		student1.setCertificate(certificate1);

		session.beginTransaction();

		// Object saved in database during transaction
		session.save(student);
		session.save(student1);

		// Transaction committed
		session.getTransaction().commit();

		// session saved
		session.close();

		factory.close();
	}

}
