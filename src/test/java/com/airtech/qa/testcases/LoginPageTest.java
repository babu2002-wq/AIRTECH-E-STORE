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

public class LoginPageTest extends BaseClass{

	public LoginPageTest() throws IOException {
		super();
	}
	
	LoginPage login;
	ProductPage product;
	
	
	@BeforeTest
	public void setup() {
		initialization();
		product=new ProductPage(driver);
		product.InfusionProductDisplayed();
		login=new LoginPage(driver);
	}
	
	@Test
	public void ClickUserTest() {
		login.Clickuserbtn();
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"})
	public void LoginTextTest() {
		Assert.assertTrue(login.IsLoginTextDisplayed().isDisplayed());
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"},priority = 90)
	public void logintest() {
		login.enteremail(getProperty("email"));
		login.enterpassword(getProperty("password"));
		login.signIn();
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"})
	public void registertest() {
	    String register=login.register();
	    Assert.assertTrue(register.contains("CREATE NEW"));
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"})
	public void ForgotPasswordTest() {
		Assert.assertTrue(login.Clickforgetpassword().contains("FORGOT"));
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"})
	public void ToggleTest() {
		login.enterpassword(getProperty("password"));
		Assert.assertEquals(login.getPassword().getAttribute("type"), "password");
		login.Clicktoggle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertEquals(login.getPassword().getAttribute("type"), "text");
		login.Clicktoggle();
		Assert.assertEquals(login.getPassword().getAttribute("type"), "password" );
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
