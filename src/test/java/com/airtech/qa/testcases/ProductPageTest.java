package com.airtech.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.CartPage;
import com.airtech.qa.pages.CheckOutPage;
import com.airtech.qa.pages.ComparePage;
import com.airtech.qa.pages.LoginPage;
import com.airtech.qa.pages.MyWishListPage;
import com.airtech.qa.pages.ProductDetailPage;
import com.airtech.qa.pages.ProductPage;


public class ProductPageTest extends BaseClass{

	public ProductPageTest() throws IOException {
		super();
	}
	
	ProductPage product;
	ProductDetailPage detail;
	CartPage cart;
	MyWishListPage wish;
	LoginPage login;
	
	@BeforeTest
	public void setup() {
		initialization();
		product=new ProductPage(driver);
		login=new LoginPage(driver);
		product.InfusionProductDisplayed();
	}

	
 
	@Test(priority=1,description = "Verify that all the sidebar sections are present")
	public void IsCategoryDisplayed() {
		Assert.assertTrue(product.IsCategoryDisplayed().isDisplayed());
		Assert.assertTrue(product.IsPriceDisplayed().isDisplayed());
		Assert.assertTrue(product.IsFeaturedDisplayed().isDisplayed());
		Assert.assertTrue(product.IsOtherLinksDisplayed().isDisplayed());
		Assert.assertTrue(product.IsSortDisplayed().isDisplayed());
		Assert.assertTrue(product.websites().isDisplayed());
		Assert.assertTrue(product.itemno().isDisplayed());
	}
	
	
	@Test(priority=7,description = "Verify that price sorting option is working fine")
	public void SortByPriceTest() {
		product.selectSortOption("price");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		List<Double> displayedPrices = product.getProductPricesFromAllPages();
	    List<Double> sortedPrices = new ArrayList<>(displayedPrices); 
	    Assert.assertEquals(displayedPrices, sortedPrices);
	}
	
	@Test(priority=8,description = "Verify that product name sorting option is working fine")
	public void SortByNameTest() {
		product.selectSortOption("name");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		List<String> displayedNames = product.getProductNamesFromAllPages();
	    List<String> sortedNames = new ArrayList<>(displayedNames);
	    Assert.assertEquals(displayedNames, sortedNames);
	}
	
	@Test(priority=6)
	public void IsShowDisplayed() {
		WebElement Show=product.IsShowDisplayed();
		Assert.assertTrue(Show.isDisplayed());
	}
	
	
	@Test(priority=9,description = "Verify that the no. of product dropdown menu is working fine")
	public void ShowItemsTest() {
		List<String> ShowValues = product.getShowDropdownValues();
	    for (String value : ShowValues) {
	        product.ShowDropdownFunction(value);
	        int expectedProductCount = Integer.parseInt(value.replaceAll("[^0-9]", ""));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(driver -> product.GetAllProducts().size() == expectedProductCount);
	        int displayedProductCount = product.GetAllProducts().size();
	        Assert.assertEquals(displayedProductCount, expectedProductCount);
	    }
	}
	

	@Test(description = "Verify that sorting toggle option is working fine")
	public void SortToggleTest() {
		product.SortOrderToggleTest();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@Test(priority=10,description = "Verify that go to product option in the quickview section is working fine")
	public void QuickgotoprodTest() {
		detail=product.quickgotoproduct();
		product.navigateback();
	}
	
	@Test(priority=12,description = "Verify that add to cart option in the quickview section is working fine")
	public void QuickCheckoutTest() {
		cart=product.quickviewAddCart();
		product.navigateback();
	}
	
	@Test(priority=11,description = "Verify that continue shopping option in the quickview section is working fine")
	public void QuickShopTest() {
		product=product.quickcontinueshopping();
		product.navigateback();
	}
	
	@Test
	public void ProductDetailTest() {
		detail=product.openproductdetail();
		product.navigateback();
	}
	
	
	@Test
	public void CartPageTest() {
		cart=product.cartdisplay();
		product.navigateback();
	}
	

	@Test
	public void CloseCartTest() {
		product.Closecart();
	}
	

	@Test(priority=30,description = "Verify that all the products are displayed properly as per their categories")
	public void checkAllCategoriesTest() throws TimeoutException {
		product.clickCategoryButton();
	    List<WebElement> originalCategoryElements = product.getAllCategoryElements();
	    int totalCategories = originalCategoryElements.size();
	    for (int i = 0; i < totalCategories; i++) {
	        List<WebElement> categories = product.getAllCategoryElements();
	        WebElement categoryElement = categories.get(i);
	        String categoryName = categoryElement.findElement(By.tagName("a")).getText().trim();
	        String countText = categoryElement.findElement(By.className("count")).getText().trim();
	        String onlyNumber = countText.replaceAll("[^0-9]", "");
	        int expectedCount = Integer.parseInt(onlyNumber);
	        product.clickCategory(categoryElement);
	        int displayedCount = product.getTotalProductCountWithPagination();
	        Assert.assertEquals(displayedCount, expectedCount);
	        product.clickClearAll();
	        product.clickCategoryButton();
	    }
   }
	
	@Test(priority = 31,description = "Verify that all the products are displayed properly as per their prices")
	public void checkAllPriceCategoriesTest() {
		product.waitForOverlayToDisappear();
	    product.clickPriceFilter();
	    List<WebElement> originalCategories = product.getPriceCategories();
	    int totalCategories = originalCategories.size();
	    for (int i = 0; i < totalCategories; i++) {
	        List<WebElement> updatedCategories = product.getPriceCategories();
	        WebElement category = updatedCategories.get(i);
	        String categoryText = category.getText().trim();
	        Pattern pattern = Pattern.compile("\\d+");
	        Matcher matcher = pattern.matcher(categoryText);
	        List<Integer> allNumbers = new ArrayList<>();
	        while (matcher.find()) {
	            allNumbers.add(Integer.parseInt(matcher.group()));
	        }

	        if (allNumbers.isEmpty()) {
	            throw new RuntimeException("No valid number found in category text: " + categoryText);
	        }
	        int expectedCount = allNumbers.get(allNumbers.size() - 1);
	        product.clickCategory(category);
	        int displayedCount = product.getDisplayedProductCount();
	        Assert.assertEquals(displayedCount, expectedCount, "Mismatch in product count for category: " + categoryText);
	        product.clickClearAll();		
	        product.waitForOverlayToDisappear();
	        //if(i==updatedCategories.size()-2) {
	    	   //  product.clickPriceFilter();
	        //}
	    }
	}


	
	@Test(priority=90,description = "Verify that add to wishlist functionality in the product page is working fine")
	public void WishListSuccessTest() {
		login.Clickuserbtn();
		login.enteremail(getProperty("username"));
		login.enterpassword(getProperty("password"));
		login.signIn();
		product.navigateback();
		wish=product.wishlistSuccess();
		product.navigateback();
	}

	

	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
}
	
	 
	

