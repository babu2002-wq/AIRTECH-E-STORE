package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.OrderPage;


public class OrderPageTest extends BaseClass {

	public OrderPageTest() throws IOException {
		super();
	}
	
	OrderPage order;
	
	@BeforeTest
	public void setup() {
		initialization();
		loginToApplication();
		order=new OrderPage(driver);
		order.OrdersClick();
	}
	
	@Test(priority=1)
	public void OrdersheadTest() {
		Assert.assertTrue(order.IsOrdersTextDisplayed().isDisplayed());
	}
	
	@Test(priority=2)
	public void ViewOrderTest() {
		order.ClickViewOrder();
		Assert.assertTrue(order.IsOrderheadDisplayed().isDisplayed());
		Assert.assertTrue(order.IsOrderdateDisplayed().isDisplayed());
		Assert.assertTrue(order.ClickPrint().isDisplayed());
		Assert.assertTrue(order.IsProductNameDisplayed().isDisplayed());
		Assert.assertTrue(order.IsSKUDisplayed().isDisplayed());
		Assert.assertTrue(order.IsShipAddDisplayed().isDisplayed());
		Assert.assertTrue(order.IsBillAddDisplayed().isDisplayed());
		Assert.assertTrue(order.IsPayMethodDisplayed().isDisplayed());
	}
	
	@Test(priority=3)
	public void PriceTest() {
		Double quantity=Double.parseDouble(order.IsQuantityDisplayed());
		Double price=Double.parseDouble(order.IsPriceDisplayed());
		Double subtotal=Double.parseDouble(order.IsSubTotalDisplayed());
		Double shippingprice=Double.parseDouble(order.IsShippingDisplayed());
		Double pricetotal=price*quantity;
		Assert.assertEquals(pricetotal, subtotal);
		Double grandtot=Double.parseDouble(order.IsTotalDisplayed());
		Double grandtotal=subtotal+shippingprice;
		Assert.assertEquals(grandtotal, grandtot);
	}
	
	@Test(priority=4)
	public void OrderShipmentTest() {
		order.ShiftTab();
		Assert.assertTrue(order.IsTrackIDDisplayed().isDisplayed());
		Assert.assertTrue(order.IsShipmentHeadingDisplayed().isDisplayed());
	}
	
	@Test(priority=5)
	public void TrackShipmentTest() {
		String originalWindow = driver.getWindowHandle();
		order.ClickTrackHistory();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver -> driver.getWindowHandles().size() > 1);
		for (String windowHandle : driver.getWindowHandles()) {
		    if (!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		Assert.assertTrue(order.IsTrackingInfoDisplayed().isDisplayed());
		Assert.assertTrue(order.IsSubContentDisplayed().isDisplayed());
		Assert.assertTrue(order.IsCarrierDisplayed().isDisplayed());
		Assert.assertTrue(order.IsTrackingnoDisplayed().isDisplayed());
		order.ClickCloseWindow();
		driver.switchTo().window(originalWindow);
	}
	
	@Test(priority=6)
	public void CartPageTest() {
		
	}
		
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
	
}
