package com.airtech.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
	}
	
	@Test(priority=1)
	public void AccountInfoTest() {
		info.AccountInfoClick();
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
		List<WebElement> required=info.requiredfields();
		info.SavebtnClick();
		List<WebElement> errormsg=info.errors();
		Assert.assertEquals(errormsg, required);
	}
	
	@Test(priority=3)
	public void ChangePasswordTest() {
		info.CngEmailClick();
		info.CngPassClick();
		Assert.assertTrue(info.IsCngPassTextDisplayed().isDisplayed());
		Assert.assertTrue(info.IsCurrentPassDisplayed().isDisplayed());
		Assert.assertTrue(info.IsNewPassDisplayed().isDisplayed());
		Assert.assertTrue(info.IsConfirmPassDisplayed().isDisplayed());
		List<WebElement> required=info.requiredfields();
		info.SavebtnClick();
		List<WebElement> errormsg=info.errors();
		Assert.assertEquals(errormsg, required);
	}
	
	@Test(priority=4)
	public void PasswordMeterTest() {
		String InitialStrength=info.getPasswordStrength();
		info.EnterPass(getProperty("password"));
		String FinalStrength=info.getPasswordStrength();
		Assert.assertNotEquals(InitialStrength, FinalStrength);
		info.passclear();
	}
}
