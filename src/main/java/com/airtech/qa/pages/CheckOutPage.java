package com.airtech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.airtech.qa.base.BasePage;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	By checkouttxt=By.xpath("//span[@class='base']");
	By shippingaddresstxt=By.xpath("//span[normalize-space()='Shipping Address']");
	By shippingmethodtxt=By.xpath("//span[normalize-space()='Shipping Methods']");
	By paymentmethodtxt=By.xpath("//span[normalize-space()='Payment Methods']");
	By loginlink=By.xpath("//span[normalize-space()='Already have an account? Click here to login']");
	By email=By.xpath("//input[@id='customer-email']");
	By validationmsg=By.xpath("//div[@id='customer-email-error']");
	By firstname=By.xpath("(//input[@name='firstname'])[1]");
	By lastname=By.xpath("(//input[@name='lastname'])[1]");
	By streetaddress=By.xpath("(//input[@name='street[0]'])[1]");
	By city=By.xpath("(//input[@name='city'])[1]");
	By postalcode=By.xpath("(//input[@name='postcode'])[1]");
	By country=By.xpath("(//select[@name='country_id'])[1]");
	By state=By.xpath("(//input[@name='region'])[1]");
	By company=By.xpath("(//input[@name='company'])[1]");
	By industrytype=By.xpath("(//select[@name='custom_attributes[industrytype]'])[1]");
	By createcheck=By.xpath("//input[@id='create-account-checkbox']");
	By billshipsame=By.xpath("//input[@id='billing-address-same-as-shipping']");
	By billingtext=By.xpath("//input[@id='billing-address-same-as-shipping']");
	By firstname1=By.xpath("(//input[@name='firstname'])[2]");
	By lastname1=By.xpath("(//input[@name='lastname'])[2]");
	By streetaddress1=By.xpath("(//input[@name='street[0]'])[2]");
	By city1=By.xpath("(//input[@name='city'])[2]");
	By postalcode1=By.xpath("(//input[@name='postcode'])[2]");
	By country1=By.xpath("(//select[@name='country_id'])[2]");
	By state1=By.xpath("(//input[@name='region'])[2]");
	By company1=By.xpath("(//input[@name='company'])[2]");
	By industrytype1=By.xpath("(//select[@name='custom_attributes[industrytype]'])[2]");
	By creditcardbtn=By.xpath("//input[@id='braintree']");
	By creditcardtypes=By.xpath("//ul[@class='credit-card-types braintree-credit-card-types']");
	By creditcardno=By.xpath("//input[@id='credit-card-number']");
	By expiredate=By.xpath("//input[@id='expiration']");
	By cardverifyno=By.xpath("//div[@id='braintree_cc_cid']");
	By applydiscountbtn=By.xpath("//span[contains(text(),'Apply Discount Code')]");
	By entercode=By.xpath("//input[@id='discount-code']");
	By applycode=By.xpath("//button[@value='Apply Discount']//span//span[contains(text(),'Apply Discount')]");
	By termcheckbox=By.xpath("//input[@id='agreement__2']");
	By termclose=By.xpath("//button[@class='action secondary action-hide-popup']//span[contains(text(),'Close')]");
	By modalvisible=By.xpath("//aside[@class='modal-popup agreements-modal modal-slide _inner-scroll _show']//div[@class='modal-inner-wrap']");
	By termlink=By.xpath("//span[@data-bind='html: checkboxText']");
	By increasequantity=By.xpath("//a[@title='Plus']");
	By decreasequantity=By.xpath("//a[@title='Minus']");
	By quantity=By.xpath("//input[@name='item_qty']");
	By subtotal=By.xpath("//span[@class='cart-price']");
	By ordertotal=By.xpath("//td[@class='amount']//strong");
	By otherpaymentmethod=By.xpath("//div[@id='payment-method-braintree-paypal']//div[@class='payment-method-title field choice']");
	By otherpaycheck=By.xpath("//input[@id='braintree_paypal']");
	
	
	public WebElement IsCheckoutDisplayed() {
		return driver.findElement(checkouttxt);
	}
	
	public WebElement IsShippingtxtDisplayed() {
		return driver.findElement(shippingaddresstxt);
	}
	
	public WebElement IsShippingMethodDisplayed() {
		return driver.findElement(shippingmethodtxt);
	}
	
	public WebElement IsPaymentMethodDisplayed() {
		return driver.findElement(paymentmethodtxt);
	}
	
	public WebElement ClickLogin() {
		WebElement login=driver.findElement(loginlink);
		login.click();
		return login;
	}
	
	public void enteremail(String em) {
		driver.findElement(email).sendKeys(em);
	}
	
	public void enterfirstname(String fn) {
		driver.findElement(firstname).sendKeys(fn);
	}
	
	public void enterlastname(String ln) {
		driver.findElement(lastname).sendKeys(ln);
	}
	
	public void enteraddress(String ad) {
		driver.findElement(streetaddress).sendKeys(ad);
	}
	
	public void entercity(String ci) {
		driver.findElement(city).sendKeys(ci);
	}
	
	public void enterpostalcode(String pc) {
		driver.findElement(postalcode).sendKeys(pc);
	}
	
	public void enterstate(String st) {
		driver.findElement(state).sendKeys(st);
	}
	
	public void entercompany(String com) {
		driver.findElement(company).sendKeys(com);
	}
	
	public void entercountry(String con) {
		WebElement dropdownElement = driver.findElement(country);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(con);
	}
	
	public void enterindustrytype(String ind) {
		WebElement dropdownElement = driver.findElement(industrytype);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(ind);
	}
	
	public void ClickCreate() {
		driver.findElement(createcheck).click();
	}
	
	public void IsBillShipSame() {
		driver.findElement(billshipsame).click();
	}
	
	public WebElement IsBilltextDisplayed() {
		return driver.findElement(billingtext);
	}
	
	public void enterfn(String fn) {
		driver.findElement(firstname1).sendKeys(fn);
	}
	
	public void enterln(String ln) {
		driver.findElement(lastname1).sendKeys(ln);
	}
	
	public void enteradd(String add) {
		driver.findElement(streetaddress1).sendKeys(add);
	}
	
	public void enterpc(String pc) {
		driver.findElement(postalcode1).sendKeys(pc);
	}
	
	public void entercty(String city) {
		driver.findElement(city1).sendKeys(city);
	}
	
	public void entercomp(String comp) {
		driver.findElement(company1).sendKeys(comp);
	}
	
	public void entercont(String cont) {
		WebElement dropdownElement = driver.findElement(country1);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(cont);
	}
	
	public void enterst(String st) {
		driver.findElement(state1).sendKeys(st);
	}
	
	public void enterindustry(String ind) {
		WebElement dropdownElement = driver.findElement(industrytype1);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(ind);
	}
	
	public WebElement Clickcreditbtn() {
		WebElement credit=driver.findElement(creditcardbtn);
		credit.click();
		return credit;
	}
	
	public WebElement IsOtherMethodDisplayed() {
		return driver.findElement(otherpaymentmethod);
	}
	
	public void Clickotherpaymethod() {
		driver.findElement(otherpaycheck).click();
	}
	
	public WebElement IsPaymethodsDisplayed() {
		return driver.findElement(creditcardtypes);
	}
	
	public void entercreditno(String cardno) {
		driver.findElement(creditcardno).sendKeys(cardno);
	}
	
	public void enterexpiredate(String date) {
		driver.findElement(expiredate).sendKeys(date);
	}
	
	public void entercvv(String cvv) {
		driver.findElement(cardverifyno).sendKeys(cvv);
	}
	
	public void Clickdiscount(String code) {
		driver.findElement(applydiscountbtn).click();
		driver.findElement(entercode).sendKeys(code);
	}
	
	public void Clickapplydiscount() {
		driver.findElement(applycode).click();
	}
	
	public void checkterm() {
		driver.findElement(termcheckbox).click();
		driver.findElement(termlink).click();
		driver.findElement(termclose).click();
		driver.findElement(termcheckbox).click();
	}
	
	
	
	
}
