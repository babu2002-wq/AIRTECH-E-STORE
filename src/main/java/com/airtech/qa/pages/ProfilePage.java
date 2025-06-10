package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	By options=By.xpath("//div[@class='block block-collapsible-nav']//ul[@class='nav items']/li");
	By accountinfotext=By.xpath("//strong[normalize-space()='Account Information']");
	By contactinfotext=By.xpath("//span[normalize-space()='Contact Information']");
	By newslettertext=By.xpath("//span[normalize-space()='Newsletters']");
	By addressbook=By.xpath("//strong[normalize-space()='Address Book']");
	By defaultbilladd=By.xpath("//span[normalize-space()='Default Billing Address']");
	By defaultshipadd=By.xpath("//span[normalize-space()='Default Shipping Address']");
	By editcontact=By.xpath("//div[@class='box box-information']//span[contains(text(),'Edit')]");
	By changepass=By.xpath("//a[normalize-space()='Change Password']");
	By newsletteredit=By.xpath("//div[@class='box box-newsletter']//a[@class='action edit']");
	By recentordertxt=By.xpath("//strong[normalize-space()='Recent Orders']");
	By vieworderlink=By.xpath("(//span[contains(text(),'View Order')])[1]");
	By reorderlink=By.xpath("(//span[contains(text(),'Reorder')])[1]");
	By allorderlink=By.xpath("//div[@class='block-title order']//span[contains(text(),'View All')]");
	By myoderstxt=By.xpath("//span[contains(text(),'My Orders')]");
	By editaccountinfo=By.xpath("//span[contains(text(),'Edit Account')]");
	By changepasstext=By.xpath("//legend/span[contains(text(),'Change Password')]");
	By newslettertxt=By.xpath("//span[text()='Newsletter Subscription']");
	By manageaddress=By.xpath("//span[normalize-space()='Manage Addresses']");
	By addressbooktext=By.xpath("//span[@class='base' and text()='Address Book']");
	By myaccountlink=By.xpath("//li[@class='nav item current']//strong[contains(text(),'My Account')]");
	
	
	
	public void ClickMyAccount() {
		driver.findElement(myaccountlink).click();
	}
	
	public WebElement IsOptionsDisplayed() {
		return driver.findElement(options);
	}
	
	public WebElement IsaccountInfoDisplayed() {
		return driver.findElement(accountinfotext);
	}
	
	public WebElement IscontactInfoDisplayed() {
		return driver.findElement(contactinfotext);
	}
	
	public WebElement IsnewsletterDisplayed() {
		return driver.findElement(newslettertext);
	}
	
	public WebElement IsAddressbookDisplayed() {
		return driver.findElement(addressbook);
	}
	
	public WebElement IsDefaultBillDisplayed() {
		return driver.findElement(defaultbilladd);
	}
	
	public WebElement IsDefaultShipDisplayed() {
		return driver.findElement(defaultshipadd);
	}
	
	public WebElement IsRecentDisplayed() {
		return driver.findElement(recentordertxt);
	}
	
	public WebElement ClickEditContact() {
		driver.findElement(editcontact).click();
		return driver.findElement(editaccountinfo);
	}
	
	public WebElement ClickChangePass() {
		driver.findElement(changepass).click();
		return driver.findElement(changepasstext);
	}
	
	public WebElement ClickNewsLetter() {
		driver.findElement(newsletteredit).click();
		return driver.findElement(newslettertxt);
	}
	
	public WebElement ClickViewOrders() {
		driver.findElement(vieworderlink).click();
		return driver.findElement(myoderstxt);
	}
	
	public CartPage ClickReOrders() {
		driver.findElement(reorderlink).click();
		return new CartPage(driver);
	}
	
	public WebElement ClickAllOrders() {
		driver.findElement(allorderlink).click();
		return driver.findElement(myoderstxt);
	}
	
	public WebElement ClickManageAddress() {
		driver.findElement(manageaddress).click();
		return driver.findElement(addressbooktext);
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	
}	
