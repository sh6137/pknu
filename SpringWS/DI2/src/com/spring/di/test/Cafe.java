package com.spring.di.test;

import org.springframework.beans.factory.annotation.Autowired;

public class Cafe {

	@Autowired
	private Cafe2 cafe2;
	
	private Human human;
	
	public void setHuman(Human human)
	{
		this.human = human;
	}
	
	public void whoEat(){
		human.eat();
	}
	
	public void test()
	{
		cafe2.whoEat();
	}
	
	
}
