package com.luv2code.springdemo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private ArrayList<String> data;
	
	FileFortuneService(){
		InputStream is = FileFortuneService.class.getResourceAsStream("fortunes.settings");
		Scanner s = new Scanner(is);
		data = new ArrayList<String>();
	    while (s.hasNextLine()) {
	    	data.add(s.nextLine());
	    }
	    s.close();
	}
	
	@Override
	public String getFortune() {
		System.out.println("Inside getFortune() - FileFortuneService");
		Random rand = new Random();
		return data.get(rand.nextInt(data.size()));
	}

}
