package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class NewsLetter extends BasePage {

	public NewsLetter(WebDriver driver) {
		super(driver);
    }
	
	
	By newsletterlink=By.xpath("//div[@id='block-collapsible-nav']//a[normalize-space()='Newsletter Subscriptions']");
	By newslettertext=By.xpath("//span[@class='base' and contains(text(),'Newsletter')]");
	By newslettercheck=By.xpath("//input[@id='subscription']");
	By savebtn=By.xpath("//button[@title='Save']");
	By successmsg=By.xpath("//div[@class='message-success success message']");
	By generaltext=By.xpath("//span[normalize-space()='General Subscription']");
	By subscriptiontext=By.xpath("//span[normalize-space()='Subscription option']");
	
	
	public void newsletterclick() {
		driver.findElement(newsletterlink).click();
	}
	
	public WebElement IsNewsLetterDisplayed() {
		return driver.findElement(newslettercheck);
	}
	
	public void ClickNewsletterCheck() {
		driver.findElement(newslettercheck).click();
	}
	
	public void ClickSave() {
		driver.findElement(savebtn).click();
	}
	
	public WebElement Successmsg() {
		return driver.findElement(successmsg);
	}
	
	public WebElement IsgeneralDisplayed() {
		return driver.findElement(generaltext);
	}
	
	public WebElement IsSubscriptiontextDisplayed() {
		return driver.findElement(subscriptiontext);
	}
	
	
}
