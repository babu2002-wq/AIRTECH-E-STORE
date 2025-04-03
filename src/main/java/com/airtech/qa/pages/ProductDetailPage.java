package com.airtech.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class ProductDetailPage extends BasePage{

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	By detail=By.xpath("//span[normalize-space()='Details']");
	By moreinfo=By.xpath("//span[normalize-space()='More Information']");
	By reviews=By.xpath("//span[normalize-space()='Reviews']");
	By price=By.xpath("//span[@class='price']");
	By productname=By.xpath("//span[@class='base']");
	By nextproduct=By.xpath("//em[@class='porto-icon-right-open']");
	By prevproduct=By.xpath("//em[@class='porto-icon-left-open']");
	By reviewgiven=By.xpath("//div[@class='reviews-actions']");
	By productdesc=By.xpath("//div[@itemprop='description']");
	By stocksku=By.xpath("//div[@class='product-info-stock-sku']");
	By skuno=By.xpath("//div[@class='product attribute sku']");
	By productincrementtext=By.xpath("//div[@class='product pricing']");
	By quantityincrement=By.xpath("//a[@class='qty-incr']");
	By quantitydecrement=By.xpath("//a[@class='qty-decr']");
	By quantity=By.xpath("//input[@id='qty']");
	By addtowishlistbtn=By.xpath("//span[normalize-space()='Add to Wish List']");
	By addtocomparebtn=By.xpath("//span[normalize-space()='Add to Compare']");
	By addtocartbtn=By.xpath("//span[normalize-space()='Add to Cart']");
	By completedesc=By.xpath("//div[@class='product attribute description']");
	By cartsuccessbox=By.xpath("//div[@class='message-success success message']");
	By cartsuccessbtn=By.xpath("//a[normalize-space()='shopping cart']");
	By cartsuccesstext=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	By comparesuccessbox=By.xpath("//div[@class='message-success success message']");
	By comparesuccesstext=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	By comparesuccessbtn=By.xpath("//a[normalize-space()='comparison list']");
	By wishlistfailtext=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	By availability=By.xpath("//div[@title='Availability']");
	By wishlistsuccesstext=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	By wishlistsuccessbtn=By.xpath("//a[normalize-space()='here']");
	By uniqueitemidentify=By.xpath("//li[@class='item product']");	
	By userbtn=By.xpath("//i[@class='fas fa-user']");
	
	
	public WebElement Isdetaildisplayed() {
		return driver.findElement(detail);
	}
	
	public WebElement Ismoreinfodisplayed() {
		return driver.findElement(moreinfo);
	}
	
	public WebElement Isreviewsdisplayed() {
		return driver.findElement(reviews);
	}
	
	public WebElement IsPricedisplayed() {
		return driver.findElement(price);
	}
	
	public WebElement IsProductNamedisplayed() {
		return driver.findElement(productname);
	}
	
	public void ClickNextbtn() {
		driver.findElement(nextproduct).click();
	}
	
	public void ClickPrevbtn() {
		driver.findElement(prevproduct).click();
	}
	
	public WebElement IsReviewGivenDisplayed() {
		return driver.findElement(reviews);
	}
	
	public WebElement IsDescDisplayed() {
		return driver.findElement(productdesc);
	}
	
	public WebElement IsStockSkuDisplayed() {
		return driver.findElement(stocksku);
	}
	
	public WebElement SkunoDisplayed() {
		return driver.findElement(skuno);
	}
	
	public String StockDisplayed() {
		WebElement Availability=driver.findElement(availability);
		String available=Availability.getText();
		String stocktext = available.split(":")[1].trim();
		return stocktext;
	}
	
	public WebElement IsIncrementDisplayed() {
		return driver.findElement(productincrementtext);
	}
	
	public int getquantity() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement quantityInput = driver.findElement(quantity);
		int quantity = Integer.parseInt((String) js.executeScript("return arguments[0].value;", quantityInput));
		return quantity;
	}
	
	public WebElement getQuantityElement() {
		WebElement quantityInput = driver.findElement(quantity);
		return quantityInput;
	}
	
	public void Clickincrementbtn(int times) {
		for(int i=0;i<times;i++) {
			driver.findElement(quantityincrement).click();
		}
	}
	
	public void Clickdecrementbtn(int times) {
		for(int i=0;i<times;i++) {
			driver.findElement(quantitydecrement).click();
		}
	}
	
	public CartPage AddtoCartbtn() {
		driver.findElement(addtocartbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement successmsg=driver.findElement(cartsuccessbox);
		driver.findElement(cartsuccessbtn).click();
		return new CartPage(driver);
	}
	
	public ComparePage AddtoComparebtn() {
		driver.findElement(addtocomparebtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement successmsg=driver.findElement(comparesuccessbox);
		driver.findElement(comparesuccessbtn).click();
		return new ComparePage(driver);
	}
	
	
	public MyWishListPage ClickWishlistsuccessbtn() {
		driver.findElement(wishlistsuccessbtn).click();
		return new MyWishListPage(driver);
	}
	
	public String AddtoWishlistfail() {
		driver.findElement(addtowishlistbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement successmsg=driver.findElement(wishlistfailtext);
		String msgtext=successmsg.getText();
		return msgtext;
	}
	
	public WebElement AddtoWishlistSuccess() {
		driver.findElement(addtowishlistbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement successmsg=driver.findElement(wishlistsuccesstext);
		return successmsg;
	}
	
	public WebElement ClickWishlistbtn() {
		driver.findElement(wishlistsuccessbtn).click();
		return driver.findElement(uniqueitemidentify);
	}
	
	public String ProductName() {
		String product=driver.findElement(uniqueitemidentify).getText();
		return product;
	}
	
	public void navigateback() {
		driver.navigate().back();
	}
	
	public String getUserIconColor() {
        WebElement icon = driver.findElement(userbtn);
        return icon.getCssValue("color"); 
    }
	
	public boolean isUserLoggedIn() {
	   String expectedColor = "rgba(98, 255, 132, 1)"; 
	   return getUserIconColor().equals(expectedColor);
    }
	
}
