package com.objis.spring.demoinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Musicien implements Performeur {

	private String morceau;
	@Autowired
	@Qualifier("violon")
	private Instrument instrument;

	public Musicien(String morceau) {
		super();
		this.morceau = morceau;
	}
	public Musicien() {
		super();
	}

	public Musicien(String morceau, Instrument instrument) {
		super();
		this.morceau = morceau;
		this.instrument = instrument;
	}
	public void performe() throws PerformanceException {
		System.out.print("joue " + morceau + " : ");
		instrument.jouer();
	}

	public void setMorceau(String morceau) {
		this.morceau = morceau;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public void arranger() {
		System.out.println("Arrangement de l'instrument avant utilisation");
	}

	public void nettoyer() {
		System.out.println("Nettoyage de l'instrument après utilisation");
	}

}
