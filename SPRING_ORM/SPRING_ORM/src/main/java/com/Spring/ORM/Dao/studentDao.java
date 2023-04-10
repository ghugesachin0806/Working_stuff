package com.Spring.ORM.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.Spring.ORM.entities.Student;

public class studentDao {

	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int insert(Student student) {
		Integer integer = (Integer) this.hibernateTemplate.save(student);
		return integer;
	}

	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	public List<Student> getAllList() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;

	}

	@Transactional
	public void delete(int studentid) {
		Student student = this.hibernateTemplate.get(Student.class, studentid);
		this.hibernateTemplate.delete(student);
	}

	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
