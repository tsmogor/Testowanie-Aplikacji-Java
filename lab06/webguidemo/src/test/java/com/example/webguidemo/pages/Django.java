package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Django extends WebDriverPage {

	public Django(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://www.teleman.pl/search?q=Django");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}
