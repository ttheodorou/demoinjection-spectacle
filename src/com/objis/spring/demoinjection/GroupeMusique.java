package com.objis.spring.demoinjection;

import java.util.Collection;

public class GroupeMusique implements Performeur {

	private Collection<Instrument> instruments;

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Collection<Instrument> getInstruments() {
		return instruments;
	}

	public GroupeMusique() {
		super();
	}

	public void performe() throws PerformanceException {
		for (Instrument instrument : instruments) {
			instrument.jouer();
		}
	}

}
