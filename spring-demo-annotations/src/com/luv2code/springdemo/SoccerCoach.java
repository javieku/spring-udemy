package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

	private FortuneService fortuneService;
	
	public SoccerCoach() {}
	
	public SoccerCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Soy Mourinho";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
