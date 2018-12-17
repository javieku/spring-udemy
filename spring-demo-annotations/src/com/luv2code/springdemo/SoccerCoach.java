package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Soy Mourinho";
	}
	
	@Override
	public String getDailyFortune() {
		return "Practice your backhand volley";
	}

}
