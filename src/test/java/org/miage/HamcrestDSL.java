package org.miage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class HamcrestDSL {
	
	@Test
	void verificationNombre() {
		int age = 30;
		assertThat(age, equalTo(30));
		assertThat(age, is(30));
		assertThat(age, not(equalTo(33)));
		assertThat(age, is(not(33)));
		assertThat(age, is(not(equalTo(33))));
		
	}
	
	@Test
	void verificationString() {
		String str = "Un texte";
		assertThat(str,startsWith("U"));
		assertThat(str,endsWith("e"));
		assertThat(str,containsString("ext"));
	}
	
	@Test
	void verificationCollection() {
		List<Double> list = new ArrayList<>();
		list.add(50.00);
		list.add(100.00);
		list.add(300.00);
		assertThat(list, hasItem(50.00));
		assertThat(list, hasItems(50.00, 300.00));
		assertThat(list, not(hasItems(50.00, 67.00)));
		assertThat(list, not(hasItem(60.00)));
	}
	

}
