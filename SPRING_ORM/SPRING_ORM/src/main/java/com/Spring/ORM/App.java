package com.Spring.ORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring.ORM.Dao.studentDao;
import com.Spring.ORM.entities.Student;

import net.bytebuddy.asm.Advice.This;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ORM_config.xml");

		studentDao studentDao = context.getBean("studentDao", studentDao.class);

		// creating student object
//    	Student student = new Student();
//    	student.setStudentCity("PUNE");
//    	student.setStudentId(1526);
//    	student.setStudentName("SACHIN");
//    	
//    	studentDao.insert(student);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("1. ADD NEW STUDENT : ");
			System.out.println("2. DISPLAY STUDENT WITH ID = ");
			System.out.println("3. DISPLAY ALL STUDENTS ");
			System.out.println("4. DELETE STUDENT WITH ID = ");
			System.out.println("5. EXIT");

			try {
				int temp = Integer.parseInt(br.readLine());

				if (temp == 1) {
					// Add new student
					Student student = new Student();

					System.out.println("Enter student Id :");

					int k = Integer.parseInt(br.readLine());

					student.setStudentId(k);

					System.out.println("Enter student name :");
					String nameString = br.readLine();
					student.setStudentName(nameString);

					System.out.println("Enter student city : ");
					String string = br.readLine();
					student.setStudentCity(string);

					studentDao.insert(student);
				} else if (temp == 2) {

					// Display student with student id
					System.out.println("Enter id : ");
					int temp1 = Integer.parseInt(br.readLine());

					Student student = studentDao.getStudent(temp1);

					System.out.println(student);

					System.out.println("Displayed successfully ......... ");
				} else if (temp == 3) {

					// Display all students
					List<Student> students = studentDao.getAllList();

					for (Student st : students) {
						System.out.println(st);
					}
				} else if (temp == 4) {
					// Delete with student id
					System.out.println("Enter id : ");
					int temp1 = Integer.parseInt(br.readLine());

					studentDao.delete(temp1);

				} else {
					break;
				}
			}

			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid Input :");
			}
			
			System.out.println("EXITED SUCCESSFULLY >>>>>>>>>");

		}
	}

}
