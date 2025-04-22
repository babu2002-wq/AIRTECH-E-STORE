package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.RegistrationPage;


public class RegistrationPageTest extends BaseClass{

	public RegistrationPageTest() throws IOException {
		super();
	}
	
	RegistrationPage register;
	
	@BeforeMethod
	public void setup() {
		initialization();
		register=new RegistrationPage(driver);
		register.ClickRegister();
	}
	
	
	@Test(priority=1)
	public void RegistrationTest() {
		Assert.assertTrue(register.Ispersonaltxtdisplayed().isDisplayed());
		Assert.assertTrue(register.enterfirstname().isDisplayed());
		Assert.assertTrue(register.enteremail().isDisplayed());
		Assert.assertTrue(register.enterlastname().isDisplayed());
		Assert.assertTrue(register.selectIndustry().isDisplayed());
		Assert.assertTrue(register.Newsletter().isDisplayed());
		Assert.assertTrue(register.IsSignInfoDisplayed().isDisplayed());
	}
	
	@Test(priority=2)
	public void ValidationTest() {
		List<WebElement> required=register.required();
		register.ClickCreatebtn();
		List<WebElement> error=register.errors();
		Assert.assertEquals(error, required);
	}
	
	@Test(priority=3)
	public void PasswordMeterTest() {
		String InitialStrength=register.getPasswordStrength();
		register.enterpassword(getProperty("password"));
		String FinalStrength=register.getPasswordStrength();
		Assert.assertNotEquals(InitialStrength, FinalStrength);
		register.clear();
	}
	
	@Test(priority=4)
	public void PasswordToggleTest() {
		register.enterpassword(getProperty("password"));
		register.enterconfirmpassword(getProperty("password"));
		Assert.assertEquals(register.getPassword().getAttribute("type"), "password");
		Assert.assertEquals(register.getcnfPassword().getAttribute("type"), "password");
		register.Togglepassword();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertEquals(register.getPassword().getAttribute("type"), "text");
		Assert.assertEquals(register.getcnfPassword().getAttribute("type"), "text");
		register.Togglepassword();
		Assert.assertEquals(register.getPassword().getAttribute("type"), "password" );
		Assert.assertEquals(register.getcnfPassword().getAttribute("type"), "password");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
