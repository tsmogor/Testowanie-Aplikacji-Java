package zad04;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class CyfrokradParametrized {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] 
				{{0, null},
				{9, null},
				{-9, null},
				{11, 1},
				{555, 55},
				{-444, -44}
				});
	};
	
	private Integer number;
	private Integer actual;
	
	public CyfrokradParametrized(Integer  number, Integer actual) {
		  this.number = number;
	      this.actual = actual;
	   }
	
	@Test
	public void cyfrokradTest()
	{
		GraLab02 psikus = new GraLab02();
		assertEquals(actual,(psikus.cyfrokrad(number)));
	}
	
};
	
	
