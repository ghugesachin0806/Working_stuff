package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	// Inserting data of new student
	public int insert(Student st) {
		// TODO Auto-generated method stub
		String qt = "insert into students(id,name,city) values(?,?,?)";

		int result = jdbcTemplate.update(qt, st.getId(), st.getName(), st.getCity());

		return result;
	}

	// updating existing student
	public int update(Student st) {
		// TODO Auto-generated method stub

		String qtString = "update students set name =? , city =? where id =?";

		int result = jdbcTemplate.update(qtString, st.getName(), st.getCity(), st.getId());

		return result;
	}

	// Delete existing student
	public int delete(Student st) {
		// TODO Auto-generated method stub

		String qtString = "delete from students where id =?";

		int result = jdbcTemplate.update(qtString, st.getId());

		return result;
	}

	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub

		String qtString = "select * from students where id =?";

		RowMapper<Student> rowMapper = new RowMapperImpl();

		Student student = this.jdbcTemplate.queryForObject(qtString, rowMapper, studentId);

		return student;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String qtString = "select * from students";
		List<Student> studentList = this.jdbcTemplate.query(qtString, new RowMapperImpl());
		return studentList;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
