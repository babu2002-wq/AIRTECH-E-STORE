package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.AddressPage;
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
	ProductDetailPage detail;
	
	
	@BeforeTest
	public void setup() {
		initialization();
		loginToApplication();
		mywish=new MyWishListPage(driver);
		mywish.ClickWishlistLink();
	}
	
	
	@Test(priority=1)
	public void MyWishlistTest() {
		Assert.assertTrue(mywish.IswishlistDisplayed().isDisplayed());
	}
	
	@Test(priority=2)
	public void ShowTest() {
		mywish.Changewishno("20");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		mywish.Changewishno("50");
	}
	
	@Test(priority=3)
	public void EditTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ln_overlay")));
		detail=mywish.ClickEditbtn();
		driver.navigate().back();
	}
	
	@Test(priority=4)
	public void commenttest() {
		mywish.entercomment("Great Product");
	}
	
	@Test(priority=90)
	public void removebtntest() {
		mywish.Clickremovebtn();
	}
	
	@Test(priority=5)
	public void quantityTest() {
	    mywish.ChangeQuantity("2");
	    try {
	    	if (!driver.findElements(By.xpath("//div[@class='message-notice notice message']")).isEmpty())  {
	    		if(mywish.QuantityExceed().isDisplayed()) {
	    			mywish.navigateback();
	    		} 
	        }
	    } catch (NoSuchElementException e) {
	        
	    }
	    
	}

	@Test(priority=6)
	public void ShareWishTest() {
		Assert.assertEquals(mywish.clicksharewish(),"Wish List Sharing");
		mywish.navigateback();
	}
	
	@Test(priority=7)
	public void AddtoCartTest() {
		mywish.clickaddtocartbtn();
		mywish.navigateback();
	}
	
	@Test(priority=8)
	public void ValidationTest() {
		Assert.assertTrue(mywish.ValidationTest().isDisplayed());
		mywish.navigateback();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
}
