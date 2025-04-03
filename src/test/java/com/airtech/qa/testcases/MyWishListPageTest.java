package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;

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

public class MyWishListPageTest extends BaseClass {

	public MyWishListPageTest() throws IOException {
		super();
	}
	
	MyWishListPage mywish;
	ProductDetailPage product;
	ProductPage pro;
	
	@BeforeTest
	public void setup() {
		initialization();
		pro=new ProductPage(driver);
		pro.InfusionProductDisplayed();
		product=pro.openproductdetail();
		mywish=product.ClickWishlistsuccessbtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void IsMyWishlistDisplayed() {
		Assert.assertTrue(mywish.IsImagesDisplayed().isDisplayed());
	}
	
	@Test
	public void IsQuantityDisplayed() {
		Assert.assertTrue(mywish.IsquantityDisplayed().isDisplayed());
	}
	
	@Test
	public void IsImageDisplayed() {
		Assert.assertTrue(mywish.IsImagesDisplayed().isDisplayed());
	}
	
	@Test
	public void ShowTest() {
		mywish.Changewishno("20");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		mywish.Changewishno("50");
	}
	
	@Test
	public void EditTest() {
		Assert.assertTrue(mywish.ClickEditbtn().isDisplayed());
	}
	
	@Test
	public void commenttest() {
		mywish.entercomment("Great Product");
	}
	
	@Test(priority=90)
	public void removebtntest() {
		mywish.Clickremovebtn();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	
}
