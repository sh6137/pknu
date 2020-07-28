package com.pknu.hello.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	//AOP
	//Aspect Orientted Programming : 관점지향
	//사전, 사후에 필요한 코딩이 자동으로 작동하도록
	//PointCut
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/pknu/hello/aop/beans/animal.xml");
		PetOwner person = (PetOwner) context.getBean("petOwner");
		person.play();
		context.close();
		
	}
}
