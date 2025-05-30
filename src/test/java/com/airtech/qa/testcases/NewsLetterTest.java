package com.airtech.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.airtech.qa.base.BaseClass;
import com.airtech.qa.pages.NewsLetter;

public class NewsLetterTest extends BaseClass {

	public NewsLetterTest() throws IOException {
		super();
	}
	
	NewsLetter news;
	
	@BeforeTest
	public void setup() {
		initialization();
		loginToApplication();
		news=new NewsLetter(driver);
	}
	
	@Test(priority=1)
	public void NewsLetterVisibleTest() {
		news.newsletterclick();
		Assert.assertTrue(news.IsNewsLetterDisplayed().isDisplayed());
		Assert.assertTrue(news.IsgeneralDisplayed().isDisplayed());
		Assert.assertTrue(news.IsSubscriptiontextDisplayed().isDisplayed());
	}
	
	@Test(priority=2)
	public void SaveNewsTest() {
		news.ClickNewsletterCheck();
		news.ClickSave();
		Assert.assertTrue(news.Successmsg().isDisplayed());
	}
	
	@AfterTest
		public void teardown() {
			driver.quit();
		}
}
