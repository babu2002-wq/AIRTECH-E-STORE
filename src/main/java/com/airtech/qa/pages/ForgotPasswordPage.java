package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	By userbtn=By.xpath("//i[@class='fas fa-user']");
	By forgotpasswordbtn=By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]");
	By forgotpasswordtext=By.xpath("//span[@class='base']");
	By email=By.xpath("//input[@id='email_address']");
	By resetbtn=By.xpath("//span[normalize-space()='Reset My Password']");
	By passwordresettext=By.xpath("//div[@class='field note']");
	By allproductlink=By.xpath("//a[@title='Infusion & Low Temp Curing']");
	
	public void Clickuserbtn() {
		driver.findElement(userbtn).click();
	}
	
	public void Clickforgotbtn() {
		driver.findElement(forgotpasswordbtn).click();
	}
	
	public WebElement IsForgotDisplayed() {
		return driver.findElement(forgotpasswordtext);
	}
	
	public void enteremail(String em) {
		driver.findElement(email).sendKeys(em);
	}
	
	public void Clickresetbtn() {
		driver.findElement(resetbtn).click();
	}
	
	public WebElement IsResetDisplayed() {
		return driver.findElement(passwordresettext);
	}
	
	public void Clickproductlink() {
		driver.findElement(allproductlink).click();
	}
	
	
}
