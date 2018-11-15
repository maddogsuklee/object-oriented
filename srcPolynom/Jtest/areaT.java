package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Polynom;

public class areaT {

	@Test
	public void test() {
		Polynom test=new Polynom("6+67.5x^3-40.5x^2-3x");
		double a=test.area(1, 2,0);
		if (a!=160.125)
			fail("area fail");
	}

}
