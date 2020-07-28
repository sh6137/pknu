package com.pknu.hello.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logger {
	
	@Pointcut("execution(void com.pknu.hello.aop.*.sound())")
	private void selectSound() {
		
	}
	
	@Before("selectSound()")
	public void aboutToSound() {
		System.out.println("before:about to sound");
	}
}
