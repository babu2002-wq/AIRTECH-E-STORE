package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
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

public class ComparePageTest extends BaseClass{
	
	ComparePage comp;
	LoginPage login;
	ProductDetailPage product;
	CartPage cart;
	ProductPage pro;
	
	public ComparePageTest() throws IOException  {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		pro=new ProductPage(driver);
		pro.InfusionProductDisplayed();
		login=new LoginPage(driver);
		product=pro.clickProduct();
		comp=product.AddtoComparebtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void IsContentsDisplayed() {
		Assert.assertTrue(comp.IsCompareDisplayed().isDisplayed());
		Assert.assertTrue(comp.IsPricesDisplayed().isDisplayed());
		Assert.assertTrue(comp.IsTableDisplayed().isDisplayed());
		Assert.assertTrue(comp.IsProductsDisplayed().isDisplayed());
	}
	
	
	@Test
	public void addtoCartTest() {
		WebElement successmsg=comp.Clickaddtocartbtn();
		Assert.assertTrue(successmsg.isDisplayed());
		cart=comp.Clickcartbtn();
		comp.navigateback();
	}
	
	
	@Test
	public void ClickProductTest() {
		WebElement product=comp.ClickProduct();
		Assert.assertTrue(product.isDisplayed());
		comp.navigateback();
	}
	
	@Test
	public void ClickWishlistTest() {
		if(login.IsLoginTextDisplayed().isDisplayed()) {	
			comp.Clickwishlistbtn();
			Assert.assertTrue(comp.WishListFail().isDisplayed());
			Assert.assertEquals(comp.WishListFail().getText(), "You must login or register to add items to your wishlist.");
		}
		else {
			comp.Clickwishlistbtn();
			Assert.assertEquals(driver.getTitle(), "MY WISHLIST");
		}
	}
	
	@Test(priority=20)
	public void removeProductTest() {
		comp.Clickremovebtn();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
