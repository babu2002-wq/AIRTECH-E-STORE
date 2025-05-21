package com.airtech.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CartPage;
import com.airtech.qa.pages.ProfilePage;



public class ProfilePageTest extends BaseClass {

	public ProfilePageTest() throws IOException {
		super();
	}
	
	ProfilePage profile;
	CartPage cart;
	
	@BeforeTest
	public void setup() {
		initialization();
		loginToApplication();
		profile=new ProfilePage(driver);
		profile.ClickMyAccount();
	}
	
	@Test
	public void MenusDisplayed() {
		Assert.assertTrue(profile.IsOptionsDisplayed().isDisplayed());
		Assert.assertTrue(profile.IsaccountInfoDisplayed().isDisplayed());
		Assert.assertTrue(profile.IsAddressbookDisplayed().isDisplayed());
		Assert.assertTrue(profile.IscontactInfoDisplayed().isDisplayed());
		Assert.assertTrue(profile.IsDefaultBillDisplayed().isDisplayed());
		Assert.assertTrue(profile.IsDefaultShipDisplayed().isDisplayed());
		Assert.assertTrue(profile.IsnewsletterDisplayed().isDisplayed());
		Assert.assertTrue(profile.IsRecentDisplayed().isDisplayed());
	}
	
	@Test
	public void IsEditPassDisplayed() {
		Assert.assertTrue(profile.ClickEditContact().isDisplayed());
		profile.navigateBack();
	}
	
	@Test
	public void ChangePassTest() {
		Assert.assertTrue(profile.ClickChangePass().isDisplayed());
		profile.navigateBack();
	}
	
	@Test
	public void NewsletterTest() {
		Assert.assertTrue(profile.ClickNewsLetter().isDisplayed());
		profile.navigateBack();
	}
	
	@Test
	public void ViewOrdersTest() {
		Assert.assertTrue(profile.ClickViewOrders().isDisplayed());
		profile.navigateBack();
	}
	
	@Test
	public void ReOrderTest() {
		cart=profile.ClickReOrders();
		profile.navigateBack();
	}
	
	@Test
	public void AllOrdersTest() {
		Assert.assertTrue(profile.ClickAllOrders().isDisplayed());
		profile.navigateBack();
	}
	
	@Test
	public void ManageAdressTest() {
		Assert.assertTrue(profile.ClickManageAddress().isDisplayed());
		profile.navigateBack();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
