package com.airtech.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.AddressPage;
import com.airtech.qa.pages.ProductPage;

public class AddressPageTest extends BaseClass{

	public AddressPageTest() throws IOException {
		super();
	}
	
	AddressPage address;
	
	
	@BeforeTest
	public void setup() {
		initialization();
		loginToApplication();
		address=new AddressPage(driver);
	}
	
	@Test(priority=1)
	public void Addressbookclick() {
		address.addressbookclick();
		Assert.assertTrue(address.IsaddressbooktextDisplayed().isDisplayed());
		Assert.assertTrue(address.IsdefaultaddtextDisplayed().isDisplayed());
		Assert.assertTrue(address.IsdefbilltextDisplayed().isDisplayed());
		Assert.assertTrue(address.IsbilladdboxDisplayed().isDisplayed());
		Assert.assertTrue(address.IsdefshipaddDisplayed().isDisplayed());
		Assert.assertTrue(address.IsShipaddboxDisplayed().isDisplayed());
	}
	
	
	@Test(priority=2)
	public void ChangeshipTest() {
		address.Changeshipbtnclick();
		Assert.assertEquals(address.Changeshipbtn(), "Edit Address");
		driver.navigate().back();
	}
	
	@Test(priority=3)
	public void ChangebillTest() {
		address.Changebillbtnclick();
		Assert.assertEquals(address.Changebillbtn(), "Edit Address");
		driver.navigate().back();
	}
	
	@Test(priority=4)
	public void IsadditionaladdDisplayed() {
		Assert.assertTrue(address.IsaddionaladdDisplayed().isDisplayed());
	}
	
	@Test(priority=5)
	public void NewAddbtnClick() {
		address.ClicknewAddressbtn();
		Assert.assertTrue(address.IsNewaddtextDisplayed().isDisplayed());
		Assert.assertTrue(address.IsContactInfoDisplayed().isDisplayed());
		Assert.assertTrue(address.IsAddresstextDisplayed().isDisplayed());
		Assert.assertTrue(address.enterfn().isDisplayed());
		Assert.assertTrue(address.enterln().isDisplayed());
		Assert.assertTrue(address.entercity().isDisplayed());
		Assert.assertTrue(address.entercom().isDisplayed());
		Assert.assertTrue(address.enterstate().isDisplayed());
		Assert.assertTrue(address.enterstreet().isDisplayed());
		Assert.assertTrue(address.enterzip().isDisplayed());
		Assert.assertTrue(address.Clickbillcheck().isDisplayed());
		Assert.assertTrue(address.Clickshipcheck().isDisplayed());
		
	}
	
	@Test(priority=6)
	public void AddnewAddressTest() {
		address.clear();
		List<WebElement> required=address.reqfields();
		address.Clicksavebtn();
		List<WebElement> errormsgs=address.errormsgs();
		Assert.assertEquals(errormsgs.size(),required.size());
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
