package com.objis.spring.demoinjection;

import org.springframework.stereotype.Service;

@Service
public class Saxophone implements Instrument {

	@Override
	public void jouer() {
		System.out.println("shiou, au saxo");
	}
	

}
