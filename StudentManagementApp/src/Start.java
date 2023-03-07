import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.midi.Soundbank;

import com.student.manager.Student;
import com.student.manager.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to student Management app !");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("PRESS 1 : TO ADD STUDENT ");
			System.out.println("PRESS 2 : TO DELETE STUDENT ");
			System.out.println("PRESS 3 : TO DISPLAY STUDENTS ");
			System.out.println("PRESS 4 : TO EXIT ");

			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				// Add student
				System.out.println("Enter user name : ");
				String name = br.readLine();

				System.out.println("Enter user phone : ");
				String phone = br.readLine();

				System.out.println("Enter user city : ");
				String city = br.readLine();

				Student student = new Student(name, phone, city);

				StudentDao.insertStudentToDB(student);

				System.out.println(student);
			

			}

			else if (c == 2) {
				// Delete student
				System.out.println("Enter student id to delete  :");
				int userID = Integer.parseInt(br.readLine());

			 StudentDao.deleteStudent(userID);


			}

			else if (c == 3) {
				// Display students
				StudentDao.showAllStudents();
			}

			else {
				// Exit
				break;

			}

		}

		System.out.println("Exited from my application !");
	}

}
