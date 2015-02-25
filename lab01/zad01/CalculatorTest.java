package zad01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class CalculatorTest {

	static Calculator calc = new Calculator();
	
	@Test
	public void verifyAdd(){
		assertThat("shuld be equal", calc.add(7,8) == 15 );
	}
	
	@Test
	public void verifySub(){
		assertThat("shuld be equal", calc.sub(7,6) == 1 );
	}
	
	@Test
	public void verifyMulti(){
		assertThat("shuld be equal", calc.multi(7,7) == 49 );
	}
	
	@Test
	public void verifyDiv(){
		assertEquals(calc.div(14,2),7);
	}
	
	@Test
	public void verifyGreaterTrue(){
		assertThat("shuld be equal", calc.greater(7,6) == true );
		assertTrue(calc.greater(7,6));
	}
	
	@Test
	public void verifyGreaterFalse(){
		assertThat("shuld be equal", calc.greater(6,7) == false );
		assertFalse(calc.greater(6,7));
	}
	
	@Test(expected = ArithmeticException.class)
	public void verifyDivByZero(){
		calc.div(7,0);
	}
	
}
