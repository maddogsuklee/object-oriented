package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Monom;
import myMath.Polynom;

public class add_polynomT {

	@Test
	public void test() {
		Polynom test= new Polynom("3x");
		Monom m=new Monom(2,1);
		test.add(m);
		Polynom t=new Polynom("5x");
		if (!t.equals(test))
			fail("add monom fail");
	
	}
	
	@Test
	public void test2() {
		
		Polynom test= new Polynom("3x+5");
		Monom m=new Monom(2,1);
		test.add(m);
		Polynom t=new Polynom("5x+5");
		if (!t.equals(test))
			fail("add monom to a long polynom fail");

	
	}

}
