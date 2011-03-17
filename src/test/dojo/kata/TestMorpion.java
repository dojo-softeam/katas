package dojo.kata;


import static org.junit.Assert.*;

import org.junit.Test;

import dojo.kata.Morpion.Results;
import dojo.kata.Morpion.Values;


public class TestMorpion{
	@Test public void truth(){
		assertTrue(true);
	}
	@Test 
	public void pasDeVictoire(){
		Morpion m =new Morpion();
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
		m.print();
	}
	@Test 
	public void uneLigneDansLaGrille(){
		Morpion m =new Morpion();
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
		m.print();
	}
}
