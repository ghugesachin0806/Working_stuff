package com.springcore.ci;

public class Person {
	
	private String name;
	private int personid;
	private Certy c1;
	
	public Person(String name, int personid, Certy c1) {
		super();
		this.name = name;
		this.personid = personid;
		this.c1 = c1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", personid=" + personid + ", c1=" + c1 + "]";
	}
	
	
}
