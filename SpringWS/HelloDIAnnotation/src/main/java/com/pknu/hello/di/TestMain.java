package com.pknu.hello.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/pknu/hello/di/beans/animal.xml");
		PetOwner person = (PetOwner) context.getBean("petOwner");
		person.play();
		context.close();
		
	}
}
