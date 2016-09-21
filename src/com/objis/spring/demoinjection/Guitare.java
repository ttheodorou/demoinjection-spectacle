package com.objis.spring.demoinjection;

import org.springframework.stereotype.Service;

@Service
public class Guitare implements Instrument {

	@Override
	public void jouer() {
		System.out.println("nanana avec une guitare");
	}

}
