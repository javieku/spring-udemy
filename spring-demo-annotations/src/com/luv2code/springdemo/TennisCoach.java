package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
	
	@PostConstruct
	public void init() {
		System.out.println(">> TennisCoach: inside init()");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println(">> Tennis Coach: inside destroy()");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
