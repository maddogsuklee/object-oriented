package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Polynom;

public class subtractT {

	@Test
	public void test() {
		Polynom test= new Polynom("7x^2+4x+2");
		Polynom k= new Polynom("4x^2+5x-9");
		test.substract(k);
		Polynom t=new Polynom("3x^2-x+11");
		if (!t.equals(test))
			fail("subtract polynom fail");	
	}
}
