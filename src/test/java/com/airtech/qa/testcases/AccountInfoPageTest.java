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
import com.airtech.qa.pages.AccountInfoPage;


public class AccountInfoPageTest extends BaseClass{

	public AccountInfoPageTest() throws IOException {
		super();
	}
	
	AccountInfoPage info;
	
	@BeforeTest
	public void setup() {
		initialization();
		loginToApplication();
		info=new AccountInfoPage(driver);
		info.AccountInfoClick();
	}
	
	@Test(priority=1)
	public void AccountInfoTest() {
		Assert.assertTrue(info.IsEditInfoDisplayed().isDisplayed());
		Assert.assertTrue(info.IsAccountInfoDisplayed().isDisplayed());
		Assert.assertTrue(info.IsFirstNameDisplayed().isDisplayed());
		Assert.assertTrue(info.IsLastNameDisplayed().isDisplayed());
	}
	
	@Test(priority=2)
	public void ChangeEmailTest() {
		info.CngEmailClick();
		Assert.assertTrue(info.CngEmailDisplayed().isDisplayed());
		Assert.assertTrue(info.IsEmailDisplayed().isDisplayed());
		Assert.assertTrue(info.IsEmailDisplayed().isDisplayed());
		Assert.assertTrue(info.IsCurrentPassDisplayed().isDisplayed());
		info.clear();
		info.CngPassClick();
		Assert.assertTrue(info.IsCngPassTextDisplayed().isDisplayed());
		Assert.assertTrue(info.IsCurrentPassDisplayed().isDisplayed());
		Assert.assertTrue(info.IsNewPassDisplayed().isDisplayed());
		Assert.assertTrue(info.IsConfirmPassDisplayed().isDisplayed());
		List<WebElement> required=info.requiredfields();
		info.SavebtnClick();
		List<WebElement> errormsg=info.errors();
		Assert.assertEquals(errormsg.size(), required.size());
		
	}
	
	
	@Test(priority=4)
	public void PasswordMeterTest() {
		String InitialStrength=info.getPasswordStrength();
		info.EnterPass(getProperty("password"));
		String FinalStrength=info.getPasswordStrength();
		Assert.assertNotEquals(InitialStrength, FinalStrength);
		info.passclear();
	}
	
	
	@Test(priority=5)
	public void ShowPasswordTest() {
		info.EnterPass(getProperty("password"));
		info.EnterConfirmPass(getProperty("password"));
	    Assert.assertEquals(info.getCurrentPassword().getAttribute("type"), "password");
		Assert.assertEquals(info.getNewPassword().getAttribute("type"), "password");
		Assert.assertEquals(info.getConfirmPassword().getAttribute("type"), "password");
		info.ShowpassClick();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertEquals(info.getCurrentPassword().getAttribute("type"), "text");
		Assert.assertEquals(info.getNewPassword().getAttribute("type"), "text");
		Assert.assertEquals(info.getConfirmPassword().getAttribute("type"), "text");
		info.ShowpassClick();
		Assert.assertEquals(info.getCurrentPassword().getAttribute("type"), "password");
		Assert.assertEquals(info.getNewPassword().getAttribute("type"), "password");
		Assert.assertEquals(info.getConfirmPassword().getAttribute("type"), "password");
		
	}
	
	@Test(priority=6)
	public void SaveInfoTest() {
		info.SavebtnClick();
		Assert.assertTrue(info.getSuccessMsg().isDisplayed());
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
