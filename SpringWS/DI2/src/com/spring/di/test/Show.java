package com.spring.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Show {

	public static void main(String[] args) {
		
		//classShow();
		
		diShow();

	}
	
	public static void classShow()
	{
		Man man = new Man();
		Woman woman = new Woman();
		
		Cafe cafe = new Cafe();
		
		cafe.setHuman(man);
		cafe.whoEat();
		
		cafe.setHuman(woman);
		cafe.whoEat();
		
		cafe.test();
	}
	
	public static void diShow()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("di.xml");
		
		Man man = (Man)ac.getBean("man");
		Woman woman = (Woman)ac.getBean("woman");
				
		Cafe2 cafe2 = (Cafe2) ac.getBean("cafe2");
		
		cafe2.setHuman(man);
		cafe2.whoEat();
		
		cafe2.setHuman(woman);
		cafe2.whoEat();
		
		//cafe2.test();
		
	}

}
