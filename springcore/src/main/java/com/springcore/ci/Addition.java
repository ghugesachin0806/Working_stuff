package com.springcore.ci;

public class Addition {

	private int a;
	private int b;

	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;

		System.out.println("int constructor called : ");
	}

	public Addition(String a, String b) {
		super();
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);

		System.out.println("String constructor called : ");

	}

}
