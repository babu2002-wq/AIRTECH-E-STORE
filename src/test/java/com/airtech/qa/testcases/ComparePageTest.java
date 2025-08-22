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
import com.airtech.qa.pages.MyWishListPage;
import com.airtech.qa.pages.ProductDetailPage;
import com.airtech.qa.pages.ProductPage;

public class ComparePageTest extends BaseClass{
	
	ComparePage comp;
	LoginPage login;
	ProductDetailPage product;
	CartPage cart;
	ProductPage pro;
	MyWishListPage wish;
	
	public ComparePageTest() throws IOException  {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		pro=new ProductPage(driver);
		pro.InfusionProductDisplayed();
		login=new LoginPage(driver);
		product=pro.openproductdetail();
		comp=product.AddtoComparebtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void IsContentsDisplayed() {
		Assert.assertTrue(comp.IsCompareDisplayed().isDisplayed());
		Assert.assertTrue(comp.IsPricesDisplayed().isDisplayed());
		Assert.assertTrue(comp.IsProductsDisplayed().isDisplayed());
	}
	
	
	@Test(description = "Verify that add to cart functionality in the comparision page is working fine")
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
	
	@Test(description = "Verify that add to wishlist functionality in the comparision page is working fine")
	public void ClickWishlistTest() {
		if(login.IsLoginTextDisplayed().isDisplayed()) {	
			comp.Clickwishlistbtn();
			Assert.assertTrue(comp.WishListFail().isDisplayed());
			Assert.assertEquals(comp.WishListFail().getText(), "You must login or register to add items to your wishlist.");
		}
		
	}
	
	@Test
	public void WishlistSuccessTest() {
		login.Clickuserbtn();
		login.enteremail(getProperty("username"));
		login.enterpassword(getProperty("password"));
		login.signIn();
		comp.navigateback();
		wish=comp.clickWishlistbtn();
		comp.navigateback();
	}
	
	@Test(priority=20)
	public void removeProductTest() {
		comp=product.AddtoComparebtn();
		comp.Clickremovebtn();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
