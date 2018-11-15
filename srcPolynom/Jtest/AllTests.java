package Jtest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ add_monomT.class, add_polynomT.class, areaT.class, derivativeT.class, equalsT.class, is_zeroT.class,
		multyplyT.class, polynom_copyT.class, rootT.class, String_polynomT.class, subtractT.class })
public class AllTests {

}
