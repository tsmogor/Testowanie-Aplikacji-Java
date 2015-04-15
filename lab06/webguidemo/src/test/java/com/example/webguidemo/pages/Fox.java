package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Fox extends WebDriverPage {

	public Fox(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://www.teleman.pl/program-tv/stacje/FOX");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}
