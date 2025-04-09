package com.airtech.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.airtech.qa.base.BasePage;

public class MyWishListPage extends BasePage{

	public MyWishListPage(WebDriver driver) {
		super(driver);
    }
	
	By wishlisttxt=By.xpath("//span[@class='base']");
	By paginationoptions=By.xpath("(//select[@id='limiter'])[1]");
	By wishlistoption=By.xpath("//strong[normalize-space()='My Wish List']");
	By allimages=By.xpath("//img[@class='product-image-photo']");
	By updatewish=By.xpath("//span[normalize-space()='Update Wish List']");
	By sharewish=By.xpath("//span[normalize-space()='Share Wish List']");
	By addallcart=By.xpath("//span[normalize-space()='Add All to Cart']");
	By prodcomment=By.xpath("//textarea[@id='product-item-comment-49']");
	By addtocartbtn=By.xpath("//li[@id='item_49']//span[contains(text(),'Add to Cart')]");
	By editbtn=By.xpath("//li[@id='item_49']//span[contains(text(),'Edit')]");
	By removebtn=By.xpath("//li[@id='item_49']//span[contains(text(),'Remove item')]");
	By prodname=By.xpath("//a[@title='AIRSEAL-2-TACKY-3MM-12MM-15M 20-ROLLS-PER-CASE'][normalize-space()='AIRSEAL-2-TACKY-3MM-12MM-15M 20-ROLLS-PER-CASE']");
	By allprices=By.xpath("//span[@class='price']");
	By allquantity=By.xpath("//input[contains(@id,'qty')]");
	By allproduct=By.xpath("//li[@data-row='product-item']");
	By uniqueitemidentify=By.xpath("//li[@class='item product']");	
	By wishlistlink=By.xpath("//div[@id='block-collapsible-nav']//a[normalize-space()='My Wish List']");
	
	
	
	
	public void ClickWishlistLink() {
		driver.findElement(wishlistlink).click();
	}
	
	
	public WebElement IswishlistDisplayed() {
		return driver.findElement(wishlisttxt);
	}
	
	public WebElement IsquantityDisplayed() {
		return driver.findElement(allquantity);
	}
	
	public void Changewishno(String no) {
		WebElement dropdownElement = driver.findElement(paginationoptions);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(no);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	public WebElement IsImagesDisplayed() {
		return driver.findElement(allimages);
	}
	
	public ProductDetailPage ClickEditbtn() {
		driver.findElement(editbtn).click();
		return new ProductDetailPage(driver) ;
	}
	
	public void Clickremovebtn() {
		driver.findElement(removebtn).click();
	}
	
	public void entercomment(String comment) {
		driver.findElement(prodcomment).sendKeys(comment);
	}
	
	public void clickaddtocartbtn() {
		driver.findElement(addtocartbtn).click();
	}
	
	public WebElement clickaddallcartbtn() {
		driver.findElement(addallcart).click();
		return driver.findElement(allproduct);
	}
	
	public void clicksharewish() {
		driver.findElement(sharewish).click();
	}
	
	public ProductDetailPage clickprodname() {
		driver.findElement(prodname).click();
		return new ProductDetailPage(driver) ;
	}
	
	public WebElement IsPricesDisplayed() {
		return driver.findElement(allprices);
	}
	
}
