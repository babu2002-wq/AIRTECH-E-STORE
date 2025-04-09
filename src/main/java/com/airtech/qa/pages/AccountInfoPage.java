package com.airtech.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class AccountInfoPage extends BasePage{

	public AccountInfoPage(WebDriver driver) {
		super(driver);
	}
	
	By editinfo=By.xpath("//span[.='Edit Account Information']");
	By accountinfo=By.xpath("//span[normalize-space()='Account Information']");
	By firstname=By.xpath("//input[@id='firstname']");
	By lastname=By.xpath("//input[@id='lastname']");
	By cngemailcheck=By.xpath("//input[@id='change-email']");
	By cngpasscheck=By.xpath("//input[@id='change-password']");
	By savebtn=By.xpath("//button[@title='Save']");
	By cngemailtext=By.xpath("//span[@data-title='change-email-password']");
	By email=By.xpath("//input[@id='email']");
	By currentpass=By.xpath("//input[@id='current-password']");
	By showpass=By.xpath("//input[@id='show-password']");
	By cngpasstext=By.xpath("//span[@data-title='change-email-password']");
	By newpass=By.xpath("//input[@id='password']");
	By confirmpass=By.xpath("//input[@id='password-confirmation']");
	By accountinfolink=By.xpath("//div[@id='block-collapsible-nav']//a[normalize-space()='Account Information']");
	By reqfields=By.xpath("//input[@aria-required='true'] | //textarea[@aria-required='true'] | //select[@aria-required='true']");
	By errormsg=By.xpath("//div[@class='mage-error']");
	By passstrengthtext=By.xpath("//span[@id='password-strength-meter-label']");
	
	
	
	public void AccountInfoClick() {
	    driver.findElement(accountinfolink).click();
	}
	public WebElement IsEditInfoDisplayed() {
		return driver.findElement(editinfo);
	}
	
	public WebElement IsAccountInfoDisplayed() {
		return driver.findElement(accountinfo);
	}
	
	public WebElement IsFirstNameDisplayed() {
		return driver.findElement(firstname);
	}
	
	public WebElement IsLastNameDisplayed() {
		return driver.findElement(lastname);
	}
	
	public void CngEmailClick() {
	    driver.findElement(cngemailcheck).click();
	}
	
	public void CngPassClick() {
	    driver.findElement(cngpasscheck).click();
	}
	
	public void SavebtnClick() {
	    driver.findElement(savebtn).click();
	}
	
	public WebElement CngEmailDisplayed() {
		return driver.findElement(cngemailtext);
	}
	
	public WebElement IsEmailDisplayed() {
		return driver.findElement(email);
	}
	
	public WebElement IsCurrentPassDisplayed() {
		return driver.findElement(currentpass);
	}
	
	public void ShowpassClick() {
	    driver.findElement(showpass).click();
	}
	
	public WebElement IsCngPassTextDisplayed() {
		return driver.findElement(cngpasstext);
	}
	
	public WebElement IsNewPassDisplayed() {
		return driver.findElement(newpass);
	}
	
	public WebElement IsConfirmPassDisplayed() {
		return driver.findElement(confirmpass);
	}
	
	public void clear() {
		driver.findElement(firstname).clear();
		driver.findElement(lastname).clear();
		driver.findElement(email).clear();
	}
	
	public List<WebElement> requiredfields(){
		return driver.findElements(reqfields);
	}
	
	public List<WebElement> errors(){
		return driver.findElements(errormsg);
	}
	
	public String getPasswordStrength() {
		WebElement Passwordstrength = driver.findElement(passstrengthtext);
        return Passwordstrength.getText().trim();
	}
	
	public void EnterPass(String pass) {
		driver.findElement(newpass).sendKeys(pass);
	}
	
	public void passclear() {
		driver.findElement(newpass).clear();
	}
	
}
