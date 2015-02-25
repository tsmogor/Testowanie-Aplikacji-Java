package zad02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class CalculatorDoubleTest {

	static CalculatorDouble calc = new CalculatorDouble();
	
	@Test
	public void verifyAdd(){
		assertThat("shuld be equal", calc.add(7.6,8.8) == 16.4 );
	}
	
	@Test
	public void verifySub(){
		assertEquals("should be equal", calc.sub(7.3,6.2) == 1.1 );
	}
	
	@Test
	public void verifyMulti(){
		assertThat("shuld be equal", calc.multi(7.5,7.5) == 56.25 );
	}
	
	@Test
	public void verifyDiv(){
		assertThat("Should be equal", calc.div(15.5,2.5) == 6.2);
	}
	
	@Test
	public void verifyGreaterTrue(){
		assertThat("shuld be equal", calc.greater(7.8,6.444) == true );
		assertTrue(calc.greater(7.44,6.1));
	}
	
	@Test
	public void verifyGreaterFalse(){
		assertThat("shuld be equal", calc.greater(6.653,7.525) == false );
		assertFalse(calc.greater(6.9,7.11));
	}
	
	@Test(expected = ArithmeticException.class)
	public void verifyDivByZero(){
		calc.div(7.43,0.0);
	}
	
}