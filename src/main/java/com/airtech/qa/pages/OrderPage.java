package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.airtech.qa.base.BasePage;

public class OrderPage extends BasePage{

	public OrderPage(WebDriver driver) {
		super(driver);
    }
	
	By MyOrdersLink=By.xpath("//div[@id='block-collapsible-nav']//a[normalize-space()='My Orders']");
	By MyOrdersText=By.xpath("//span[.='My Orders']");
	By OrderId=By.xpath("//span[.='My Orders']");
	
}
