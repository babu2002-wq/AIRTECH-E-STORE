package com.airtech.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.airtech.qa.base.BasePage;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	By Category=By.xpath("//div[normalize-space()='Category']");
	By Price=By.xpath("//div[normalize-space()='Price']");
	By Featured=By.xpath("//h2[normalize-space()='Featured']");
	By otherlinks=By.xpath("//h2[normalize-space()='Airtech Advanced Materials Group']");
	By sort=By.xpath("//div[@id='layer-product-list']//div[1]//div[1]//label[1]");
	By sortoptions=By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@id='layer-product-list']/div[1]/div[1]/select[1]");
	By sortbtn=By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@id='layer-product-list']/div[1]/div[1]/a[1];");
	By show=By.xpath("//div[@class='column main']//div[1]//div[4]//label[1]//span[1]");
	By showoptions=By.xpath("//div[contains(@class,'column main')]//div[1]//div[4]//div[1]//select[1]");
	By listview=By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@id='layer-product-list']/div[1]/div[2]/a[1]");
	By gridview=By.xpath("//div[@class='column main']//div[1]//div[2]//strong[2]");
	By addwishlistbtn=By.xpath("//li[@class='item product product-item nth-child-2np1 nth-child-3np1 nth-child-4np1 nth-child-5np1 nth-child-6np1 nth-child-7np1 nth-child-8np1']//a[@title='Add to Wish List']");
	By addcartbtn=By.xpath("//li[contains(@class,'item product product-item nth-child-2np1 nth-child-3np1 nth-child-4np1 nth-child-5np1 nth-child-6np1 nth-child-7np1 nth-child-8np1')]//button[contains(@title,'Add to Cart')]");
	By producthover=By.xpath("//li[@class='item product product-item nth-child-2np1 nth-child-3np1 nth-child-4np1 nth-child-5np1 nth-child-6np1 nth-child-7np1 nth-child-8np1']//div[@class='product-item-inner']");
	By quickview=By.xpath("//li[@class='item product product-item nth-child-2np1 nth-child-3np1 nth-child-4np1 nth-child-5np1 nth-child-6np1 nth-child-7np1 nth-child-8np1']//div[@class='product-item-info type3']//div[@class='product photo product-item-photo']//a[@class='weltpixel-quickview weltpixel_quickview_button_v2']//span//span[contains(text(),'Quickview')]");
	By productclick=By.xpath("//b[normalize-space()='Wrightlon® 3700']");
	By allprices=By.xpath("//div[@id=\"layer-product-list\"]//div[contains(@class,'product-item-info')]//span[@class='price']");
	By allproducts=By.xpath("//div[@id=\"layer-product-list\"]//strong[@class='product name product-item-name']//b");
	By websites=By.xpath("//h5[normalize-space()='Websites']");
	By wishlistbtn=By.xpath("//i[contains(@class,'far fa-heart')]");
	By viewcartbtn=By.xpath("//a[@class='action showcart']");
	By allcategories=By.xpath("//div[contains(@class,'filter-options-item allow active')]//ol[contains(@class,'items')]/li");
	By infusionproducts=By.xpath("//span[normalize-space()='Infusion & Low Temp Curing']");
	By autoclaveproducts=By.xpath("//span[normalize-space()='Autoclave']");
	By nextbtn=By.xpath("//div[contains(@class,'columns')]//div[3]//div[3]//ul[1]//li[6]//a[1]");
	By clearAllbtn=By.xpath("//span[normalize-space()='Clear All']");
	By pricecategories=By.xpath("//div[@class='filter-options-item allow active']//div[@role='tabpanel']//li");
	By iframe=By.xpath("//iframe[@class='mfp-iframe']");
	By quickcart=By.xpath("//span[normalize-space()='Add to Cart']");
	By quickproduct=By.xpath("//span[normalize-space()='Go To Product']");
	By checkoutbtn=By.xpath("//span[normalize-space()='Go To Checkout']");
	By innerframe=By.xpath("//iframe[@class='mfp-iframe']");
	By continueshop=By.xpath("//span[normalize-space()='Continue Shopping']");
	
	
	public WebElement IsCategoryDisplayed() {
	     WebElement category=driver.findElement(Category);
	     return category;
	}
	
	public void CheckAllCategories() {
		driver.findElement(Category).click();
		List<WebElement> categories=driver.findElements(allcategories);
		Pattern pattern = Pattern.compile("\\((\\d+)\\)");
		for(WebElement category:categories) {
			String text = category.getText();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                int expectedCount = Integer.parseInt(matcher.group(1)); // Extracted number
                System.out.println("Checking Category: " + text + " | Expected Products: " + expectedCount);
                category.click();
                List<WebElement> displayedProducts=driver.findElements(allproducts);
                int ProductsCount = displayedProducts.size();
                   
		}
            driver.findElement(clearAllbtn).click();
			

		}
	}
	
	public void CheckPriceCategories() {
		driver.findElement(Price).click();
		List<WebElement> Pricecategories=driver.findElements(pricecategories);
		Pattern pattern = Pattern.compile("\\((\\d+)\\)");
		for(WebElement pricecategory:Pricecategories) {
			String text = pricecategory.getText();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                int expectedCount = Integer.parseInt(matcher.group(1)); // Extracted number
                System.out.println("Checking Category: " + text + " | Expected Products: " + expectedCount);
                pricecategory.click();
                List<WebElement> displayedProducts=driver.findElements(allproducts);
                int ProductsCount = displayedProducts.size();
                   
		}
            driver.findElement(clearAllbtn).click();
               
	       } 
		}
	
	public WebElement IsPriceDisplayed() {
		WebElement price=driver.findElement(Price);
		return price;
		
	}
	
	public WebElement IsFeaturedDisplayed() {
		WebElement featured=driver.findElement(Featured);
		return featured;
	}
	
	public WebElement IsOtherLinksDisplayed() {
		WebElement links=driver.findElement(otherlinks);
		return links;
	}
	
	public WebElement IsSortDisplayed() {
		WebElement Sort=driver.findElement(sort);
		return Sort;
	}
	
	public void selectSortOption(String option) {
	    WebElement sortByDropdown = driver.findElement(sortoptions); 
	    Select select = new Select(sortByDropdown);
	    if (option.equalsIgnoreCase("price")) {
	        select.selectByVisibleText("PRICE"); 
	    } else if (option.equalsIgnoreCase("name")) {
	        select.selectByVisibleText("PRODUCT NAME"); 
	    }
	       
	}
	
	public List<Double> getProductPricesFromAllPages() {
		List<Double> prices = new ArrayList<>();
		do {
			List<WebElement> priceElements = driver.findElements(allprices);
			for (WebElement priceElement : priceElements) {
	            String priceText = priceElement.getText().replace("£", "").trim(); 
	            prices.add(Double.parseDouble(priceText));
	        }
		}while (goToNextPage());
		return prices;
		
	}
	
	
	public boolean goToNextPage() {
	    WebElement nextPageButton = driver.findElement(nextbtn); 
	    if (nextPageButton.isDisplayed() && nextPageButton.isEnabled()) {
	          nextPageButton.click();
	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	          return true;  
	    }
	        return false;
	    }
	
	
	public List<String> getProductNamesFromAllPages() {
        List<String> names = new ArrayList<>();
        do {
            List<WebElement> nameElements = driver.findElements(allproducts); 
            for (WebElement nameElement : nameElements) {
                names.add(nameElement.getText().trim());
            }
        } while (goToNextPage()); // Handle pagination
        return names;
    }
	
	
	public WebElement IsShowDisplayed() {
		WebElement Show=driver.findElement(show);
		return Show;
	}
	
	public void ShowDropdownFunction(String value) {
		 WebElement dropdownElement = driver.findElement(showoptions);
		 Select dropdown = new Select(dropdownElement);
	     dropdown.selectByVisibleText(value);		 
	}
	
	public List<String> getShowDropdownValues() {
	      WebElement dropdownElement = driver.findElement(showoptions);
	      Select dropdown = new Select(dropdownElement);
	      return dropdown.getOptions().stream()
	                     .map(WebElement::getText)
	                     .collect(Collectors.toList());
	}
	
	public int getDisplayedProductCount() {
	      List<WebElement> products = driver.findElements(allproducts);
	      return products.size();
	}
	
	public void listview() {
		driver.findElement(listview).click();
	}
	
	public void gridview() {
		driver.findElement(gridview).click();
	}
	
	public void SortOrderToggleTest() {
		driver.findElement(sortbtn);
	}
	
	public CheckOutPage quickviewAddCart() {
		WebElement hover=driver.findElement(producthover);
		WebElement frame=driver.findElement(iframe);
		actions.moveToElement(hover).perform();
		driver.findElement(quickview).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.switchTo().frame(frame);
		driver.findElement(quickcart).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(innerframe).isDisplayed();
		driver.findElement(checkoutbtn).click();
		return new CheckOutPage();	
		
	}
	
	public ProductDetailPage quickgotoproduct() {
		WebElement hover=driver.findElement(producthover);
		WebElement frame=driver.findElement(iframe);
		actions.moveToElement(hover).perform();
		driver.findElement(quickview).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.switchTo().frame(frame);
		driver.findElement(quickproduct).click();
		return new ProductDetailPage();
	}
	
	public ProductPage quickcontinueshopping() {
		WebElement hover=driver.findElement(producthover);
		WebElement frame=driver.findElement(iframe);
		actions.moveToElement(hover).perform();
		driver.findElement(quickview).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.switchTo().frame(frame);
		driver.findElement(quickcart).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(innerframe).isDisplayed();
		driver.findElement(continueshop).click();
		return new ProductPage(driver);
	}
	
	public CheckOutPage quickcheckout() {
		WebElement hover=driver.findElement(producthover);
		WebElement frame=driver.findElement(iframe);
		actions.moveToElement(hover).perform();
		driver.findElement(quickview).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.switchTo().frame(frame);
		driver.findElement(quickcart).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(innerframe).isDisplayed();
		driver.findElement(continueshop).click();
		return new CheckOutPage();
	}
	
	public ProductDetailPage openproductdetail() {
		driver.findElement(productclick).click();
		return new ProductDetailPage();
	}
	
	
	
	
}
