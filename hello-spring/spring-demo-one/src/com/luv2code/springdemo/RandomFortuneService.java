package com.luv2code.springdemo;
import java.util.Random;



public class RandomFortuneService implements FortuneService {

	String[] st = {"Lucky day","Unlucky day", "So so day"}; 
	
	@Override
	public String getFortune() {
		Random rand = new Random();
		return st[rand.nextInt(st.length)];
	}

}
