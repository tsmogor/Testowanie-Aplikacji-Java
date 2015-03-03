package zad03;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class LiczbaRzymskaTest {
	
	@Test
	public void verifyRoman3(){
		LiczbaRzymska roman = new LiczbaRzymska(3);
		assertEquals(true, roman.toString().equals("III"));
	}
	
	@Test
	public void verifyRoman8(){
		LiczbaRzymska roman = new LiczbaRzymska(8);
		assertEquals("VIII", roman.toString());
	}
	
	@Test
	public void verifyRoman13(){
		LiczbaRzymska roman = new LiczbaRzymska(13);
		assertNotEquals("shouldn't be equal", roman.toString().equals("XII"));
	}
	
	@Test
	public void verifyRoman421(){
		LiczbaRzymska roman = new LiczbaRzymska(421);
		assertThat("should be equal", roman.toString().equals("CDXXI"));
	}
	
	@Test
	public void verifyRoman5252(){
		LiczbaRzymska roman = new LiczbaRzymska(5252);
		assertNull("Should return null",roman.toString());
	}
	
	@Test
	public void verifyRomanMinus3(){
		LiczbaRzymska roman = new LiczbaRzymska(-3);
		assertFalse("Should return null",roman.toString()!=null);
	}
}
