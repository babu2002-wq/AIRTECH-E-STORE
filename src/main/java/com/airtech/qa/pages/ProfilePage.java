package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.airtech.qa.base.BasePage;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	By options=By.xpath("//div[@class='block block-collapsible-nav']//ul[@class='nav items']/li");
	By accountinfotext=By.xpath("//strong[normalize-space()='Account Information']");
	By contactinfotext=By.xpath("//span[normalize-space()='Contact Information']");
	By newslettertext=By.xpath("//span[normalize-space()='Newsletters']");
	
}
