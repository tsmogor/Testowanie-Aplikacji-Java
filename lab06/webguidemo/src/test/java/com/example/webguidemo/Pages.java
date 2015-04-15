package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.Django;
import com.example.webguidemo.pages.Fox;
import com.example.webguidemo.pages.Sport;
import com.example.webguidemo.pages.Home;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Sport sport;
	private Fox fox;
	private Django django;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	
	public Sport sport(){
		if (sport == null) {
			sport = new Sport(driverProvider);
		}
		return sport;
	}
	
	public Fox fox(){
		if (fox == null) {
			fox = new Fox(driverProvider);
		}
		return fox;
	}
	
	public Django django(){
		if (django == null) {
			django = new Django(driverProvider);
		}
		return django;
	}
}
