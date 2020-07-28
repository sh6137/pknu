package com.pknu.hello.aop;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PetOwner {
	//bean 목록에서 필요한 파일을 자동으로 집어넣어라
	
	
	//@Autowired : type 이 같은 bean 을 자동 주입한다.
	//@Qualifier(value="cat") : value 으로 검색
	/*
	@Autowired
	@Qualifier(value="cat")
	*/
	
	//type 대신에 name 으로 의존성 주입
	
	
	private AnimalType animal;
	
	
	
	public PetOwner(AnimalType animal) {
		
		this.animal = animal;
	}



	public void play() {
		animal.sound();
	}
	
	
}
