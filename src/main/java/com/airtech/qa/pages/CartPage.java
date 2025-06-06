package com.airtech.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	By updatebtn=By.xpath("//button[@title='Update Cart']");
	By discounttext=By.xpath("//strong[@id='block-discount-heading']");
	By discountfield=By.xpath("//input[@id='coupon_code']");
	By discountbtn=By.xpath("//span[normalize-space()='Apply Discount']");
	By increasequantity=By.xpath("//i[@class='porto-icon-up-dir']");
	By decreasequantity=By.xpath("//i[@class='porto-icon-down-dir']");
	By quantity=By.xpath("//input[@class='input-text qty']");
	By unitprice=By.xpath("//td[@class='col price']//span[@class='cart-price']");
	By subtotal=By.xpath("//td[@class='col subtotal']//span[@class='cart-price']");
	By cartsummary=By.xpath("//div[@class='cart-summary']");
	By carttoggle=By.xpath("//div[@aria-controls='block-summary']");
	By country=By.xpath("//div[@name='shippingAddress.country_id']//div[@class='control']");
	By state=By.xpath("//div[@name='shippingAddress.region_id']//div[@class='control']");
	By postalcode=By.xpath("//div[@name='shippingAddress.postcode']//div[@class='control']");
	By city=By.xpath("//div[@name='shippingAddress.city']//div[@class='control']");
	By totalorder=By.xpath("//td[@data-th='Order Total']");
	By checkoutbtn=By.xpath("//button[@data-role='proceed-to-checkout']");
	By uniqueitemidentify=By.xpath("//li[@class='item product']");
	By itemtext=By.xpath("//td[@class='col item']//strong[@class='product-item-name']//a");
	By allcartproducts=By.xpath("//tbody[@class='cart item']");
	By tax=By.xpath("//td[@data-th='Tax']");
	By subtot=By.xpath("//tr[@class='totals sub']//td[@class='amount']");
	By editproduct=By.xpath("(//a[@title='Edit item'])[1]");
	By updatecart=By.xpath("//span[normalize-space()='Update Cart']");
	
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
	
	public ProductDetailPage Clickeditbtn() {
		WebElement row = getProduct();
	    WebElement editButton = row.findElement(editbtn);
	    editButton.click(); 
	    return new ProductDetailPage(driver);
	}
	
	public WebElement uniqueElement() {
		return driver.findElement(uniqueitemidentify);
	}
	
	public void clickremovebtn() {
		 WebElement row = getProduct();
	     WebElement removeButton = row.findElement(removebtn);
	     removeButton.click();      
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
	
	public void ClickIncreaseQuantity(int times) {
	    WebElement row = getProduct();
	    WebElement increaseBtn = row.findElement(increasequantity);
	    for (int i = 0; i < times; i++) {
	    	increaseBtn.click();
	    }  
	}
	
	public void Clickdecreasequantity(int times) {
		WebElement row = getProduct();
        WebElement decreaseBtn = row.findElement(decreasequantity);
        for (int i = 0; i < times; i++) {
        	decreaseBtn.click();
        }
        
	}
	
	public String getProductName() {
		return driver.findElement(itemtext).getText();
	}
	
	public WebElement getProduct() {
		 List<WebElement> products=driver.findElements(allcartproducts);
		 return products.get(0);
	}
	
	public WebElement getSubtotal() {
        WebElement row = getProduct();
        WebElement subtot = row.findElement(subtotal);
        return subtot;
    }
	
	public WebElement getUnittotal() {
        WebElement row = getProduct();
        WebElement unittot = row.findElement(unitprice);
        return unittot;
	}
	
	public List<WebElement> getallProducts(){
		List<WebElement> products=driver.findElements(allcartproducts);
		return products;
	}
	
	public WebElement getquantity() {
		WebElement row = getProduct();
        WebElement quan = row.findElement(quantity);
        return quan;
	}
	
	public void navigateback() {
		driver.navigate().back();
	}
	
	public WebElement IsSubtotalDisplayed() {
		return driver.findElement(subtot);
	}
	
	public WebElement IsTaxDisplayed() {
		return driver.findElement(tax);
	}
	
	public WebElement IsTotalDisplayed() {
		return driver.findElement(totalorder);
	}
	
	public CheckOutPage ClickCheckout() {
		driver.findElement(checkoutbtn).click();
		return new CheckOutPage(driver);
	}
	
	public int UpdateCart() {
	    ProductPage product=new ProductPage(driver);
	    ProductDetailPage detail=new ProductDetailPage(driver);
	    driver.findElement(product.opencartbtn).click();
	    driver.findElement(editbtn).click();
	    detail.Clickincrementbtn(3);
	    int quant=detail.getquantity();
	    return quant;
	    
	}
	
	public int getnewquantity() {
		driver.findElement(updatecart).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement newquantity = wait.until(ExpectedConditions.presenceOfElementLocated(quantity));
	    int newquant=Integer.parseInt(getquantity().getAttribute("value").trim());
	    return newquant;  
	}
	
	
}
