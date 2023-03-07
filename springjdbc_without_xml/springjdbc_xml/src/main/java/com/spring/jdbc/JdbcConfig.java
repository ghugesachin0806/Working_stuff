package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

@Configuration
public class JdbcConfig {

	@Bean("student")
	public Student getStudent() {

		Student student = new Student();

		student.setId(100);
		student.setName("default_name");
		student.setCity("default_city");

		return student;

	}

	@Bean("ds")
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource dt = new DriverManagerDataSource();

		dt.setDriverClassName("com.mysql.jdbc.Driver");
		dt.setUrl("jdbc:mysql://Localhost:3306/springjdbc");
		dt.setUsername("root");
		dt.setPassword("rivendell");

		return dt;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate geJdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();

		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate;
	}

	@Bean("stdImldao")
	public StudentDaoImpl getStudentDaoImpl() {

		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

		studentDaoImpl.setJdbcTemplate(geJdbcTemplate());

		return studentDaoImpl;
	}

}
