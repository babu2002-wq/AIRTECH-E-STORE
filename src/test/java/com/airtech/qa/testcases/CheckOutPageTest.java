package com.airtech.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CartPage;
import com.airtech.qa.pages.CheckOutPage;
import com.airtech.qa.pages.ProductDetailPage;
import com.airtech.qa.pages.ProductPage;


public class CheckOutPageTest extends BaseClass {

	public CheckOutPageTest() throws IOException {
		super();
	}
	
	CartPage cart;
	ProductDetailPage detail;
	ProductPage pro;
	CheckOutPage check;
	
	
	@BeforeTest
	public void setup() {
		initialization();
		pro=new ProductPage(driver);
		pro.InfusionProductDisplayed();
		detail=pro.openproductdetail();
		cart=detail.AddtoCartbtn();
		check=cart.ClickCheckout();
	}
	
	
	@Test(priority=1)
	public void ShippingAddressFieldsTest() {
		Assert.assertTrue(check.IsCheckoutDisplayed().isDisplayed());
		Assert.assertTrue(check.IsShippingtxtDisplayed().isDisplayed());
		Assert.assertTrue(check.IsShippingMethodDisplayed().isDisplayed());
		Assert.assertTrue(check.IsPaymentMethodDisplayed().isDisplayed());
		Assert.assertTrue(check.enteremail().isDisplayed());
		Assert.assertTrue(check.enteraddress().isDisplayed());
		Assert.assertTrue(check.entercity().isDisplayed());
		Assert.assertTrue(check.entercompany().isDisplayed());
		Assert.assertTrue(check.enterfirstname().isDisplayed());
		Assert.assertTrue(check.enterindustrytype().isDisplayed());
		Assert.assertTrue(check.entercountry().isDisplayed());
		Assert.assertTrue(check.enterstate().isDisplayed());
		Assert.assertTrue(check.enterpostalcode().isDisplayed());
		Assert.assertTrue(check.enterlastname().isDisplayed());
	}
	
	@Test(priority=2)
	public void Createaccounttest() {
		check.ClickCreate();
		Assert.assertTrue(check.IsPasswordDisplayed().isDisplayed());
		Assert.assertTrue(check.IsForgotPassDisplayed().isDisplayed());
		check.ClickCreate();
	}
	
	@Test(priority=3)
	public void BillingAddressFields() {
		Assert.assertTrue(check.IsBilltextDisplayed().isDisplayed());
		Assert.assertTrue(check.enterfn().isDisplayed());
		Assert.assertTrue(check.enterln().isDisplayed());
		Assert.assertTrue(check.enteradd().isDisplayed());
		Assert.assertTrue(check.entercty().isDisplayed());
		Assert.assertTrue(check.enterpc().isDisplayed());
		Assert.assertTrue(check.entercomp().isDisplayed());
		Assert.assertTrue(check.entercont().isDisplayed());
		Assert.assertTrue(check.enterst().isDisplayed());
		Assert.assertTrue(check.enterindustry().isDisplayed());
	}
	
	
	@Test(priority=4)
	public void PlaceOrderTest() {
		List<WebElement> required=check.requiredfields();
		check.ClickPlaceOrder();
		List<WebElement> errormsg=check.errormsg();
		Assert.assertEquals(errormsg,required);
	}
	
	
	@Test(priority=5)
	public void ShippingBillingSameTest() {
		check.IsBillShipSame();
		Assert.assertFalse(check.IsBilltextDisplayed().isDisplayed());
	}
	
	@Test(priority=6)
	public void PaymentMethodsTest() {
		Assert.assertTrue(check.entercreditno().isDisplayed());
		Assert.assertTrue(check.Clickcreditbtn().isDisplayed());
		Assert.assertTrue(check.entercvv().isDisplayed());
		Assert.assertTrue(check.Clickapplydiscount().isDisplayed());
		Assert.assertTrue(check.Clickdiscount().isDisplayed());
		Assert.assertTrue(check.enterexpiredate().isDisplayed());
		//check.Clickotherpaymethod();
	}
	
	//@Test(priority=7)
	public void Termtest() {
		check.checkterm();
	}
	
	@Test(priority=8)
	public void ProductSummaryTest() {
		Assert.assertTrue(check.IsTaxDisplayed().isDisplayed());
		Assert.assertTrue(check.IsSubtotalDisplayed().isDisplayed());
		Assert.assertTrue(check.Isordertotaldisplayed().isDisplayed());
	}
	
	@Test(priority=9)
	public void ProductPricingTest() {
		Double Sumprice=check.getsumprices();
		Double Totalprice=check.gettotalprice();
		Assert.assertEquals(Sumprice, Totalprice);
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
}
