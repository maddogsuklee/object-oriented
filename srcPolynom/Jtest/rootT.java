package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Polynom;

public class rootT {

	@Test
	public void test() {
		Polynom test= new Polynom("7x^2+4x+2");
		double a=test.root(1,5 ,100000);
		if (test.f(a)>=100000)
			fail ("root fail");
	}


}
