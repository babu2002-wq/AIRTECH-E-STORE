package com.airtech.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	By cartbtn=By.xpath("//a[@class='action showcart']");
	By viewcartbtn=By.xpath("//span[normalize-space()='View Cart']");
	By carttext=By.xpath("//span[@class='base']");
	By table=By.xpath("//div[@class='cart table-wrapper']");
	By editbtn=By.xpath("//a[@title='Edit item parameters']");
	By removebtn=By.xpath("//a[@class='action action-delete']");
	By updatebtn=By.xpath("//button[@title='Update Shopping Cart']");
	By discounttext=By.xpath("//strong[@id='block-discount-heading']");
	By discountfield=By.xpath("//input[@id='coupon_code']");
	By discountbtn=By.xpath("//span[normalize-space()='Apply Discount']");
	By increasequantity=By.xpath("//i[@class='porto-icon-up-dir']");
	By decreasequantity=By.xpath("//i[@class='porto-icon-down-dir']");
	By quantity=By.xpath("//input[@id='cart-987-qty']");
	By unitprice=By.xpath("//td[@class='col price']//span[@class='cart-price']");
	By subtotal=By.xpath("//td[@class='col subtotal']//span[@class='cart-price']");
	By cartsummary=By.xpath("//div[@class='cart-summary']");
	By carttoggle=By.xpath("//div[@aria-controls='block-summary']");
	By country=By.xpath("//div[@name='shippingAddress.country_id']//div[@class='control']");
	By state=By.xpath("//div[@name='shippingAddress.region_id']//div[@class='control']");
	By postalcode=By.xpath("//div[@name='shippingAddress.postcode']//div[@class='control']");
	By city=By.xpath("//div[@name='shippingAddress.city']//div[@class='control']");
	By totalorder=By.xpath("//td[@data-bind=\"attr: {'data-th': title}\"]");
	By checkoutbtn=By.xpath("//button[@title='Proceed to Checkout']");
	By uniqueitemidentify=By.xpath("//li[@class='item product']");
	By itemtext=By.xpath("//td[@class='col item']//strong[@class='product-item-name']//a");
	By allcartproducts=By.xpath("//tbody[@class='cart item']");
	
	public void Clickcartbtn() {
		driver.findElement(cartbtn).click();
		driver.findElement(viewcartbtn).click();
	}
	
	public WebElement IsCartTextDisplayed() {
		return driver.findElement(carttext);
	}
	
	public WebElement IsTableDisplayed() {
		return driver.findElement(table);
	}
	
	public void Clickeditbtn(int index) {
		List<WebElement> editbtns=driver.findElements(editbtn);
		WebElement editbtn=editbtns.get(index);
		editbtn.click();
	}
	
	public WebElement uniqueElement() {
		return driver.findElement(uniqueitemidentify);
	}
	
	public void clickremovebtn(int index) {
		List<WebElement> deletebtn=driver.findElements(removebtn);
		WebElement removebtn=deletebtn.get(index);
		removebtn.click();
	}
	
	public void clickupdatebtn() {
		driver.findElement(updatebtn).click();
	}
	
	public WebElement IsDiscountDisplayed() {
		return driver.findElement(discounttext);	
	}
	
	public void enterdiscountcode(String discountcode) {
		driver.findElement(discountfield).sendKeys(discountcode);
	}
	
	public void Clickdiscountbtn() {
		driver.findElement(discountfield).click();
	}
	
	public void Clickincreasequantity(int index) {
		List<WebElement> Increasebtns=driver.findElements(increasequantity);
		WebElement Increasebtn=Increasebtns.get(index);
		Increasebtn.click();
	}
	
	public void Clickdecreasequantity() {
		driver.findElement(decreasequantity);
	}
	
	public String getProductName() {
		return driver.findElement(itemtext).getText();
	}
	
	public List<WebElement> getProducts() {
		 List<WebElement> products=driver.findElements(allcartproducts);
		 return products;
	}
	
	
	 
}
