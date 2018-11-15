package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Polynom;

public class is_zeroT {

	@Test
	public void test() {
		Polynom test= new Polynom("0");
		if (!test.isZero())
			fail("is zero fail");
		
	}

	@Test
	public void test2() {
		
	 Polynom test= new Polynom("7x^2+4x+2");
	   if (test.isZero())
			fail("is zero fail");
		
	}

}
