package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CheckOutPage;
import com.airtech.qa.pages.ProductPage;

public class ProductPageTest extends BaseClass{

	public ProductPageTest() throws IOException {
		super();
	}
	
	ProductPage product=new ProductPage(driver);
	
	@Test
	public void IsCategoryDisplayed() {
		WebElement Category=product.IsCategoryDisplayed();
		Assert.assertTrue(Category.isDisplayed());
	}
	
	@Test
	public void IsPriceDisplayed() {
		WebElement Price=product.IsPriceDisplayed();
		Assert.assertTrue(Price.isDisplayed());
	}
	
	@Test
	public void IsFeaturedDisplayed() {
		WebElement Featured=product.IsFeaturedDisplayed();
		Assert.assertTrue(Featured.isDisplayed());
	}
	
	@Test
	public void AreLinksDisplayed() {
		WebElement Links=product.IsOtherLinksDisplayed();
		Assert.assertTrue(Links.isDisplayed());
	}
	
	@Test
	public void IsSortDisplayed() {
		WebElement sort=product.IsSortDisplayed();
		Assert.assertTrue(sort.isDisplayed());
	}
	
	@Test
	public void SortByPriceTest() {
		product.selectSortOption("price");
		List<Double> displayedPrices = product.getProductPricesFromAllPages();
	    List<Double> sortedPrices = new ArrayList<>(displayedPrices);
	    Collections.sort(sortedPrices); 
	    Assert.assertEquals(displayedPrices, sortedPrices);
	}
	
	@Test
	public void SortByNameTest() {
		product.selectSortOption("name");
		List<String> displayedNames = product.getProductNamesFromAllPages();
	    List<String> sortedNames = new ArrayList<>(displayedNames);
	    Collections.sort(sortedNames); 
	    Assert.assertEquals(displayedNames, sortedNames);
	}
	
	@Test
	public void IsShowDisplayed() {
		WebElement Show=product.IsShowDisplayed();
		Assert.assertTrue(Show.isDisplayed());
	}
	
	@Test
	public void ShowItemsTest() {
		List<String> ShowValues=product.getShowDropdownValues();
		for(String value:ShowValues) {
			product.ShowDropdownFunction(value);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			int expectedProductCount = Integer.parseInt(value.replaceAll("[^0-9]", ""));
			int displayedProductCount=product.getDisplayedProductCount();
			Assert.assertEquals(displayedProductCount, expectedProductCount);
		}
	}
	
	@Test
	public void ProductDisplayTest() {
		product.listview();
		String listClass = product.ItemDisplay().getAttribute("class");
		Assert.assertTrue(listClass.contains("list-view"));
		product.gridview();
		String gridClass = product.ItemDisplay().getAttribute("class");
		Assert.assertTrue(gridClass.contains("grid-view"));
	}
	
	@Test
	public void SortToggleTest() {
		product.SortOrderToggleTest();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@Test
	public void QuickgotoprodTest() {
		WebElement prod=product.quickgotoproduct();
		Assert.assertTrue(prod.isDisplayed());
	}
	
	@Test
	public void QuickCheckoutTest() {
		Assert.assertTrue(product.quickviewAddCart().contains("CHECKOUT"));
	}
	
	@Test
	public void QuickShopTest() {
		Assert.assertTrue(product.quickcontinueshopping().contains("Infusion-Low-Temp-Curing"));
	}
	
	@Test
	public void ProductDetailTest() {
		WebElement prod=product.quickgotoproduct();
		Assert.assertTrue(prod.isDisplayed());
	}
	
	@Test
	public void IsWebsitesDisplayed() {
		Assert.assertTrue(product.websites().isDisplayed());
	}
	
	@Test
	public void CartPageTest() {
		Assert.assertTrue(product.cartdisplay().contains("CART"));
	}
	
	@Test
	public void Isnoofitemdisplayed() {
		Assert.assertTrue(product.itemno().isDisplayed());
	}
	
	@Test
	public void CloseCartTest() {
		product.Closecart();
	}
	
	
}
	
	 
	

