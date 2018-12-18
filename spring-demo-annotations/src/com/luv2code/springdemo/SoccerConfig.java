package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoccerConfig {

	@Bean
	public FortuneService soSoFortuneService() {
		return new SoSoFortuneService();
	}
	
	@Bean
	public Coach soccerCoach() {
		return new SoccerCoach(soSoFortuneService());
	}
}
