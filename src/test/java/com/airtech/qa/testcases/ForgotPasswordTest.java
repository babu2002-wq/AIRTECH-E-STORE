package com.airtech.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.ForgotPasswordPage;


public class ForgotPasswordTest extends BaseClass{

	public ForgotPasswordTest() throws IOException {
		super();
	}
	
	ForgotPasswordPage forgot;
	
	@BeforeTest
	public void setup() {
		initialization();
		forgot=new ForgotPasswordPage(driver);
		forgot.Clickuserbtn();
		forgot.Clickforgotbtn();
	}
	
	@Test(priority=1)
	public void ForgotTest() {
		Assert.assertTrue(forgot.IsForgotDisplayed().isDisplayed());
		Assert.assertTrue(forgot.IsResetDisplayed().isDisplayed());
	}
	
	@Test(priority=2)
	public void ResetTest() {
		Assert.assertTrue(forgot.enteremail().isDisplayed());
		forgot.Clickresetbtn();
		Assert.assertTrue(forgot.ErrorDisplayed().isDisplayed());
		forgot.Clickproductlink();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
