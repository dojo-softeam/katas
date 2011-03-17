package dojo.kata;




import static org.junit.Assert.*;

import org.junit.Test;

import dojo.kata.Morpion2.Results;
import dojo.kata.Morpion2.Values;


public class TestMorpion2{
	@Test public void truth(){
		assertTrue(true);
	}
	@Test 
	public void pasDeVictoire(){
		Morpion2 m =new Morpion2();
		m.joue(Values.X, 1, 1);
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.O, 0, 0);
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.X, 1, 0);		
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.O, 0, 2);
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.X, 1, 2);
		assertEquals(Results.X, m.evalGrille());		

	}
	@Test 
	public void uneLigneDansLaGrille(){
		Morpion2 m =new Morpion2();
		m.joue(Values.X, 1, 1);
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.O, 0, 0);
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.X, 1, 0);		
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.O, 1, 2);
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.X, 2, 2);
		assertEquals(Results.NEXT, m.evalGrille());
		m.joue(Values.O, 0, 2);
		assertEquals(Results.NEXT, m.evalGrille());

	}
}
