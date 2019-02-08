package org.miage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculTest {
	
	
	@Test
	void ajouteTest() {
		int x = 5;
		int y = 10;
		int resAttendu = 15;
		Calcul c = new Calcul();
		int res = c.ajoute(x,y);
		assertEquals(resAttendu,res);
	}
	
	@Test
	void ajouteElementNeutre() {
		int x = 5;
		int y = 0;
		int resAttendu = x;
		Calcul c = new Calcul();
		int res = c.ajoute(x,y);
		assertEquals(resAttendu,res);
	}
	
	@Test
	void ajouteSommeElementNeutre() {
		int x = 5;
		int y = -x;
		int resAttendu = 0;
		Calcul c = new Calcul();
		int res = c.ajoute(x,y);
		assertEquals(resAttendu,res);
	}
	
	@Test
	void testMultiplie() {
		int x = 5;
		int y = 3;
		int resAttendu = 15;
		Calcul c = new Calcul();
		int res = c.multiplie(x,y);
		assertEquals(resAttendu,res);
	}
	
	@Test
	void testMultiplieElementNeutre() {
		int x = 5;
		int y = 1;
		int resAttendu = x;
		Calcul c = new Calcul();
		int res = c.multiplie(x,y);
		assertEquals(resAttendu,res);
	}
	
	@Test
	void testSoustraction() {
		int x = 5;
		int y = 3;
		int resAttendu = 2;
		Calcul c = new Calcul();
		int res = c.soustrait(x,y);
		assertEquals(resAttendu,res);
	}
	
	@Test
	void divisionTestPar0() {
		int x = 5;
		int y = 0;
		int resAttendu = x;
		Calcul c = new Calcul();
		assertThrows(IllegalArgumentException.class, () -> {
			int res = c.divise(x, y);
		});
	}
	
	@Test
	void divisionTest() {
		int x = 5;
		int y = 1;
		int resAttendu = 5;
		Calcul c = new Calcul();
		int res = c.divise(x, y);
		assertEquals(resAttendu,res);
	}
	
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
		"0, 1, 1",
		"100, 200, 300",
		"200, -200, 0",
		"3, 0, 3"
	})
	void testParametre(int x, int y, int res) {
		Calcul c = new Calcul();
		assertEquals(res, c.ajoute(x, y), () -> x + " + " + y + " doit être égale à " + res);
	}

}
