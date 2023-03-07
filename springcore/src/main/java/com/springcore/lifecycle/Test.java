package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/lifecycle/lifeconfig.xml");

		Samosa s1 = (Samosa) context.getBean("samosa1");

		System.out.println(s1.toString());
		
		context.registerShutdownHook();

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		Pepsi p1 = (Pepsi) context.getBean("pepsi1");

		System.out.println(p1);
		
		System.out.println("-------------------------------------------------------");
		
		Example e1 = (Example) context.getBean("example1");
		
		System.out.println(e1);
		
		

	}

}
