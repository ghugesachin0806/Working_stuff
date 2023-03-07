package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/stereotype/standalone_config.xml");

		Person p1 = context.getBean("person2", Person.class);

		System.out.println(p1.toString());
		System.out.println(p1.getAddress());
	}
}
