package com.airtech.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.ContactPage;
import com.airtech.qa.pages.ProductPage;

public class ContactPageTest extends BaseClass {

	public ContactPageTest() throws IOException {
		super();
	}
	
	ContactPage contact;
	
	@BeforeTest
	public void setup() {
		initialization();
		contact=new ContactPage(driver);
		contact.ClickContact();
	}
	
	@Test(priority=1)
	public void ContactbtnTest() {
		Assert.assertTrue(contact.IsContactDisplayed().isDisplayed());
		Assert.assertTrue(contact.IsadressesDisplayed().isDisplayed());
	}
	
	
	@Test(priority=2)
	public void ContactallNegativeTest() {
		contact.clear();
		contact.entersubmit();
		Assert.assertTrue(contact.EmailValidationDisplayed().isDisplayed());
		Assert.assertTrue(contact.NameValidationDisplayed().isDisplayed());
		Assert.assertTrue(contact.CommentValidationDisplayed().isDisplayed());
	}
	
	@Test(priority=3)
	public void InvalidEmailTest() {
		contact.enteremail("ashis");
		contact.entersubmit();
		Assert.assertEquals(contact.EmailValidationDisplayed().getText(),"Please enter a valid email address (Ex: johndoe@domain.com).");
	}
	
	@Test
	public void NameTest() {
	     Assert.assertTrue(contact.entername().isDisplayed());
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
