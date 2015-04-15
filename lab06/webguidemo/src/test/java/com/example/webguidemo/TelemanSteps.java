package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.*;

public class TelemanSteps {
	
	private final Pages pages;

	
	
	public TelemanSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user opens Sport link")
    public void userClicksOnSportLink(){        
        pages.home().findElement(By.linkText("SPORT")).click();
    }
 
    @Then("Sport page is shown")
    public void sportPageIsShown(){
       assertEquals("Sport w Programie TV - Program telewizyjny Teleman.pl", pages.sport().getTitle());
    }	
    
    @When("user opens list channels and choose Fox channel")
    public void userClicksOnListChannels(){        
        pages.home().findElement(By.xpath(".//*[@id='main-menu-stations']")).click();
        pages.home().findElement(By.xpath(".//*[@id='stations-index']/ul/li[3]/a[7]")).click();
    }
    
    @Then("Fox page is shown")
    public void foxPageIsShown(){
       assertEquals("FOX - Aktualny Program TV", pages.fox().getTitle());
    }

    @When("user opens saturday's program list")
    public void userClicksOnSaturdayTVProgram(){        
        pages.fox().findElement(By.xpath(".//*[@id='date-navigation']/a[@href='/program-tv/stacje/FOX?date=2015-04-18']")).click();
    }
    
    @Then("showing a program on Saturday")
    public void SaturdayTVProgramisShown(){
      	assertEquals("FOX - Program TV na Sobota 18 kwietnia 2015",pages.fox().getTitle());
    }
    
    @When("user search saturday's program at 8:05 pm")
    public String findProgramAt8PM(){        
        String ff=  pages.fox().findElement(By.xpath(".//*[@id='prog9957642']/em")).getText();
        return ff;
    }
    
    @Then("program at 8:05 pm is shown")
    public void SaturdayTVProgramisShown2(){
      	assertEquals("20:05",findProgramAt8PM());
    }
    
    @When("user searches $result")
    public void userSearch(String result){        
        WebElement inputField = pages.home().findElement(By.xpath(".//*[@id='search-form']/input[1]"));
        inputField.sendKeys(result);
        pages.home().findElement(By.xpath(".//*[@id='search-form']/input[2]")).click();
        
    }
    
    @Then("showing the search program")
    public void showingTheSearchProgram(){
    	String djangoTitle = pages.django().findElement(By.xpath(".//*[@id='content']/h1")).getText();
      	assertEquals("Wyniki wyszukiwania dla \"Django\"",djangoTitle);
    }
    
    
    
}
