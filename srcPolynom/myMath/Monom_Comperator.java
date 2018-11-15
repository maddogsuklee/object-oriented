package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {
	
	
	
	// ******** add your code below *********

	@Override
	public int compare(Monom a, Monom b) {     //if a=b return 0, if a>b return 1, if a<b return -1 
		// TODO Auto-generated method stub
		if (a.get_power()==b.get_power() && a.get_coefficient()==b.get_coefficient())
		return 0;
		else if (a.get_power()>b.get_power())
			return 1;
		else return -1;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monom r=new Monom(3.3,8);
	Monom d=new Monom(3.3,2);
	System.out.println(d.compare(d, r));
	
	

//		System.out.println(r.f(5));
	//System.out.println(r.toString());
		
	//	Polynom e=new Polynom();
	//	System.out.println(e.monlist.get(0));
		
	//	Polynom_able t =Init();
		
		//System.out.println(e.monlist.get(0));
		//System.out.println(9);
		Polynom e=new Polynom("3.5x^2+5x-2");
	}
	// ********** add your code below ***********
	
}
	
	
	
