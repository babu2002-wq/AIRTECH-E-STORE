package com.airtech.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.airtech.qa.pages.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public LoginPage login;
	

	public BaseClass() throws IOException {
		prop = new Properties();
	    FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/airtech/qa/config/config.properties");
	    prop.load(file);
	}
	
	
    //@Parameters({"os","browser"})
    public static void initialization() {
  	  /*
  	   *
  	  switch(bro.toLowerCase()) {
  	  case "chrome": driver=new ChromeDriver();break;
  	  case "edge":driver=new EdgeDriver();break;
  	  case "firefox":driver=new FirefoxDriver();break;
  	  default:System.out.println("Invalid browser");return;
  	  }
  	  */
    	ChromeOptions options = new ChromeOptions();
    	 
    	 //options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

         // Start Selenium and attach to it
      driver = new ChromeDriver(options);
  	  driver.manage().deleteAllCookies();
  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  	  driver.get("https://estore.airtech.lu/");
  	  driver.manage().window().maximize();
    }
    
    
   
    
    
    
    public String captureScreen(String tname) throws IOException {
  	  String time=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  	  TakesScreenshot takescreen=(TakesScreenshot) driver;
  	  File sourcefile=takescreen.getScreenshotAs(OutputType.FILE);
  	  String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_"+ time + ".png";
  	  File targetFile=new File(targetFilePath);
  	  sourcefile.renameTo(targetFile);
  	  return targetFilePath;
    }
    
    
    public String getProperty(String key) {
        return prop.getProperty(key);
    }
    
    
    public void loginToApplication() {
        int attempt = 0;
        boolean loggedIn = false;

        while (attempt < 3) {
            LoginPage login = new LoginPage(driver);
            login.Clickuserbtn();
            login.clear();
            login.enteremail(prop.getProperty("username"));
            login.enterpassword(prop.getProperty("password"));
            login.signIn();
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                WebElement accountHeading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='base' and contains(text(),'My Account')]"))
                );
                if (accountHeading.isDisplayed()) {
                    loggedIn = true;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Login attempt " + (attempt + 1) + " failed. Retrying...");
            }

            attempt++;
        }

        if (!loggedIn) {
            throw new RuntimeException("Login failed after " + '3' + " attempts.");
        }
    }
}

    
    


