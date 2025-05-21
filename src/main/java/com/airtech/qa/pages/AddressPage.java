package com.airtech.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.airtech.qa.base.BasePage;

public class AddressPage extends BasePage{

	public AddressPage(WebDriver driver) {
		super(driver);
	}
	
	By addressbooktext=By.xpath("//span[@class='base' and contains(text(),'Address Book')]");
	By defaultaddtext=By.xpath("//strong[normalize-space()='Default Addresses']");
	By defaultbilladd=By.xpath("//span[normalize-space()='Default Billing Address']");
	By billaddbox=By.xpath("//div[@class='box box-address-billing']//address");
	By defaultshipadd=By.xpath("//span[normalize-space()='Default Shipping Address']");
	By addressbooklink=By.xpath("//div[@id='block-collapsible-nav']//a[normalize-space()='Address Book']");
	By changebill=By.xpath("//div[@class='box box-address-billing']//a[@class='action edit']");
	By changeship=By.xpath("//div[@class='box box-address-shipping']//a[@class='action edit']");
	By shipaddbox=By.xpath("//div[@class='box box-address-shipping']//address");
	By additionaladdtext=By.xpath("//div[@class='box box-address-shipping']//address");
	By newaddressbtn=By.xpath("//button[@title='Add New Address']");
	By addnewtext=By.xpath("//span[contains(text(), 'Add New Address')]");
	By contactinfotext=By.xpath("//span[normalize-space()='Contact Information']");
	By addresstext=By.xpath("//span[normalize-space()='Address']");
	By firstname=By.xpath("//input[@id='firstname']");
	By lastname=By.xpath("//input[@id='lastname']");
	By company=By.xpath("//input[@id='company']");
	By streetadd=By.xpath("//input[@id='street_1']");
	By country=By.xpath("//select[@id='country_id']");
	By state=By.xpath("//input[@id='region']");
	By city=By.xpath("//input[@id='city']");
	By zipcode=By.xpath("//input[@id='zip']");
	By defaultbillcheck=By.xpath("//input[@id='primary_billing']");
	By defaultshipcheck=By.xpath("//input[@id='primary_shipping']");
	By saveaddressbtn=By.xpath("//button[@title='Save Address']");
	By errormsg=By.xpath("//div[@class='mage-error'] | //div[@class='field-error']");
	By editaddtext=By.xpath("//span[.='Vacuum Bagging and Composite Tooling - Edit Address']");
	By requiredfields=By.xpath("//input[@aria-required='true'] | //select[@aria-required='true' and not(@id='country_id')]");
	
	
	public void addressbookclick() {
		driver.findElement(addressbooklink).click();
	}
	
	public WebElement IsaddressbooktextDisplayed() {
		return driver.findElement(addressbooktext);
	}
	
	public WebElement IsdefaultaddtextDisplayed() {
		return driver.findElement(defaultaddtext);
	}
	
	public WebElement IsdefbilltextDisplayed() {
		return driver.findElement(defaultaddtext);
	}
	
	public WebElement IsbilladdboxDisplayed() {
		return driver.findElement(billaddbox);
	}
	
	public WebElement IsdefshipaddDisplayed() {
		return driver.findElement(defaultbilladd);
	}
	
	public void Changebillbtnclick() {
		driver.findElement(changebill).click();
	}
	
	public String Changebillbtn() {
		return driver.getTitle();
	}
	
	public void Changeshipbtnclick() {
		driver.findElement(changeship).click();	
	}
	
	public String Changeshipbtn() {
		return driver.getTitle();
	}
	
	public WebElement IsShipaddboxDisplayed() {
		return driver.findElement(shipaddbox);
	}
	
	public WebElement IsaddionaladdDisplayed() {
		return driver.findElement(additionaladdtext);
	}
	
	public void ClicknewAddressbtn() {
		driver.findElement(newaddressbtn).click();
	}
	
	public WebElement IsNewaddtextDisplayed() {
		return driver.findElement(addnewtext);
	}
	
	public WebElement IsContactInfoDisplayed() {
		return driver.findElement(contactinfotext);
	}
	
	public WebElement IsAddresstextDisplayed() {
		return driver.findElement(addresstext);
	}
	
	public WebElement enterfn() {
		return driver.findElement(firstname);
	}
	
	public WebElement enterln() {
		return driver.findElement(lastname);
	}
	
	public WebElement entercom() {
		return driver.findElement(company);
	}
	
	public WebElement enterstreet() {
		return driver.findElement(streetadd);
	}
	
	public WebElement entercity() {
		return driver.findElement(city);
	}
	
	public WebElement enterstate() {
		return driver.findElement(state);
	}
	
	public WebElement enterzip() {
		return driver.findElement(zipcode);
	}
	
	public WebElement Clickbillcheck() {
		return driver.findElement(defaultbillcheck);
	}
	
	public WebElement Clickshipcheck() {
		return driver.findElement(defaultshipcheck);
	}
	
	public void Clicksavebtn() {
		driver.findElement(saveaddressbtn).click();
	}
	
	public List<WebElement> errormsgs(){
		return driver.findElements(errormsg);
	}
	
	public List<WebElement> reqfields(){
		return driver.findElements(requiredfields);
	}
	
	public WebElement EditPage() {
		return driver.findElement(editaddtext);
	}
	
	public void clear() {
		driver.findElement(firstname).clear();
		driver.findElement(lastname).clear();
	}
}


