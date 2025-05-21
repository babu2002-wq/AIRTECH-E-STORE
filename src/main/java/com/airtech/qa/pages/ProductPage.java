package com.airtech.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
	By gridview=By.xpath("(//a[@title='Grid'])[1]");
	By elementcontainer=By.xpath("//body/div[@class='page-wrapper']/main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[@id='layer-product-list']/div[2]");
	By addwishlistbtn=By.xpath("(//li[contains(@class, 'product-item')])[1]//a[contains(@class, 'wishlist')]");
	By addcartbtn=By.xpath("(//li[contains(@class, 'product-item')])[1]//button[contains(@class, 'tocart')]");
	By producthover=By.xpath("(//li[contains(@class, 'product-item')])[1]");
	By quickview=By.xpath("(//li[contains(@class, 'product-item')])[1]//a[contains(@class, 'quickview')]");
	By productclick=By.xpath("//b[normalize-space()='Airflow 65R']");
	By allprices=By.xpath("//div[@id=\"layer-product-list\"]//div[contains(@class,'product-item-info')]//span[@class='price']");
	By allproducts=By.xpath("//div[@id=\"layer-product-list\"]//strong[@class='product name product-item-name']//b");
	By websites=By.xpath("//h5[normalize-space()='Websites']");
	By wishlistbtn=By.xpath("//i[contains(@class,'far fa-heart')]");
	By opencartbtn=By.xpath("//a[@class='action showcart']");
	By allcategories=By.xpath("//div[@attribute='cat']//div[@data-role='ln_content']//li");
	By infusionproducts=By.xpath("//span[normalize-space()='Infusion & Low Temp Curing']");
	By autoclaveproducts=By.xpath("//span[normalize-space()='Autoclave']");
	By nextbtn=By.xpath("//div[contains(@class,'columns')]//div[3]//div[3]//ul[1]//li[6]//a[1]");
	By clearAllbtn=By.xpath("//span[normalize-space()='Clear All']");
	By pricecategories=By.xpath("//div[@attribute='price']//div[@data-role='ln_content']//li");
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
	By actionnext=By.xpath("//a[@class='action  next']");
	By wishlistsuccessbtn=By.xpath("//button[@id='wishlist_checkout']");
	
	
	
	public WebElement IsCategoryDisplayed() {
	     WebElement category=driver.findElement(Category);
	     return category;
	}
	
	public void clickCategoryButton() {
		driver.findElement(Category).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allcategories));
	}
	
	public List<WebElement> getAllCategoryElements() {
		return driver.findElements(allcategories);
	}
	
	public int getExpectedCountFromCategoryText(String text) {
		Pattern pattern = Pattern.compile("\\(\\s*(\\d+)\\s*\\)");
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			return Integer.parseInt(matcher.group(1));
		}
		return 0;
	}
	
	public void clickCategory(WebElement categoryElement) {
		List<WebElement> oldProducts = driver.findElements(allproducts);
	    WebElement oldFirstProduct = oldProducts.size() > 0 ? oldProducts.get(0) : null;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement clickableLink = categoryElement.findElement(By.tagName("a"));
	    wait.until(ExpectedConditions.elementToBeClickable(clickableLink)).click();
	    if (oldFirstProduct != null) {
	        wait.until(ExpectedConditions.stalenessOf(oldFirstProduct));
	    }
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allproducts));
	}
	
	
	public void clickClearAll() {
		driver.findElement(clearAllbtn).click();
	}
	
	
	public void clickPriceFilter() {
		driver.findElement(Price).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pricecategories));
	}
	
	public List<WebElement> getPriceCategories() {
		return driver.findElements(pricecategories);
	}
	
	public int getExpectedProductCount(String text) {
		Pattern pattern = Pattern.compile("\\((\\d+)\\)");
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			return Integer.parseInt(matcher.group(1));
		}
		return 0;
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
	                    String priceText = priceElement.getText().replaceAll("[£$€₹,]", "").trim();
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
	    Set<WebElement> uniqueProducts = new HashSet<>();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ln_overlay")));
	    uniqueProducts.addAll(driver.findElements(allproducts));

	    while (isPaginationPresent()) {
	        try {
	            WebElement nextButton = driver.findElement(By.xpath("(//a[contains(@title,'Next')])[2]"));

	            if (nextButton.isDisplayed() && nextButton.isEnabled()) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);

	                try {
	                    wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
	                } catch (ElementClickInterceptedException e) {
	                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
	                }

	                
	                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ln_overlay")));
	                wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(allproducts)));

	                uniqueProducts.addAll(driver.findElements(allproducts));
	            } else {
	                break;
	            }
	        } catch (NoSuchElementException e) {
	            break;
	        }
	    }

	    return uniqueProducts.size();
	}

	
	
	public void listview() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(listview).click();
		wait.until(ExpectedConditions.attributeContains(ItemDisplay(), "class", "list-view"));
	}
	
	public void gridview() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(gridview).click();
		wait.until(ExpectedConditions.attributeContains(ItemDisplay(), "class", "grid-view"));
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
		List<WebElement> product=GetAllProducts();
		product.getFirst().click();
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
	
	public MyWishListPage wishlistSuccess() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(addwishlistbtn).click();
		WebElement wishlistsuccess = wait.until(ExpectedConditions.elementToBeClickable(wishlistsuccessbtn));
		wishlistsuccess.click();
		return new MyWishListPage(driver);
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
	
	public boolean isPaginationPresent() {
		 try {
		        WebElement nextButton = driver.findElement(By.xpath("(//a[contains(@title,'Next')])[2]"));
		        return nextButton.isDisplayed() && nextButton.isEnabled();
		    } catch (NoSuchElementException e) {
		        return false;
		    }
	}
	
	
	public int getTotalProductCountWithPagination() throws TimeoutException {
	    List<WebElement> products = new ArrayList<>(driver.findElements(allproducts));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    while (isPaginationPresent()) {
	        try {
	            WebElement nextButton = driver.findElement(By.xpath("(//a[contains(@title,'Next')])[2]"));
	            if (nextButton.isDisplayed() && nextButton.isEnabled()) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
	                try {
	                    wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
	                } catch (ElementClickInterceptedException e) { 
	                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
	                }
	                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ln_overlay")));
	                wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(allproducts)));
	                products.addAll(driver.findElements(allproducts));
	            } else { 
	                break;
	            }
	        } catch (NoSuchElementException e) {  
	            break;
	        }
	    }
	    return products.size();
	}
	
	public void waitForOverlayToDisappear() {
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.invisibilityOfElementLocated(By.id("ln_overlay")));
	}

	public void navigateback() {
		driver.navigate().back();
	}
	
	public List<WebElement> GetAllProducts() {
		List<WebElement> allproduct=driver.findElements(allproducts);
		return allproduct;	
	}

	
	
}
