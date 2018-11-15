package Jtest;

import static org.junit.Assert.*;

import org.junit.Test;

import myMath.Monom;
import myMath.Polynom;
import myMath.Polynom_able;

public class String_polynomT {

	
	@Test
	public void test() {
		Polynom test= new Polynom();
		Monom m1=new Monom(0,0);
		if (m1.compare(m1, test.getmonlist().get(0))!=0)
			fail("string to polynom fail");

	}
	
	
	
	@Test
	public void test2() {
		Polynom test= new Polynom("4x^2+5x-9");
		Monom m1=new Monom(4,2);
		Monom m2=new Monom(5,1);
		Monom m3=new Monom(-9,0);
		if (m1.compare(m1, test.getmonlist().get(0))!=0)
			fail("string to polynom fail");
		if (m2.compare(m2, test.getmonlist().get(1))!=0)
			fail("string to polynom fail");
		if (m3.compare(m3, test.getmonlist().get(2))!=0)
			fail("string to polynom fail");
	
	



	}

	@Test
	public void test3() {
		Polynom test= new Polynom("0");
		Monom m1=new Monom(0,0);
		if (m1.compare(m1, test.getmonlist().get(0))!=0)
			fail("string to polynom fail");
	

	}

	
	@Test
	public void test4() {
		Polynom test= new Polynom("x");
		Monom m1=new Monom(1,1);
		if (m1.compare(m1, test.getmonlist().get(0))!=0)
			fail("string to polynom fail");
	

	}

	@Test
	public void test5() {
		Polynom_able test= Polynom.Init("5x^4+6");
		Monom m1=new Monom(5,4);
		Monom m2=new Monom(6,0);
		if (m1.compare(m1, test.getmonlist().get(0))!=0)
			fail("string to polynom fail");
		if (m2.compare(m2, test.getmonlist().get(1))!=0)
			fail("string to polynom fail");
	

	}
	
}
