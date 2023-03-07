package com.spring.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;


public class App {
	public static void main(String[] args) throws IOException {

		System.out.println("My program strted...............");

		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDao studentDao = context.getBean("stdImldao", StudentDaoImpl.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("PRESS 1 : TO ADD STUDENT ");
			System.out.println("PRESS 2 : TO UPDATE STUDENT ");
			System.out.println("PRESS 3 : TO DISPLAY SINGLE STUDENT ");
			System.out.println("PRESS 4 : TO DELETE STUDENTS ");
			System.out.println("PRESS 5 : TO DISPLAY STUDENTS ");
			System.out.println("PRESS ANY : TO EXIT ");

			int c = Integer.parseInt(br.readLine());

			if (c == 1) {

				// TO ADD STUDENT

				Student student = context.getBean("student", Student.class);

				System.out.println("Enter id : ");
				int temp1 = Integer.parseInt(br.readLine());

				System.out.println("Enter name : ");
				String temp2 = br.readLine();

				System.out.println("Enter city : ");
				String temp3 = br.readLine();

				student.setId(temp1);
				student.setName(temp2);
				student.setCity(temp3);

				int result = studentDao.insert(student);

				System.out.println("Added successfully ......... " + result);

			}

			else if (c == 2) {

				// TO UPDATE STUDENT

				Student student = context.getBean("student", Student.class);

				System.out.println("Enter id : ");
				int temp1 = Integer.parseInt(br.readLine());

				System.out.println("Enter name : ");
				String temp2 = br.readLine();

				System.out.println("Enter city : ");
				String temp3 = br.readLine();

				student.setId(temp1);
				student.setName(temp2);
				student.setCity(temp3);

				int result = studentDao.update(student);

				System.out.println("Updated successfully ......... " + result);

			}

			else if (c == 3) {

				// TO DISPLAY SINGLE STUDENT

				System.out.println("Enter id : ");
				int temp1 = Integer.parseInt(br.readLine());

				Student student = studentDao.getStudent(temp1);

				System.out.println(student);

				System.out.println("Displayed successfully ......... ");

			}

			else if (c == 4) {

				// TO DELETE STUDENT
				Student student = context.getBean("student", Student.class);

				System.out.println("Enter id : ");
				int temp1 = Integer.parseInt(br.readLine());

				student.setId(temp1);

				int result = studentDao.delete(student);

				System.out.println("Delete successfully ......... " + result);

			}

			else if (c == 5) {

				// TO DISPLAY ALL STUDENTS
				List<Student> listsStudents = studentDao.getAllStudents();

				for (Student st : listsStudents) {
					
					System.out.println(st);
				}

			}

			else {

				// Exit
				break;
			}

		}

	}
}
