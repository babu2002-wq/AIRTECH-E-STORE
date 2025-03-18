package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class ComparePage extends BasePage {

	public ComparePage(WebDriver driver) {
		super(driver);
    }
	
	By comparetext=By.xpath("//span[@class='base']");
	By printbtn=By.xpath("//span[normalize-space()='Print This Page']");
	By addtocartbtn=By.xpath("//tbody/tr/td[1]/div[2]/div[1]/form[1]/button[1]/span[1]");
	By removebtn=By.xpath("//thead//td[1]//a[1]");
	By addtowishlistbtn=By.xpath("//tbody/tr/td[1]/div[2]/div[2]/a[1]");
	By allprices=By.xpath("//span[@class='price-container price-final_price tax weee']");
	By allproducts=By.xpath("//strong[@class=\"product-item-name\"]");
	By comparetable=By.xpath("//table[@id='product-comparison']");
	By printcancel=By.xpath("//cr-button[@class='cancel-button']");
	By productbtn=By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/strong[1]/a[1]");
	By successmsg=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	By successbtn=By.xpath("//a[normalize-space()='shopping cart']");
	
	public WebElement IsCompareDisplayed() {
		return driver.findElement(comparetext);
	}
	
	public void Clickcancel() {
		driver.findElement(printbtn).click();
		driver.findElement(printcancel).click();
	}
	
	public WebElement Clickaddtocartbtn() {
		driver.findElement(addtocartbtn).click();
		return driver.findElement(successmsg);
	}
	
	public CartPage Clickcartbtn() {
		driver.findElement(successbtn).click();
		return new CartPage(driver);
	}
	
	public void Clickremovebtn() {
		driver.findElement(removebtn).click();
	}
	
	public MyWishListPage Clickwishlistbtn() {
		driver.findElement(addtowishlistbtn).click();
		return new MyWishListPage(driver);
	}
	
	public WebElement IsPricesDisplayed() {
		return driver.findElement(allprices);
	}
	
	public WebElement IsProductsDisplayed() {
		return driver.findElement(allproducts);
	}
	
	public WebElement IsTableDisplayed() {
		return driver.findElement(comparetable);
	}
	
	public void printoption() {
		driver.findElement(printbtn).click();
		driver.findElement(printcancel).click();
	}
	
	public ProductDetailPage ClickProduct() {
		driver.findElement(productbtn).click();
		return new ProductDetailPage(driver);
	}
}
