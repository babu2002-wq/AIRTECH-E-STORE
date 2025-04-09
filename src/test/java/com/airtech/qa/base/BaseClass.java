package com.airtech.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    	
	   	
  	  driver=new ChromeDriver();
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
    	login = new LoginPage(driver);
	    login.Clickuserbtn();
	    Assert.assertTrue(login.IsLoginTextDisplayed().isDisplayed());
	    login.clear();
	    login.enteremail(prop.getProperty("username"));
	    login.enterpassword(prop.getProperty("password"));
	    login.signIn();
	}
    

}
