package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	//@Autowired
	//public TennisCoach(FortuneService theFortuneService) {
	//	fortuneService = theFortuneService;
	//}
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	//void setFortuneService(FortuneService theFortuneService) {
	//	System.out.println(">> TennisCoach: inside setFortuneService() method");
	//	fortuneService = theFortuneService;
	//}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
