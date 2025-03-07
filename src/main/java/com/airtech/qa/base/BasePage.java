package com.airtech.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	public WebDriver driver;
	public Actions actions;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.actions = new Actions(driver);
	}

}
