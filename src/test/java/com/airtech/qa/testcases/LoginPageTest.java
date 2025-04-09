package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CartPage;
import com.airtech.qa.pages.ComparePage;
import com.airtech.qa.pages.ForgotPasswordPage;
import com.airtech.qa.pages.LoginPage;
import com.airtech.qa.pages.MyWishListPage;
import com.airtech.qa.pages.ProductDetailPage;
import com.airtech.qa.pages.ProductPage;
import com.airtech.qa.pages.RegistrationPage;

public class LoginPageTest extends BaseClass{

	public LoginPageTest() throws IOException {
		super();
	}
	
	LoginPage login;
	ProductPage product;
	ForgotPasswordPage forgot;
	RegistrationPage register;
	
	
	@BeforeTest
	public void setup() {
		initialization();
		product=new ProductPage(driver);
		product.InfusionProductDisplayed();
		login=new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void ClickUserTest() {
		login.Clickuserbtn();
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"},priority = 2)
	public void LoginTextTest() {
		Assert.assertTrue(login.IsLoginTextDisplayed().isDisplayed());
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"},priority = 7)
	public void logintest() {
		login.clear();
		login.enteremail(getProperty("username"));
		login.enterpassword(getProperty("password"));
		login.signIn();
		Assert.assertEquals(driver.getTitle(), "Vacuum Bagging and Composite Tooling - My Account");
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"},priority = 4)
	public void registertest() {
	   register=login.register();
	   login.Clickuserbtn();
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"},priority = 5)
	public void ForgotPasswordTest() {
		forgot=login.Clickforgetpassword();
		login.Clickuserbtn();
	}
	
	@Test(dependsOnMethods= {"ClickUserTest"},priority = 6)
	public void ToggleTest() {
		login.enterpassword(getProperty("password"));
		Assert.assertEquals(login.getPassword().getAttribute("type"), "password");
		login.Clicktoggle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertEquals(login.getPassword().getAttribute("type"), "text");
		login.Clicktoggle();
		Assert.assertEquals(login.getPassword().getAttribute("type"), "password" );
	}
	
	@Test(priority = 3)
	public void ValidationTest() {
		List<WebElement> fields=login.requiredfields();
		login.SignInClick();
		List<WebElement> errormsg=login.errormsgs();
		for(int i=0;i<fields.size();i++) {
			System.out.println(fields);
		}
		Assert.assertEquals(errormsg.size(),fields.size());
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
