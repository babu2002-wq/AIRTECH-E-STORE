package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CartPage;
import com.airtech.qa.pages.CheckOutPage;
import com.airtech.qa.pages.ComparePage;
import com.airtech.qa.pages.LoginPage;
import com.airtech.qa.pages.ProductDetailPage;
import com.airtech.qa.pages.ProductPage;

public class ProductPageTest extends BaseClass{

	public ProductPageTest() throws IOException {
		super();
	}
	
	ProductPage product;
	ProductDetailPage detail;
	CartPage cart;
	
	@BeforeTest
	public void setup() {
		initialization();
		product=new ProductPage(driver);
		product.InfusionProductDisplayed();
	}
	
	
	@Test(priority=1)
	public void IsCategoryDisplayed() {
		WebElement Category=product.IsCategoryDisplayed();
		Assert.assertTrue(Category.isDisplayed());
	}
	
	@Test(priority=3)
	public void IsPriceDisplayed() {
		WebElement Price=product.IsPriceDisplayed();
		Assert.assertTrue(Price.isDisplayed());
	}
	
	@Test(priority=2)
	public void IsFeaturedDisplayed() {
		WebElement Featured=product.IsFeaturedDisplayed();
		Assert.assertTrue(Featured.isDisplayed());
	}
	
	@Test(priority=4)
	public void AreLinksDisplayed() {
		WebElement Links=product.IsOtherLinksDisplayed();
		Assert.assertTrue(Links.isDisplayed());
	}
	
	@Test(priority=5)
	public void IsSortDisplayed() {
		WebElement sort=product.IsSortDisplayed();
		Assert.assertTrue(sort.isDisplayed());
	}
	
	@Test(priority=7)
	public void SortByPriceTest() {
		product.selectSortOption("price");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		List<Double> displayedPrices = product.getProductPricesFromAllPages();
	    List<Double> sortedPrices = new ArrayList<>(displayedPrices);
	    //Collections.sort(sortedPrices); 
	    Assert.assertEquals(displayedPrices, sortedPrices);
	}
	
	@Test(priority=8)
	public void SortByNameTest() {
		product.selectSortOption("name");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		List<String> displayedNames = product.getProductNamesFromAllPages();
	    List<String> sortedNames = new ArrayList<>(displayedNames);
	    //Collections.sort(sortedNames); 
	    Assert.assertEquals(displayedNames, sortedNames);
	}
	
	@Test(priority=6)
	public void IsShowDisplayed() {
		WebElement Show=product.IsShowDisplayed();
		Assert.assertTrue(Show.isDisplayed());
	}
	
	@Test(priority=9)
	public void ShowItemsTest() {
		List<String> ShowValues = product.getShowDropdownValues();
	    for (String value : ShowValues) {
	        product.ShowDropdownFunction(value);
	        int expectedProductCount = Integer.parseInt(value.replaceAll("[^0-9]", ""));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(driver -> product.getDisplayedProductCount() == expectedProductCount);
	        int displayedProductCount = product.getDisplayedProductCount();
	        Assert.assertEquals(displayedProductCount, expectedProductCount, 
	                            "Mismatch for dropdown value: " + value);
	    }
	}
	
	//@Test
	public void ProductDisplayTest() {
		product.listview();
		String listClass = product.ItemDisplay().getAttribute("class");
		Assert.assertTrue(listClass.contains("list-view"));
		product.gridview();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String gridClass = product.ItemDisplay().getAttribute("class");
		Assert.assertTrue(gridClass.contains("grid-view"));
	}
	
	@Test
	public void SortToggleTest() {
		product.SortOrderToggleTest();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@Test(priority=10)
	public void QuickgotoprodTest() {
		detail=product.quickgotoproduct();
		driver.navigate().back();
	}
	
	@Test(priority=12)
	public void QuickCheckoutTest() {
		cart=product.quickviewAddCart();
		driver.navigate().back();
	}
	
	@Test(priority=11)
	public void QuickShopTest() {
		product=product.quickcontinueshopping();
		driver.navigate().back();
	}
	
	//@Test
	public void ProductDetailTest() {
		detail=product.openproductdetail();
		driver.navigate().back();
	}
	
	@Test
	public void IsWebsitesDisplayed() {
		Assert.assertTrue(product.websites().isDisplayed());
	}
	
	@Test
	public void CartPageTest() {
		cart=product.cartdisplay();
		driver.navigate().back();	
	}
	
	@Test
	public void Isnoofitemdisplayed() {
		Assert.assertTrue(product.itemno().isDisplayed());
		
	}
	
	@Test
	public void CloseCartTest() {
		product.Closecart();
	}
	
	@Test
	public void ProductDetailPageTest() {
		detail=product.openproductdetail();
	}
	
	@Test(priority=30)
	public void checkAllCategoriesTest() {
		product.clickCategoryButton();
		List<WebElement> originalCategoryElements = product.getAllCategoryElements();
		int totalCategories = originalCategoryElements.size();
		for (int i = 0; i < totalCategories; i++) {
			
			//List<WebElement> categories = product.getAllCategoryElements();
			WebElement category = originalCategoryElements.get(i);
			String text = category.getText();
			int expectedCount = product.getExpectedCountFromCategoryText(text);
			product.clickCategory(category);
			int displayedCount = product.getDisplayedProductCount();
			Assert.assertEquals(displayedCount, expectedCount);
			product.clickClearAll();
			product.clickCategoryButton();
		}
	}
	
	@Test(priority=31)
	public void checkAllPriceCategoriesTest() {
		product.clickPriceFilter();
		List<WebElement> originalCategories = product.getPriceCategories();
		int totalCategories = originalCategories.size();
		for (int i = 0; i < totalCategories; i++) {
			product.clickPriceFilter();
			List<WebElement> updatedCategories = product.getPriceCategories();
			WebElement category = updatedCategories.get(i);
			String text = category.getText();
			int expectedCount = product.getExpectedProductCount(text);
			product.clickCategory(category);
			int displayedCount = product.getDisplayedProductCount();
			Assert.assertEquals(displayedCount, expectedCount);
			product.clickClearAll();
		}
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
}
	
	 
	

