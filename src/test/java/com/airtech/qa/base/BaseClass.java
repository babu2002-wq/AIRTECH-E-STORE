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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() throws IOException {
		   prop = new Properties();
		   FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/airtech/qa/config/config.properties");
           prop.load(file);
	}

    @BeforeClass
    //@Parameters({"os","browser"})
    public void setup() throws IOException {
  	  /*
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
  	  driver.get(prop.getProperty("url"));
  	  driver.manage().window().maximize();
    }
    
    
    @AfterClass
    public void teardown() {
  	  driver.quit();
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
    

}
