package myMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

import javax.management.ImmutableDescriptor;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	
	ArrayList<Monom> monlist=new ArrayList<Monom>();
	
	public Polynom (String s)  {
		try {
			if (s.contains("++"))       //these only 2 wrong cases wont give a RuntimeException
				throw new RuntimeException();	
		if (s.isEmpty())
       throw new RuntimeException();
		
		s=s.replace("-", "+-");
		String[] arr = s.split("\\+");
		for (int i=0;i<arr.length;i++){
			String m=arr[i];
			if (m.isEmpty()) continue;
			if (m.contains("x^")){  // if polynom 'm' contains: x^
				String[] y = m.split("x");	
				String string_coe=y[0];
	            if (y[0].isEmpty()==true)  //if there is no Coefficient to x, the monom is 'x' 
	            	 string_coe="1.0";
	            if (y[0].equals("-"))     //if the Coefficient of x is '-', the monom is '-x'
	            	 string_coe="-1.0";
				String string_pow=""+y[1].charAt(1);
				double coe= Double.parseDouble(string_coe); // convert string to double
				int pow= Integer.parseInt(string_pow);   // convert string to int
				Monom g=new Monom(coe,pow);
				monlist.add(g);}
			else if (m.contains("x")){ // if polynom 'm' contains: x
				if (m.equals("x")){   //  if the monom is 'x'
					Monom h= new Monom(1,1);
					monlist.add(h);
				}
				else if (m.equals("-x")){ // if the monom is '-x'
					Monom h= new Monom(-1,1);
					monlist.add(h);
				}
				else if (m.equals("0")){ //  if the monom is '0'
					Monom h= new Monom(0,0);
					monlist.add(h);
				}
				else{  //  a standart monom: ax^b
				String[] y = m.split("x");
				String string_coe=y[0];
				
				double coe= Double.parseDouble(string_coe);
				Monom g=new Monom(coe,1);
				monlist.add(g);}}
			else{
				double coe= Double.parseDouble(m);
				Monom g=new Monom(coe,0);
				monlist.add(g);	
			}}
		}
		catch (RuntimeException e) {
			System.out.println("enter a correct polynom");
			Scanner str=new Scanner(System.in);
			String st=str.nextLine();
			Polynom m=new Polynom(st);	
			this.monlist=m.getmonlist();
			
		}
		finally {}
	
	}		
		
	
			
	
	
	
	public Polynom(){
		
		Monom m= new Monom(0,0);
		monlist.add(m);
			
	}
	
	public Polynom(Polynom p){
		for (int i=0;i<p.monlist.size();i++){
			Monom x=p.monlist.get(i);
			monlist.add(x);
			
		}
		
		
	}
	

	public static Polynom_able Init(String s) {
		// TODO Auto-generated method stub
		Polynom_able p=new Polynom(s);
		return p;
		
	}
	

	public static Polynom_able Init(){
		// TODO Auto-generated method stub
		Polynom_able p=new Polynom();
	return p ;
	}
	
	
	

	@Override
	public Polynom_able copy() {
		// TODO Auto-generated method stub
		Polynom_able y=new Polynom(this);
		return y;
	}
	@Override
	public ArrayList<Monom> getmonlist() {
		// TODO Auto-generated method stub
		return monlist;
	}
	

	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		double sum=0;
		for (int i=0;i<monlist.size();i++)
		sum =sum+monlist.get(i).f(x);	
		return sum;
	}

	@Override
	public void add(Polynom_able p1) {    
		// TODO Auto-generated method stub
		for (int i=0;i<p1.getmonlist().size();i++){
			Monom x=p1.getmonlist().get(i);
			this.add(x);
		}
	
		
	}

	@Override
	public void add(Monom m1) {
		// TODO Auto-generated method stub
		int index=this.getpowindex(m1); // finding the power of monom 'm1' in the polynom
		if (index==-1) // the power of 'm1' not found in the polynom
			monlist.add(m1);
		else {
		double coe=monlist.get(index).get_coefficient();
		double sum=coe+m1.get_coefficient();
		Monom y= new Monom(sum,m1.get_power());
		monlist.set(index,y);    //replace the old monom with the calculated monom
			
		}
	
			
		
		
	}

	@Override
	public void substract(Polynom_able p1) {   
		// TODO Auto-generated method stub
		for (int i=0;i<p1.getmonlist().size();i++){
			double coe=p1.getmonlist().get(i).get_coefficient();
			coe=coe*(-1);   //changing the sign of every monom in p1 and then add regular
			int pow= p1.getmonlist().get(i).get_power();
			Monom x= new Monom(coe,pow);
			this.add(x);
		}
	}

	@Override
	public void multiply(Polynom_able p1) {     
		// TODO Auto-generated method stub
		Polynom p=new Polynom();
		for (int i=0;i<monlist.size();i++){
			Monom x=monlist.get(i);
			for (int j=0;j<p1.getmonlist().size();j++){
				Monom y=p1.getmonlist().get(j);
				double coe=x.get_coefficient()*y.get_coefficient();
				int pow=x.get_power()+y.get_power();
				Monom m= new Monom(coe,pow);
				p.add(m);
			
			}
		}
		// a case that the new array of monoms contains zero monom
		Monom zero=new Monom(0,0);     
		for (int i=0;i<p.monlist.size();i++)
			if (zero.compare(zero, p.monlist.get(i))==0)
				p.monlist.remove(i);
		monlist=p.monlist;
		
		}
			
	

	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		Polynom p= new Polynom(); 
		for (int i=0;i<monlist.size();i++)
			p.monlist.add(monlist.get(i));
		
		for (int i=0;i<p.monlist.size();i++){
			Monom x=p.monlist.get(i);
			if (x.get_power()==0){
				p.monlist.remove(i);
			i--;}
			else {
			double coe=x.get_coefficient()*x.get_power();
			int pow=x.get_power()-1;
			Monom m= new Monom(coe,pow);
			p.monlist.set(i,m);
			}
		}
		Polynom_able r= new Polynom(p);
		return r;
		
		
		
	}

	
	@Override
	public boolean equals(Polynom_able p1) {     
		// TODO Auto-generated method stub
		if (this.isZero()==true && p1.isZero()==true) // both are zero polynom
			return true;
		else if (this.monlist.size()!=p1.getmonlist().size())// if the size of both polynoms is different then false
			return false;
		else{
		for (int i=0;i<monlist.size();i++){ // check if every monom of 'p1' is in this polynom
			Monom m=monlist.get(i);
			if (p1.getmonindex(m)==-1) // -1 if the monom not found
				return false;
			
		}
			
			return true;	
					
		}
		}
					
		
		
	

	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		boolean b=true;
		for (int i=0;i<monlist.size();i++){
			Monom m=monlist.get(i);
			if (m.get_coefficient()!=0)
				b=false;
		}
		return b;
			
		}
	

	@Override
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		Random r = new Random();
		double randomValue = x0 + (x1 - x0) * r.nextDouble();	
	while (Math.abs(this.f(randomValue))>eps)
		randomValue = x0 + (x1 - x0) * r.nextDouble();	
	return randomValue;
	}
	

	
	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		Polynom p= new Polynom(); 
		p.monlist=monlist;
		
		for (int i=0;i<p.monlist.size();i++){ // calculates the integral function
			Monom x=p.monlist.get(i);
			int pow=x.get_power()+1;
			double coe=x.get_coefficient()/pow;
			Monom m= new Monom(coe,pow);
			p.monlist.set(i,m);
		}
			
		double upper= p.f(x1);  //calculates the area
		double down= p.f(x0);
		
		return upper-down;
	}

	@Override
	public Iterator<Monom> iteretor() {
		// TODO Auto-generated method stub
		Iterator<Monom> it =monlist.iterator();
		return it;
	}

	public String toString(){
		if (this.isZero()==true) // if the zero polynom
			return ("0");
		String s="";
		for (int i=0;i<monlist.size();i++){
			if (monlist.get(i).get_coefficient()!=0){
			String m=monlist.get(i).toString();
			if (m.charAt(0)!='-')
				  m="+"+m;
					s=s+m;
		}}
		if (s.charAt(0)=='+'){  //solvig a case that the polynom starts in '+'
		String arr="";
		for (int i=1;i<s.length();i++)
			arr=arr+s.charAt(i);
		s=arr;
		}
	
		return s;
	}

	
	//this function search the monom 'm' in the polynom 
	//if 'm' is in the polynom then return its index
	//if 'm' is not in the polynom return -1
	
public int getmonindex(Monom m){   
	for (int i=0;i<monlist.size();i++)
		if (m.compare(m, monlist.get(i))==0)
			return i;
		return -1;		
}
	

// this functiom search a monom in the polynom which has a same
//power of monom 'm'. 
//if found then return its index, if not found return -1

public int getpowindex(Monom m){
	for (int i=0;i<monlist.size();i++)
		if (monlist.get(i).get_power()==m.get_power())
			return i;
	return -1;
	
	
}

}
	

