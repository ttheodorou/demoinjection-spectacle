package com.objis.spring.demoinjection.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.spring.demoinjection.Guitare;
import com.objis.spring.demoinjection.Musicien;
import com.objis.spring.demoinjection.Performeur;

@Configuration
@ComponentScan(basePackages = "com.objis.spring.demoinjection")
public class DemoApp {

	private static final Logger logger = Logger.getLogger(DemoApp.class);

	@Bean
	public Musicien bob() {
		Musicien musicien = new Musicien();
		musicien.setMorceau("mon morceau");
		return musicien;
	}

	@Bean
	public Musicien jon() {
		return new Musicien();
	}

	@Bean
	public Musicien ken() {
		return new Musicien("un super morceau");
	}

	@Bean
	public Guitare guitare2() {
		return new Guitare();
	}

	@Bean
	public Musicien paul() {
		return new Musicien("ZeMorceau", guitare2());
	}

	@Bean
	public Musicien paul2() {
		Musicien musicien = new Musicien();
		musicien.setMorceau("ZeMorceau");
		musicien.setInstrument(new Guitare());

		return musicien;
	}

	public static void main(String[] args) {

		// 1. Chargement du conteneur
		ApplicationContext appContext = (ApplicationContext) new ClassPathXmlApplicationContext("spectacle.xml");
		ApplicationContext appContext2 = (ApplicationContext) new AnnotationConfigApplicationContext(DemoApp.class);

		// 2. Recupération d'un bean
		Performeur musicien = (Performeur) appContext.getBean("olivier");
		Performeur musicien5 = (Performeur) appContext.getBean("olivier2");
		Performeur musicien2 = (Performeur) appContext.getBean("jean-marc");
		Performeur musicien3 = (Performeur) appContext.getBean("caroline");
		Performeur musicien4 = (Performeur) appContext.getBean("franck");
		Performeur groupeMusique = (Performeur) appContext.getBean("julien");
		Performeur groupeMusique2 = (Performeur) appContext.getBean("alain");
		Performeur groupeMusique3 = (Performeur) appContext.getBean("alain2");
		Performeur musicien6 = (Performeur) appContext2.getBean("bob");
		Performeur musicien7 = (Performeur) appContext2.getBean("jon");
		Performeur musicien8 = (Performeur) appContext2.getBean("ken");
		Performeur musicien9 = (Performeur) appContext2.getBean("paul");
		Performeur musicien10 = (Performeur) appContext2.getBean("paul2");

		// 3. Manipulation du bean
		System.out.println();

		musicien6.performe();
		System.out.println("");
		musicien7.performe();
		System.out.println("");
		musicien8.performe();
		System.out.println();
		System.out.println("");
		musicien10.performe();
		System.out.println("");
		musicien9.performe();
		System.out.println("");
		System.out.println();
		System.out.println("PASSAGE EN MODE XML");
		System.out.println();
		System.out.println("olivier en autowired sur instrument");
		musicien.performe();
		System.out.println();
		System.out.println("olivier classique");
		musicien5.performe();
		System.out.println();
		musicien2.performe();
		System.out.println();
		musicien3.performe();
		System.out.println();
		musicien4.performe();
		System.out.println();
		groupeMusique.performe();
		System.out.println();
		groupeMusique2.performe();
		System.out.println();
		groupeMusique3.performe();

	}
}
