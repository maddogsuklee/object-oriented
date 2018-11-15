
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom extends Monom_Comperator implements function{
	
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	// ***************** add your code below **********************


	//****************** Private Methods and Data *****************
	
	public int get_power() {
		// TODO Auto-generated method stub
		return _power;
	}
	public double get_coefficient() {
		// TODO Auto-generated method stub
		return _coefficient;
	}
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}
	
	private double _coefficient; // 
	private int _power;
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		double t=Math.pow(x,_power);
		return t*_coefficient;
	} 
	
	public String toString(){
		
		if (_coefficient==0) return(""+0);
		
		double t=_coefficient;
		int w=(int) t;
		if (t-w!=0){
		if (_power==0) return (""+_coefficient);
		if (_power==1) return (_coefficient+"X");
		return(_coefficient+"X^"+_power);}
		else{
			if (_power==0) return (""+w);
			if (w==1) {
			if (_power==1) return ("X");
			return("X^"+_power);}
			else if (w==-1){
				if (_power==1) return ("-X");
				return("-X^"+_power);}	
			else{
				if (_power==1) return (w+"X");
				return (w+"X^"+_power);
			}
		}
		}
		
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Monom r=new Monom(3.5,6);
	Monom d=new Monom(3.5,3);
	//	System.out.println(r.f(5));
	System.out.println(r.compare(r, d));


	}
}
