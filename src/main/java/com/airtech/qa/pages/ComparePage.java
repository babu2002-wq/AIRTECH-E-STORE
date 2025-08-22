package com.airtech.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class ComparePage extends BasePage {

	public ComparePage(WebDriver driver) {
		super(driver);
    }
	
	By comparetext=By.xpath("//span[@class='base']");
	By printbtn=By.xpath("//a[@title='Print This Page']");
	By addtocartbtn=By.xpath("//span[normalize-space()='Add to Cart']");
	By removebtn=By.xpath("//a[@title='Remove Product']");
	By addtowishlistbtn=By.xpath("//a[@class='action towishlist']");
	By allprices=By.xpath("//span[@class='price-container price-final_price tax weee']");
	By allproducts=By.xpath("//strong[@class=\"product-item-name\"]//a");
	By comparetable=By.xpath("//div[@class='attribute value']//div[@data-content-type='html']");
	By printcancel=By.xpath("//cr-button[@class='cancel-button']");
	By productbtn=By.xpath("/html[1]/body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/strong[1]/a[1]");
	By successmsg=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	By successbtn=By.xpath("//a[normalize-space()='shopping cart']");
	By uniqueitemidentify=By.xpath("//li[@class='item product']");
	By wishlistfailmsg=By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
	By frame=By.tagName("iframe");
	By shadow=By.cssSelector("print-preview-app");
	By wishlistbtn=By.xpath("(//a[@class='action towishlist'])[1]");
	By wishlistsuccessbtn=By.xpath("//button[@id='wishlist_checkout']");
	By productname=By.xpath("(//strong[@class='product-item-name']//a[not(@data-bind)])[1]");
	
	
	
	public WebElement IsCompareDisplayed() {
		return driver.findElement(comparetext);
	}
	
	public void Clickcancel() {
		driver.findElement(printbtn).click();
		driver.findElement(printcancel).click();
		driver.switchTo().frame(driver.findElement(frame));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowHost = driver.findElement(shadow);
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

        // Locate the Cancel button inside the shadow DOM
        WebElement cancelBtn = (WebElement) js.executeScript(
            "return arguments[0].querySelector('print-preview-sidebar').shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('cr-button.cancel-button')", 
            shadowRoot
        );

        // Click the Cancel button
        cancelBtn.click();
	}
	
	public WebElement Clickaddtocartbtn() {
		driver.findElement(addtocartbtn).click();
		return driver.findElement(successmsg);
	}
	
	public CartPage Clickcartbtn() {
		driver.findElement(successbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return new CartPage(driver);
	}
	
	public void Clickremovebtn() {
		driver.findElement(removebtn).click();
	}
	
	public void Clickwishlistbtn() {
		driver.findElement(addtowishlistbtn).click();
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.findElement(printcancel).click();
	}
	
	public WebElement ClickProduct() {
		driver.findElement(productbtn).click();
		return driver.findElement(uniqueitemidentify);
	}
	
	public WebElement WishListFail() {
		return driver.findElement(wishlistfailmsg);
	}
	
	public void navigateback() {
		driver.navigate().back();
	}
	
	public String getProductName() {
		return driver.findElement(productname).getText();
	}
	
	public MyWishListPage clickWishlistbtn() {
		driver.findElement(wishlistbtn).click();
		driver.findElement(wishlistsuccessbtn).click();
		return new MyWishListPage(driver);
	}
	
	
}
