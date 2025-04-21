package com.airtech.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.airtech.qa.base.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	By createaccount=By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]");
	By personalinfotxt=By.xpath("//span[normalize-space()='Personal Information']");
	By firstname=By.xpath("//input[@id='firstname']");
	By lastname=By.xpath("//input[@id='lastname']");
	By additionalinfotxt=By.xpath("//span[normalize-space()='Additional Information']");
	By industrytype=By.xpath("//select[@id='industry_typec']");
	By newslettercheck=By.xpath("//input[@id='is_subscribed']");
	By signininfotxt=By.xpath("//span[normalize-space()='Sign-in Information']");
	By email=By.xpath("//input[@id='email_address']");
	By password=By.xpath("//input[@id='password']");
	By cnfpassword=By.xpath("//input[@id='password-confirmation']");
	By passwordtoggle=By.xpath("//input[@id='show-password']");
	By createbtn=By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]");
	By passstrengthtext=By.xpath("//div[@id='password-strength-meter']");
	By userbtn=By.xpath("//i[@class='fas fa-user']");
	By registerbtn=By.xpath("//span[normalize-space()='Register']");
	By reqfields=By.xpath("//input[@aria-required='true'] | //textarea[@aria-required='true'] | //select[@aria-required='true']");
	By errormsg=By.xpath("//div[@class='mage-error']");
	
	
	public void ClickRegister() {
		driver.findElement(userbtn).click();
		driver.findElement(registerbtn).click();
	}
	
	public WebElement Ispersonaltxtdisplayed() {
		return driver.findElement(createaccount);
	}
	
	public WebElement enterfirstname() {
		return driver.findElement(firstname);
	}
	
	public WebElement enterlastname() {
		return driver.findElement(lastname);
	}
	
	public WebElement Isadditionalinfodisplayed() {
		return driver.findElement(additionalinfotxt);
	}
	
	public WebElement selectIndustry() {
		return driver.findElement(industrytype);
	}
	
	public WebElement Newsletter() {
		return driver.findElement(newslettercheck);
	}
	
	public WebElement IsSignInfoDisplayed() {
		return driver.findElement(signininfotxt);
	}
	
	public WebElement enteremail() {
		return driver.findElement(email);
	}
	
	public void enterpassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void enterconfirmpassword(String cnfpass) {
		driver.findElement(cnfpassword).sendKeys(cnfpass);
	}
	
	public void Togglepassword() {
		driver.findElement(passwordtoggle).click();
	}
	
	public void ClickCreatebtn() {
		driver.findElement(createaccount).click();
	}
	
	public String getPasswordStrength() {
		WebElement Passwordstrength = driver.findElement(passstrengthtext);
        return Passwordstrength.getText().trim();
	}
	
	public List<WebElement> required(){
		return driver.findElements(reqfields);
	}
	
	public List<WebElement> errors(){
		return driver.findElements(errormsg);
	}
	
	public void clear() {
		driver.findElement(password).clear();
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getcnfPassword() {
		return driver.findElement(cnfpassword);
	}
}
