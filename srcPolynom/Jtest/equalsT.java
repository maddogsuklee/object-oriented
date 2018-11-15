package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Polynom;

public class equalsT {

	@Test
	public void test() {
		Polynom p1= new Polynom("4x^2+5x-9");
		Polynom p2= new Polynom("4x^2+5x-9");
	if (!p1.equals(p2))
		fail ("equals fail");
	}
	@Test
	public void test2() {
		Polynom p1= new Polynom("4x^2+5x-9");
		Polynom p2= new Polynom("3x^2+5x-9");
		if (p1.equals(p2))
			fail ("equals fail");
	}
	
}
