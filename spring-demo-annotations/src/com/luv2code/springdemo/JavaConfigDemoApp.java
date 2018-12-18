package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
	
		Coach theSillyCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(theSillyCoach.getDailyWorkout());
		System.out.println(theSillyCoach.getDailyFortune());
		
		context.close();
	}
}
