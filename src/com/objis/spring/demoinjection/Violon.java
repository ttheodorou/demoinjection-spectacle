package com.objis.spring.demoinjection;

import org.springframework.stereotype.Service;

@Service
public class Violon implements Instrument {

	@Override
	public void jouer() {
		System.out.println("lalala au violon");
	}

}
