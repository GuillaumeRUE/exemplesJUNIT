package org.miage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

public class JunitTest {
	
	@BeforeEach
	void avant() {
		System.out.println("Avant chaque test");
	}
	
	@AfterEach
	void apres() {
		System.out.println("Après chaque test");
	}
	
	@BeforeAll
	static void avantTous() {
		System.out.println("Avant tous les test");
	}
	
	@AfterAll
	static void apresTous() {
		System.out.println("Après tous les test");
	}
	
	@Test
	void trueFalse() {
		assertTrue(true);
		assertFalse(false);
	}
	
	@Test
	void nullEtNotNull() {
		Object o = null;
		assertNull(o);
		o = "Valeur";
		assertNotNull(o);
	}
	
	@Test
	void egal() {
		Integer i = 4;
		Integer j = 4;
		assertEquals(i,j);
	}
	
	@Test
	void same() {
		Integer i = 4;
		Integer j = 4;
		assertSame(i,j);
	}
	
	@Test
	void notSame() {
		Integer i = new Integer(4);
		Integer j = new Integer(4);
		assertNotSame(i,j);
	}
	
	//JUnit 5
	@Test
	@DisplayName("Un nom de test a rallonge avec des espaces sa mere")
	void unNouveauTest() {
		assertAll(
					() -> assertEquals(4,2*2, () -> "2 carré"),
					() -> assertEquals(16,4*4, () -> "4 carré")
				);
		Throwable exception = assertThrows(RuntimeException.class, () -> {
			throw new RuntimeException("boom");
		});
		assertEquals("boom",exception.getMessage());
	}
	
	@Test
	void timeout() {
		assertTimeout(Duration.of(1, ChronoUnit.SECONDS), () -> Thread.sleep(990));
	}
	
	@Test
	void assumptionTest() {
		//Si ce test passe on fait
		assumingThat("prod".equals("prod"),
				() -> { assertEquals("String","String");
				});
		assertEquals(2,2);
	}
	
	@TestFactory
	Stream<DynamicTest> dynamic() {
		LocalDate dateJour =  LocalDate.now();
		Iterator<LocalDate> iterationJours = Stream.iterate(dateJour, 
				date -> date.plusDays(1)).limit(10).iterator();
		return stream(iterationJours,
				d -> DateTimeFormatter.ISO_LOCAL_DATE.format(d),
				d -> assertNotNull(d));
	}
	
	
	
	

}
