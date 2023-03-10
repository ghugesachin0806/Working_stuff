package com.project_hibernate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		System.out.println("Project started............");

		//////////////////////////////////////////////////////////////////////////////////////////

//        SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();

		//////////////////////////////////////////////////////////////////////////////////////////
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("Enter the value : ");
			int c = Integer.parseInt(reader.readLine());

			if (c != 1)
				break;

			else if (c == 1) {

				Student student = new Student();

				System.out.println("Enter student Id : ");
				int temp1 = Integer.parseInt(reader.readLine());

				System.out.println("Enter student Name : ");
				String name = reader.readLine();

				System.out.println("Enter student city : ");
				String city = reader.readLine();

				student.setId(temp1);
				student.setName(name);
				student.setCity(city);
				System.out.println(student);

				/////////////////////////////////////////////////////////////////////////////////////////

				// session opened and session object returned
				Session session = factory.openSession();

				// session transaction started
				session.beginTransaction();

				// Object saved in database during transaction
				session.save(student);

				// Transaction committed
				session.getTransaction().commit();

				// session saved
				session.close();
			}
		}
		
		
		while (true) {

			System.out.println("Enter the value : ");
			int c = Integer.parseInt(reader.readLine());

			if (c != 1)
				break;

			else if (c == 1) {
				
				Address ad  = new Address();
				
				System.out.println("Enter Steet : ");
				String street = reader.readLine();
				ad.setStreet(street);
				
				System.out.println("Enter city : ");
				String city = reader.readLine();
				ad.setCity(city);
				
				ad.setOpen(true);
				ad.setX(4654.1251);
				
				ad.setCurrDate(new Date());
				
				// Reading Images
				FileInputStream ft = new FileInputStream("src/main/java/com/project_hibernate/green.jpg");
				byte [] data = new byte[ft.available()];
				ft.read(data);
				ad.setImage(data);
				
				/////////////////////////////////////////////////////////////////////////////////////////

				// session opened and session object returned
				Session session = factory.openSession();

				// session transaction started
				session.beginTransaction();

				// Object saved in database during transaction
				session.save(ad);

				// Transaction committed
				session.getTransaction().commit();
 
				// session saved
				session.close();
			}
		}
		
		factory.close();
		System.out.println("Exit successfully ................ ");
 
	}
}
