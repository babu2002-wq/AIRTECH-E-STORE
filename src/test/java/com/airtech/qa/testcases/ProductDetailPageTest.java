package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CartPage;
import com.airtech.qa.pages.ComparePage;
import com.airtech.qa.pages.LoginPage;
import com.airtech.qa.pages.MyWishListPage;
import com.airtech.qa.pages.ProductDetailPage;
import com.airtech.qa.pages.ProductPage;

public class ProductDetailPageTest extends BaseClass{

	public ProductDetailPageTest() throws IOException {
		super();
	}
	
	ProductDetailPage detail;
	LoginPage login;
	ProductPage product;
	ComparePage compare;
	MyWishListPage wish;
	CartPage cart;
	
	@BeforeTest
	public void setup() {
		initialization();
		product=new ProductPage(driver);
		product.InfusionProductDisplayed();
		detail=product.openproductdetail();
		login=new LoginPage(driver);
	}
	
	
	@Test(priority=1)
	public void IsdetailDisplayed() {
		Assert.assertTrue(detail.Isdetaildisplayed().isDisplayed());	
    }
	
	@Test(priority=2)
	public void IsMoreInfoDisplayed() {
		Assert.assertTrue(detail.Ismoreinfodisplayed().isDisplayed());	
    }
	
	@Test(priority=3)
	public void IsReviewDisplayed() {
		Assert.assertTrue(detail.Isreviewsdisplayed().isDisplayed());
	}
	
	@Test(priority=4)
	public void IsPriceDisplayed() {
		Assert.assertTrue(detail.IsPricedisplayed().isDisplayed());
	}
	
	@Test(priority=5)
	public void IsProductNameDisplayed() {
		Assert.assertTrue(detail.IsProductNamedisplayed().isDisplayed());
	}
	
	@Test(priority=11)
	public void nextproductTest() {
		String productname=detail.ProductName();
		detail.ClickNextbtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String productname1=detail.ProductName();
		Assert.assertNotEquals(productname, productname1);
	}
	
	@Test(priority=12)
	public void previousproductTest() {
		String productname=detail.ProductName();
		detail.ClickPrevbtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String productname1=detail.ProductName();
		Assert.assertNotEquals(productname, productname1);
	}
	
	@Test(priority=6)
	public void IsReviewGivenDisplayed() {
		Assert.assertTrue(detail.IsReviewGivenDisplayed().isDisplayed());
	}
	
	@Test(priority=7)
	public void IsDescDisplayed() {
		Assert.assertTrue(detail.IsDescDisplayed().isDisplayed());
	}
	
	@Test(priority=8)
	public void IsStockSKUDisplayed() {
		Assert.assertTrue(detail.IsStockSkuDisplayed().isDisplayed());
	}
	
	@Test(priority=9)
	public void IsStockDisplayed() {
		 String expectedStockText = "In stock";
		 Assert.assertEquals(detail.StockDisplayed(),expectedStockText);
	}
	
	@Test(priority=10)
	public void IsIncrementDisplayed() {
		Assert.assertTrue(detail.IsIncrementDisplayed().isDisplayed());
	}
	
	@Test(priority=13)
	public void QuantityIncrementTest() {
		int originalquantity=detail.getquantity();
		detail.Clickincrementbtn(3);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(
		        detail.getQuantityElement(), "value", String.valueOf(originalquantity)
		)));
		int changedquantity=detail.getquantity();
		Assert.assertEquals(originalquantity, changedquantity);
	}
	
	@Test(dependsOnMethods= {"QuantityIncrementTest"},priority=13)
	public void QuantityDecrementTest() {
		int originalquantity=detail.getquantity();
		detail.Clickincrementbtn(2);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(
	            detail.getQuantityElement(), "value", String.valueOf(originalquantity)
	    )));
		int changedquantity=detail.getquantity();
		Assert.assertEquals(originalquantity, changedquantity);
	}
	
	
	@Test(priority=14)
	public void CartSuccessTest() {
		cart=detail.AddtoCartbtn();
		detail.navigateback();
	}
	
	
	@Test(priority=15)
	public void CompareSuccessTest() {
		compare=detail.AddtoComparebtn();
		detail.navigateback();
		
	}
	
	//@Test(priority=16)
	public void AddWishListSuccessTest() {
		Assert.assertTrue(detail.AddtoWishlistSuccess().isDisplayed());
	}
	
	@Test(priority=30)
	public void WishListSuccessTest() {
		if(!detail.isUserLoggedIn()) {
			String wishlistfail=detail.AddtoWishlistfail();
			Assert.assertEquals(wishlistfail, "You must login or register to add items to your wishlist.");
		}
		else {
			detail.AddtoWishlistSuccess();
			wish=detail.ClickWishlistsuccessbtn();
		}
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
