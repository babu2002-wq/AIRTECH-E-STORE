package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.airtech.qa.base.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	By createaccount=By.xpath("//span[@class='base']");
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
	
	public WebElement Ispersonaltxtdisplayed() {
		return driver.findElement(createaccount);
	}
	
	public void enterfirstname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}
	
	public void enterlastname(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}
	
	public WebElement Isadditionalinfodisplayed() {
		return driver.findElement(additionalinfotxt);
	}
	
	public void selectIndustry(String IndustryType) {
		WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(IndustryType);
	}
	
	public void Clicknewsletter() {
		driver.findElement(newslettercheck).click();
	}
	
	public WebElement IsSignInfoDisplayed() {
		return driver.findElement(signininfotxt);
	}
	
	public void enteremail(String em) {
		driver.findElement(email).sendKeys(em);
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
}
