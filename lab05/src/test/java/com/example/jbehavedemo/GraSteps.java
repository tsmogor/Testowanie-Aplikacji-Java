package com.example.jbehavedemo;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.mockito.MockitoAnnotations.Mock;

public class GraSteps {
	
	private GraLab02 gra;
	
	@Given("a game")
	public void calulatorSetup(){
		@Mock GraLab02 gra;
		gra = new GraLab02();
	}
	
	@When("set arguments to $a")
	public void setArguments(Integer a){
		gra.setliczba(a);
	}
	
    @Then("cyfrokrad should return $result or $result2 or $result3")
	public void shouldCyfrokrad(Integer result,Integer result2,Integer result3){
    	int actual = gra.cyfrokrad().intValue();
		assertThat("", result == actual || result2 == actual || result3 == actual);
	}
    
    @Then("nieksztaltek should return $result")
  	public void shouldNieksztaltek(Integer result){
  		assertEquals(result, gra.nieksztaltek());
  	}
    
    @Then("hultajchochla should return $result")
  	public void shouldHultajchochla(Integer result) throws NieudanyPsikusException{
  		assertEquals(result, gra.hultajchochla());
  	}
}
