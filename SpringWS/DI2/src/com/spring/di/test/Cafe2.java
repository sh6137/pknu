package com.spring.di.test;

import org.springframework.beans.factory.annotation.Autowired;

public class Cafe2 {

	private Human human;
	
	public void setHuman(Human human)
	{
		this.human = human;
	}
	
	public void whoEat(){
		human.eat();
	}
	
}
