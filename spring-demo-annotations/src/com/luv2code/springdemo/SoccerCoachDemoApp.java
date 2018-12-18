package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SoccerCoachDemoApp {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SoccerConfig.class);
	
		Coach soccerCoach = context.getBean("soccerCoach", Coach.class);
		
		System.out.println(soccerCoach.getDailyWorkout());
		System.out.println(soccerCoach.getDailyFortune());
		
		context.close();
	}
}
