package com.airtech.qa.testcases;

import java.io.IOException;

import org.testng.Assert;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CheckOutPage;


public class CheckOutPageTest extends BaseClass {

	public CheckOutPageTest() throws IOException {
		super();
	}
	
	CheckOutPage check=new CheckOutPage(driver);
	
	public void IsCheckoutDisplayed() {
		Assert.assertTrue(check.IsCheckoutDisplayed().isDisplayed());
	}
	
	public void IsShippingDisplayed() {
		Assert.assertTrue(check.IsShippingtxtDisplayed().isDisplayed());
	}
	
	public void IsShippingMethodDisplayed() {
		Assert.assertTrue(check.IsShippingMethodDisplayed().isDisplayed());
	}
	
	public void IsPaymentMethodDisplayed() {
		Assert.assertTrue(check.IsPaymentMethodDisplayed().isDisplayed());
	}
	
	public void IsPaymethodsDisplayed() {
		Assert.assertTrue(check.IsPaymentMethodDisplayed().isDisplayed());
	}
	
	
}
