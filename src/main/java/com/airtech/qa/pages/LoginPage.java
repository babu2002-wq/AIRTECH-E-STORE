package com.airtech.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	By userbtn=By.xpath("//i[@class='fas fa-user']");
	By logintext=By.xpath("//h3[normalize-space()='User Login']");
	By loginclose=By.xpath("//div[@class='icon-close']//i[@class='porto-icon-cancel']");
	By email=By.xpath("//input[@id='email']");
	By password=By.xpath("//input[@id='passwordtoggle']");
	By signinbtn=By.xpath("//button[@id='sendlogin']");
	By registerbtn=By.xpath("//span[normalize-space()='Register']");
	By forgotpasswordbtn=By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]");
	By togglebtn=By.xpath("//i[@class='porto-icon-eye toggle-password']");
	By reqfields=By.xpath("//input[@aria-required='true'] | //textarea[@aria-required='true'] | //select[@aria-required='true']");
	By errormsg=By.xpath("//div[@class='mage-error']");
	
	public void Clickuserbtn() {
		driver.findElement(userbtn).click();
	}
	
	public WebElement IsLoginTextDisplayed() {
		return driver.findElement(logintext);
	}
	
	public void LoginClose() {
		driver.findElement(loginclose).click();
	}
	
	public void enteremail(String Email) {
		driver.findElement(email).sendKeys(Email);
	}
	
	public void enterpassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void signIn() {
		driver.findElement(signinbtn).click();
	}
	
	public RegistrationPage register() {
		driver.findElement(registerbtn).click();
		return new RegistrationPage(driver);
	}
	
	public void Clicktoggle() {
		driver.findElement(togglebtn).click();
	}
	
	public ForgotPasswordPage Clickforgetpassword() {
		driver.findElement(forgotpasswordbtn).click();
		return new ForgotPasswordPage(driver);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public void clear() {
		driver.findElement(password).clear();
	}
	
	public List<WebElement> requiredfields(){
		List<WebElement> fields=driver.findElements(reqfields);
		return fields;
	}
	
	public List<WebElement> errormsgs(){
		List<WebElement> errors=driver.findElements(errormsg);
		return errors;
	}
	
	public void SignInClick() {
		driver.findElement(signinbtn).click();
	}

}
