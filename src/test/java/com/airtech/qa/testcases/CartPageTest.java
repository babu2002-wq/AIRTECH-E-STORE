package com.airtech.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CartPage;
import com.airtech.qa.pages.ProductPage;

public class CartPageTest extends BaseClass{

	public CartPageTest() throws IOException {
		super();
	}
	
	CartPage cart=new CartPage(driver);
	
	@Test(priority=1)
	public void CartTextTest() {
		cart.Clickcartbtn();
		Assert.assertTrue(cart.IsCartTextDisplayed().isDisplayed());
		Assert.assertTrue(cart.IsTableDisplayed().isDisplayed());
	}
	
	@Test(priority=2)
	public void EditTest() {
		cart.Clickeditbtn(1);
		Assert.assertTrue(cart.uniqueElement().isDisplayed());
	}
	
	@Test
	public void ProdremoveTest() {
		List<WebElement> prod=cart.getProducts();
		int prodno=prod.size();
		cart.clickremovebtn(0);
		int prodno1=prod.size();
		Assert.assertEquals(prodno, prodno1);	
	}
	
	
}
