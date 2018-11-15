package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Polynom;

public class derivativeT {

	@Test
	public void test() {
		Polynom test=new Polynom("6+67.5x^3-40.5x^2-3x");
		test=(Polynom) test.derivative();
		Polynom t=new Polynom("202.5x^2-81x-3");
		if (!t.equals(test))
			fail(" derivative fail");	
		
	}

}
