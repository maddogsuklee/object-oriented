package myMath;

public class Polynom_check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Polynom_able p=new Polynom("3.5x^2-7x+2");  //p=3.5x^2-7x+2   
		
		System.out.println(p);                  
		
		System.out.println(p.f(4));                 //30
		
		Polynom_able w=Polynom.Init("9x+3");    
		
		Polynom_able z=w.copy();                   //z=9x+3   
		
		System.out.println(z);                
		
		Monom m=new Monom(4,2);
		p.add(m);                                 //p=7.5x^2-7x+2 
		System.out.println(p);                
		
		p.add(z);                                 //p=7.5x^2+2x+5
		System.out.println(p);                
		
		p.substract(z);                           //p=7.5x^2-7x+2
		System.out.println(p);              
		
	
		p.multiply(z);                          //p=6+67.5x^3-40.5x^2-3x
		System.out.println(p);                  
		
		System.out.println(p.derivative());     //202.5x^2-81x-3
		
		System.out.println(p.equals(z));        //false
		
		Polynom_able k=Polynom.Init("67.5x^3+6-40.5x^2-3x");   //k=p
		
		System.out.println(k.equals(p));         //true
		
		System.out.println(p.isZero());          //false
		
		System.out.println(p.area(1, 2, 0));     //160.125
		
	
		
	}

}
