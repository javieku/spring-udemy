package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	String[] data = {"Lucky day", "Unlucky day", "So so day"}; 
	
	@Override
	public String getFortune() {
		Random rand = new Random();
		return data[rand.nextInt(data.length)];
	}

}
