package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
	}
	
	By contactbtn=By.xpath("//div[@class='menu-contact']//a[@class='level-top']");
	By contacttext=By.xpath("//span[@class='base']");
	By name=By.xpath("//input[@id='name']");
	By email=By.xpath("//form[@id='contact-form']//input[@id='email']");
	By phoneno=By.xpath("//input[@id='telephone']");
	By message=By.xpath("//textarea[@id='comment']");
	By submitbtn=By.xpath("//span[normalize-space()='Submit']");
	By addresses=By.xpath("//div[@class='contact-wrap']//div[1]//address[1]");
	By nameerror=By.xpath("//div[@id='name-error']");
	By emailerror=By.xpath("//div[@id='email-error']");
	By messageerror=By.xpath("//div[@id='comment-error']");
	
	
	public void ClickContact() {
		driver.findElement(contactbtn).click();
	}
	
	public WebElement IsContactDisplayed() {
		return driver.findElement(contacttext);
	}
	
	public void entername(String nm) {
		driver.findElement(name).sendKeys(nm);
	}
	
	public void enteremail(String em) {
		driver.findElement(email).sendKeys(em);
	}
	
	public void enterphoneno(String phno) {
		driver.findElement(phoneno).sendKeys(phno);
	}
	
	public void entermsg(String msg) {
		driver.findElement(message).sendKeys(msg);
	}
	
	public void entersubmit() {
		driver.findElement(submitbtn).click();
	}
	
	public WebElement IsadressesDisplayed() {
		return driver.findElement(addresses);
	}
	
	public WebElement NameValidationDisplayed() {
		return driver.findElement(nameerror);
	}
	
	public WebElement EmailValidationDisplayed() {
		return driver.findElement(emailerror);
	}
	
	public WebElement CommentValidationDisplayed() {
		return driver.findElement(messageerror);
	}
	
	
}
