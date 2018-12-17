package com.luv2code.springdemo;

public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Soy Mourinho";
	}
	
	@Override
	public String getDailyFortune() {
		return "hahah";
	}

}
