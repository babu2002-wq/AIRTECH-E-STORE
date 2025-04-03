package com.airtech.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.ContactPage;

public class ContactPageTest extends BaseClass {

	public ContactPageTest() throws IOException {
		super();
	}
	
	ContactPage contact=new ContactPage(driver);
	
	@Test
	public void ContactbtnTest() {
		contact.ClickContact();
	}
	
	@Test
	public void IsContactDisplayed() {
		Assert.assertTrue(contact.IsContactDisplayed().isDisplayed());
	}
	
	@Test
	public void ContactallNegativeTest() {
		contact.entersubmit();
		Assert.assertTrue(contact.EmailValidationDisplayed().isDisplayed());
		Assert.assertTrue(contact.NameValidationDisplayed().isDisplayed());
		Assert.assertTrue(contact.CommentValidationDisplayed().isDisplayed());
	}
	
	@Test
	public void InvalidEmailTest() {
		contact.enteremail("ashis");
		contact.entersubmit();
		Assert.assertEquals(contact.EmailValidationDisplayed().getText(),"Please enter a valid email address (Ex: johndoe@domain.com).");
	}
	
	@Test
	public void NameTest() {
		contact.entername("Ashis");
		Assert.assertTrue(contact.EmailValidationDisplayed().isDisplayed());
		Assert.assertTrue(contact.CommentValidationDisplayed().isDisplayed());
	}
	
	@Test
	public void IsAddressesDisplayed() {
		Assert.assertTrue(contact.IsadressesDisplayed().isDisplayed());
	}
	
}
