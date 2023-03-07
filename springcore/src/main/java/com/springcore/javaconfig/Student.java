package com.springcore.javaconfig;

public class Student {

	private Samosa samosa;

	public void study() {
		this.samosa.display();
		System.out.println("Sachin is studying JAVA : ");
	}

	public Samosa getSamosa() {
		return samosa;
	}

	public void setSamosa(Samosa samosa) {
		this.samosa = samosa;
	}
	
	// constructor
	public Student(Samosa samosa) {
		super();
		this.samosa = samosa;
	}

}
