package com.airtel.agilelab.pnp.pon.PnPDBAsQueueOrderValidation;

import org.apache.commons.text.RandomStringGenerator;
//import org.junit.jupiter.api.Test;


public class ApplicationTests {

	//@Test
	public void contextLoads() {
		System.out.println(" hello junit ");
	}

	//@Test
	public void generateRandomString() {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('1', '9').build();
	
		for(int i=0;i<5;i++)
			System.out.println("===="+generator.generate(5));
	}
}
