package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Polynom;
import myMath.Polynom_able;

public class polynom_copyT {

	@Test
	public void test() {
		Polynom_able test= new Polynom("7x^2+4x+2");
		Polynom_able k= test.copy();
		if (!k.equals(test))
			fail("polynom copy fail");	
		
	}

	@Test
	public void test2() {
		Polynom test= new Polynom("7x^2+4x+2");	
		Polynom_able t= new Polynom(test);	
		if (!t.equals(test))
			fail("polynom copy fail");
	}
}
