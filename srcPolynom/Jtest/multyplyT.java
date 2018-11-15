package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Polynom;

public class multyplyT {

	@Test
	public void test() {
		Polynom test= new Polynom("7x^2+4x+2");
		Polynom k= new Polynom("4x^2+5x");
		test.multiply(k);
		Polynom t=new Polynom("28x^4+51x^3+28x^2+10x");
		if (!t.equals(test))
			fail("multyply polynom fail");
		
	}


}
