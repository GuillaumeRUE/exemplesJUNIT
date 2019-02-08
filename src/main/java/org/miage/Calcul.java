package org.miage;

public class Calcul {

	public int multiplie(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	public int ajoute(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	public int soustrait(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}
	
	public int divise(int x, int y) {
		if(y==0) {
			throw new IllegalArgumentException("Division par zero");
		}
		return x/y;
	}
	
	

}
