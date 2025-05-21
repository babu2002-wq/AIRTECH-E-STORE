package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CartPage;
import com.airtech.qa.pages.ComparePage;
import com.airtech.qa.pages.LoginPage;
import com.airtech.qa.pages.ProductDetailPage;
import com.airtech.qa.pages.ProductPage;

public class CartPageTest extends BaseClass{

	public CartPageTest() throws IOException {
		super();
	}
	
	CartPage cart;
	ProductDetailPage detail;
	ProductPage pro;
	
	@BeforeTest
	public void setup() {
		initialization();
		pro=new ProductPage(driver);
		pro.InfusionProductDisplayed();
		detail=pro.openproductdetail();
		cart=detail.AddtoCartbtn();
	}
	
	@Test(priority=1)
	public void CartTextTest() {
		cart.Clickcartbtn();
		Assert.assertTrue(cart.IsCartTextDisplayed().isDisplayed());
		Assert.assertTrue(cart.IsTableDisplayed().isDisplayed());
	}
	
	@Test(priority=3)
	public void EditTest() {
		detail=cart.Clickeditbtn();
		cart.navigateback();
	}
	
	@Test(priority=5)
	public void ProdremoveTest() {
		List<WebElement> prod=cart.getallProducts();
		int prodno=prod.size();
		cart.clickremovebtn();
		int prodno1=prod.size();
		Assert.assertEquals(prodno, prodno1);	
	}
	
	@Test(priority=2)
	public void IsDiscountDisplayed() {
		Assert.assertTrue(cart.IsDiscountDisplayed().isDisplayed());
	}
	
	@Test(priority=4)
	public void ProductQuantityTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    cart.ClickIncreaseQuantity(5);
	    cart.Clickdecreasequantity(2);
	    cart.clickupdatebtn(); 
	    int retryCount = 3;
	    String quantityText = null;

	    for (int i = 0; i < retryCount; i++) {
	        try {
	            quantityText = cart.getquantity().getAttribute("value").trim();
	            break; 
	        } catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException caught. Retrying...");
	        }
	    }

	    if (quantityText == null) {
	        throw new RuntimeException("Failed to get quantity after multiple attempts.");
	    }

	    WebElement unitTotalElement = wait.until(ExpectedConditions.visibilityOf(cart.getUnittotal()));
	    WebElement subtotalElement = wait.until(ExpectedConditions.visibilityOf(cart.getSubtotal()));
	    double unittotal = Double.parseDouble(unitTotalElement.getText().replaceAll("[^0-9.]", ""));
	    int quantity = Integer.parseInt(quantityText);
	    double totalquantity = unittotal * quantity;
	    double subtotal = Double.parseDouble(subtotalElement.getText().replaceAll("[^0-9.]", ""));
	    Assert.assertEquals(totalquantity, subtotal);
	}
	
	
	@Test
	public void IsTaxDisplayed() {
		Assert.assertTrue(cart.IsTaxDisplayed().isDisplayed());
	}
	
	@Test
	public void IsSubTotalDisplayed() {
		Assert.assertTrue(cart.IsSubtotalDisplayed().isDisplayed());
	}
	
	@Test
	public void IsTotalPriceDisplayed() {
		Assert.assertTrue(cart.IsTotalDisplayed().isDisplayed());
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
}
