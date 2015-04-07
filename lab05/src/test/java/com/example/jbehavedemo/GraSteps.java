package com.example.jbehavedemo;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import junit.framework.TestCase;

import org.junit.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class GraSteps {
	
	private GraLab02 gra;
	
	@Given("a game")
	public void calulatorSetup(){
		gra = new GraLab02();
	}
	
	@When("set arguments to $a")
	public void setArguments(Integer a){
		gra.setliczba(a);
	}
	
    @Then("cyfrokrad3 should return $result or $result2 or $result3")
	public void shouldCyfrokrad3(Integer result,Integer result2,Integer result3){
    	int actual = gra.cyfrokrad().intValue();
		assertThat(""+actual+"", result == actual || result2 == actual || result3 == actual);
	}
    
    @Then("cyfrokrad2 should return $result or $result2")
	public void shouldCyfrokrad2(Integer result,Integer result2){
    	int actual = gra.cyfrokrad().intValue();
		assertThat(""+actual+"", result == actual || result2 == actual);
	}
 
    
    @Then("nieksztaltek2 should return $result or $result2")
  	public void shouldNieksztaltek2(Integer result,Integer result2){
    	int actual = gra.nieksztaltek().intValue();
  		assertThat(""+actual+"", result == actual || result2 == actual);
  	}
    
    @Then("nieksztaltek1 should return $result")
  	public void shouldNieksztaltek(Integer result){
    	int actual = gra.nieksztaltek().intValue();
  		assertThat(""+actual+"", result == actual);
  	}
    

    
    @Then("hultajchochla5 should return $result or $result2 or $result3 or $result4 or $result5")
  	public void shouldHultajchochla3(Integer result,Integer result2,Integer result3,Integer result4,Integer result5) throws NieudanyPsikusException{
    	int actual = gra.hultajchochla().intValue();
		assertThat(""+actual+"", result == actual || result2 == actual || result3 == actual || result4 == actual || result5 == actual);
  	}
    
    @Then("hultajchochla1 should return $result")
  	public void shouldHultajchochla2(Integer result) throws NieudanyPsikusException{
    	int actual = gra.hultajchochla().intValue();
		assertThat(""+actual+"", result == actual );
  	}
}
