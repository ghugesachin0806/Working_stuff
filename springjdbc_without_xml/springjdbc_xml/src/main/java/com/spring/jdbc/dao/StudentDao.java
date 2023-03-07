package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {

	public int insert(Student st);

	public int update(Student st);

	public int delete(Student st);

	public Student getStudent(int studentId);

	public List<Student> getAllStudents();

}
