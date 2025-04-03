package com.airtech.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	By sortbtn=By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@id='layer-product-list']/div[1]/div[1]/a[1]");
	By show=By.xpath("//div[@class='column main']//div[1]//div[4]//label[1]//span[1]");
	By showoptions=By.xpath("//div[contains(@class,'column main')]//div[1]//div[4]//div[1]//select[1]");
	By listview=By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@id='layer-product-list']/div[1]/div[2]/a[1]");
	By gridview=By.xpath("//div[@class='column main']//div[1]//div[2]//strong[2]");
	By elementcontainer=By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@id='layer-product-list']/div[2]");
	By addwishlistbtn=By.xpath("(//li[contains(@class, 'product-item')])[1]//a[contains(@class, 'wishlist')]");
	By addcartbtn=By.xpath("(//li[contains(@class, 'product-item')])[1]//button[contains(@class, 'tocart')]");
	By producthover=By.xpath("(//li[contains(@class, 'product-item')])[1]");
	By quickview=By.xpath("(//li[contains(@class, 'product-item')])[1]//a[contains(@class, 'quickview')]");
	By productclick=By.xpath("//b[normalize-space()='Wrightlon® 3700']");
	By allprices=By.xpath("//div[@id=\"layer-product-list\"]//div[contains(@class,'product-item-info')]//span[@class='price']");
	By allproducts=By.xpath("//div[@id=\"layer-product-list\"]//strong[@class='product name product-item-name']//b");
	By websites=By.xpath("//h5[normalize-space()='Websites']");
	By wishlistbtn=By.xpath("//i[contains(@class,'far fa-heart')]");
	By opencartbtn=By.xpath("//a[@class='action showcart']");
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
	By wishlisterror=By.xpath("//div[@class='message-error error message']");
	By wishlistsuccess=By.xpath("//div[@class='message-success success message']");
	By viewcartbtn=By.xpath("//span[normalize-space()='View Cart']");	
	By noofitem=By.xpath("//div[@class='items-total']");
	By closecart=By.xpath("//button[@id='btn-minicart-close']");
	By search=By.xpath("//i[@class='fas fa-search']");
	By uniqueitemidentify=By.xpath("//li[@class='item product']");	
	
	
	
	
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
                int expectedCount = Integer.parseInt(matcher.group(1)); 
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    for (int attempt = 0; attempt < 3; attempt++) {
	        try {
	            WebElement sortByDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(sortoptions));

	            Select select = new Select(sortByDropdown);
	            if (option.equalsIgnoreCase("price")) {
	                select.selectByVisibleText("Price");
	            } else if (option.equalsIgnoreCase("name")) {
	                select.selectByVisibleText("Product Name");
	            }

	            return; 
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Stale element reference caught! Retrying attempt " + (attempt + 1));
	        }
	    }
	       
	}
	
	public List<Double> getProductPricesFromAllPages() {
		List<Double> prices = new ArrayList<>();
	    do {
	        boolean success = false;
	        int attempts = 0;
	        while (!success && attempts < 3) { 
	            try {
	                List<WebElement> priceElements = driver.findElements(allprices);
	                prices.clear(); 
	                for (WebElement priceElement : priceElements) {
	                    String priceText = priceElement.getText().replace("£", "").replace(",", "").trim();
	                    prices.add(Double.parseDouble(priceText));
	                }
	                success = true; 
	            } catch (StaleElementReferenceException e) {
	                System.out.println("Stale element encountered, retrying... Attempt: " + (attempts + 1));
	                attempts++;
	            }
	        }
	    } while (goToNextPage());
	    return prices;
		
	}
	
	
	public boolean goToNextPage() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ln_overlay")));

	        WebElement nextButton = driver.findElement(By.xpath("//a[@class='action  next']"));
	        if (nextButton.isDisplayed() && nextButton.isEnabled()) {
	            nextButton.click();
	            return true;
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("No more pages to navigate.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("Next button click intercepted, retrying...");
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@class='action  next']"))); // Click using JavaScript
	        return true;
	    }
	    return false;
	    }
	
	
	public List<String> getProductNamesFromAllPages() {
		List<String> names = new ArrayList<>();
	    do {
	        boolean success = false;
	        int attempts = 0;
	        while (!success && attempts < 3) { 
	            try {
	                List<WebElement> nameElements = driver.findElements(allproducts);
	                names.clear(); 
	                for (WebElement nameElement : nameElements) {
	                    names.add(nameElement.getText().trim());
	                }
	                success = true; 
	            } catch (StaleElementReferenceException e) {
	                System.out.println("Stale element encountered, retrying... Attempt: " + (attempts + 1));
	                attempts++;
	            }
	        }
	    } while (goToNextPage());
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
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	      WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(showoptions));
	      Select dropdown = new Select(dropdownElement);
	      return dropdown.getOptions().stream()
	                     .map(WebElement::getText)
	                     .collect(Collectors.toList());
	}
	
	public int getDisplayedProductCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(allproducts));
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
	
	public CartPage quickviewAddCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement hover = wait.until(ExpectedConditions.presenceOfElementLocated(producthover));
	    actions.moveToElement(hover).perform();
	    WebElement quickViewButton = wait.until(ExpectedConditions.elementToBeClickable(quickview));
	    quickViewButton.click();
	    WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
	    driver.switchTo().frame(frame);
	    WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(quickcart));
	    addToCartButton.click();
	    WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutbtn));
	    checkoutButton.click();
	    driver.switchTo().defaultContent();
	    return new CartPage(driver);
	}
	
	public ProductDetailPage quickgotoproduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement hover = wait.until(ExpectedConditions.presenceOfElementLocated(producthover));
		actions.moveToElement(hover).perform();
		WebElement quickViewButton = wait.until(ExpectedConditions.elementToBeClickable(quickview));
		quickViewButton.click();
		WebElement frame=wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
		driver.switchTo().frame(frame);
		WebElement product = wait.until(ExpectedConditions.elementToBeClickable(quickproduct));
		product.click();
		driver.switchTo().defaultContent();
		return new ProductDetailPage(driver);
	}
	
	public ProductPage quickcontinueshopping() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement hover=wait.until(ExpectedConditions.presenceOfElementLocated(producthover));
		actions.moveToElement(hover).perform();
		WebElement quickViewButton = wait.until(ExpectedConditions.elementToBeClickable(quickview));
	    quickViewButton.click();
	    WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
		driver.switchTo().frame(frame);
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(quickcart));
	    addToCartButton.click();
	    WebElement continueshp = wait.until(ExpectedConditions.elementToBeClickable(continueshop));
	    continueshp.click();
	    driver.switchTo().defaultContent();
		return new ProductPage(driver);
	}
	
	
	public ProductDetailPage openproductdetail() {
		driver.findElement(productclick).click();
		return new ProductDetailPage(driver);
	}
	
	public WebElement websites() {
		WebElement website=driver.findElement(websites);
		return website;
	}
	
	public WebElement wishlisterror() {
		driver.findElement(addwishlistbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement errormsg=driver.findElement(wishlisterror);
		return errormsg;
	}
	
	public WebElement wishlistSuccess() {
		driver.findElement(addwishlistbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement successmsg=driver.findElement(wishlistsuccess);
		return successmsg;
	}
	
	public CartPage cartdisplay() {
		driver.findElement(opencartbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(viewcartbtn).click();
		return new CartPage(driver);
	}
	
	public WebElement itemno() {
		driver.findElement(opencartbtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver.findElement(noofitem);
	}
	
	public void Closecart() {
		driver.findElement(opencartbtn).click();
		driver.findElement(closecart).click();
	}
	
	public WebElement ItemDisplay() {
		WebElement container=driver.findElement(elementcontainer);
		return container;
	}
	
	public void InfusionProductDisplayed() {
		driver.findElement(infusionproducts).click();
	}
	
	
}
