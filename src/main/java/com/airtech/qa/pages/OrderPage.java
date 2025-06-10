package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.airtech.qa.base.BasePage;

public class OrderPage extends BasePage{

	public OrderPage(WebDriver driver) {
		super(driver);
    }
	
	By MyOrdersLink=By.xpath("//div[@id='block-collapsible-nav']//a[normalize-space()='My Orders']");
	By MyOrdersText=By.xpath("//span[.='My Orders']");
	By ViewOrderlink=By.xpath("(//span[normalize-space()='View'])[1]");
	By ReorderLink=By.xpath("(//span[contains(text(),'Reorder')])[1]");
	By orderhead=By.xpath("//span[@class='base' and contains(text(),'Order #')]");
	By orderdate=By.xpath("//div[@class='order-date']//span[@class='label']/following-sibling::span");
	By proreorderlink=By.xpath("//span[normalize-space()='Reorder']");
	By printorder=By.xpath("//span[normalize-space()='Print Order']");
	By ordershiptab=By.xpath("//a[normalize-space()='Order Shipments']");
	By productname=By.xpath("//strong[@class='product name product-item-name']");
	By sku=By.xpath("//td[@class='col sku']");
	By price=By.xpath("//td[@class='col price']//span[@class='price']");
	By quantity=By.xpath("//span[normalize-space()='Ordered']/following-sibling::span");
	By subtotal=By.xpath("//td[@class='col subtotal']//span[@class='price']");
	By shipping=By.xpath("//td[@data-th='Shipping & Handling']//span[@class='price']");
	By grandtotal=By.xpath("//td[@data-th='Grand Total']//span[@class='price']");
	By backtoorder=By.xpath("//span[normalize-space()='Back to My Orders']");
	By shipaddress=By.xpath("//span[normalize-space()='Shipping Address']");
	By shipmethod=By.xpath("//span[normalize-space()='Shipping Method']");
	By billaddress=By.xpath("//span[normalize-space()='Billing Address']");
	By paymentmethod=By.xpath("//span[normalize-space()='Payment Method']");
	By shipmentheading=By.xpath("//div[@class='order-title']");
	By trackallshipment=By.xpath("//span[normalize-space()='Track All Shipments']");
	By trackingid=By.xpath("//dd[@class='tracking-content']//a");
	By trackinginfohead=By.xpath("//span[@class='base' and contains(text(),'Tracking Information')]");
	By closeWindow=By.xpath("//button[@title='Close Window']");
	By shipmentSubContent=By.xpath("//div[@class='order subtitle caption' and contains(text(),'Shipment #')]");
	By trackingnumber=By.xpath("//th[@class='col label' and contains(text(),'Tracking Number')]/following-sibling::td");
	By Carrier=By.xpath("//th[@class='col label' and contains(text(),'Carrier')]/following-sibling::td");
	
	
	public void OrdersClick() {
		driver.findElement(MyOrdersLink).click();
	}
	
	public WebElement IsOrdersTextDisplayed() {
		return driver.findElement(MyOrdersText);
	}
	
	public CartPage ClickReorder() {
		driver.findElement(ReorderLink).click();
		return new CartPage(driver);
	}
	
	public void ClickViewOrder() {
		driver.findElement(ViewOrderlink).click();
	}
	
	public WebElement IsOrderheadDisplayed() {
		return driver.findElement(orderhead);
	}
	
	public WebElement IsOrderdateDisplayed() {
		return driver.findElement(orderdate);
	}
	
	public CartPage ClickProReorder() {
		driver.findElement(proreorderlink).click();
		return new CartPage(driver);
	}
	
	public WebElement ClickPrint() {
		return driver.findElement(printorder);
	}
	
	public void ShiftTab() {
		driver.findElement(ordershiptab).click();
	}
	
	public WebElement IsProductNameDisplayed() {
		return driver.findElement(productname);
	}
	
	public WebElement IsSKUDisplayed() {
		return driver.findElement(sku);
	}
	
	public String IsPriceDisplayed() {
		return driver.findElement(price).getText().replace("£", "").trim();
	}
	
	public String IsQuantityDisplayed() {
		return driver.findElement(quantity).getText();
	}
	
	public String IsSubTotalDisplayed() {
		return driver.findElement(subtotal).getText().replace("£", "").trim();
	}
	
	public String IsShippingDisplayed() {
		return driver.findElement(shipping).getText().replace("£", "").trim();
	}
	
	public String IsTotalDisplayed() {
		return driver.findElement(grandtotal).getText().replace("£", "").trim();
	}
	
	public WebElement ClickBackOrders() {
		driver.findElement(backtoorder).click();
		return driver.findElement(MyOrdersText);
	}
	
	public WebElement IsShipAddDisplayed() {
		return driver.findElement(shipaddress);
	}
	
	public WebElement IsBillAddDisplayed() {
		return driver.findElement(billaddress);
	}
	
	public WebElement IsPayMethodDisplayed() {
		return driver.findElement(paymentmethod);
	}
	
	public WebElement IsTrackIDDisplayed() {
		return driver.findElement(trackingid);
	}
	
	public WebElement IsShipmentHeadingDisplayed() {
		return driver.findElement(shipmentheading);
	}
	
	public void ClickTrackHistory() {
		driver.findElement(trackallshipment).click();
	}
	
	public WebElement IsTrackingInfoDisplayed() {
		return driver.findElement(trackinginfohead);
	}
	
	public WebElement IsSubContentDisplayed() {
		return driver.findElement(shipmentSubContent);
	}
	
	public WebElement IsTrackingnoDisplayed() {
		return driver.findElement(trackingnumber);
	}
	
	public WebElement IsCarrierDisplayed() {
		return driver.findElement(Carrier);
	}
	
	public void ClickCloseWindow() {
		driver.findElement(closeWindow).click();
	}
}
