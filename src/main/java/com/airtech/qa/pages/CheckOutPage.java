package com.airtech.qa.pages;

import java.util.List;

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
	By createtext=By.xpath("//span[normalize-space()='Create an account']");
	By createcheck=By.xpath("//label[@for='create-account-checkbox']");
	By passwordfield=By.xpath("//input[@id='osc-password']");
	By forgotpassfield=By.xpath("//input[@id='osc-password-confirmation']");
	By billshipsame=By.xpath("//input[@id='billing-address-same-as-shipping']");
	By billingtext=By.xpath("//span[normalize-space()='Billing Address']");
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
	By subtotal=By.xpath("//span[@data-th='Cart Subtotal']");
	By ordertotal=By.xpath("//td[@class='amount']//strong");
	By shippingprice=By.xpath("//span[@data-th='Shipping']");
	By taxprice=By.xpath("td[data-th='Tax'] span[class='price']");
	By otherpaymentmethod=By.xpath("//div[@id='payment-method-braintree-paypal']//div[@class='payment-method-title field choice']");
	By otherpaycheck=By.xpath("//input[@id='braintree_paypal']");
	By placeorder=By.xpath("//div[@class='place-order-primary']//button[@title='Place Order']");
	By errormsg=By.xpath("//div[@class='mage-error']");
	By requiredfields=By.xpath("//input[@aria-required='true'] | //textarea[@aria-required='true'] | //select[@aria-required='true']");
	
	
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
	
	public WebElement enteremail() {
		return driver.findElement(email);
	}
	
	public WebElement enterfirstname() {
		return driver.findElement(firstname);
	}
	
	public WebElement enterlastname() {
		return driver.findElement(lastname);
	}
	
	public WebElement enteraddress() {
		return driver.findElement(streetaddress);
	}
	
	public WebElement entercity() {
		return driver.findElement(city);
	}
	
	public WebElement enterpostalcode() {
		return driver.findElement(postalcode);
	}
	
	public WebElement enterstate() {
		return driver.findElement(state);
	}
	
	public WebElement entercompany() {
		return driver.findElement(company);
	}
	
	public WebElement entercountry() {
		return driver.findElement(country);
	}
	
	public WebElement enterindustrytype() {
		return driver.findElement(industrytype);
	}
	
	public void ClickCreate() {
		driver.findElement(createcheck).click();
	}
	
	public WebElement IsPasswordDisplayed() {
		return driver.findElement(passwordfield);
	}
	
	public WebElement IsForgotPassDisplayed() {
		return driver.findElement(forgotpassfield);
	}
	
	public void IsBillShipSame() {
		driver.findElement(billshipsame).click();
	}
	
	public WebElement IsBilltextDisplayed() {
		return driver.findElement(billingtext);
	}
	
	public WebElement enterfn() {
		return driver.findElement(firstname1);
	}
	
	public WebElement enterln() {
		return driver.findElement(lastname1);
	}
	
	public WebElement enteradd() {
		return driver.findElement(streetaddress1);
	}
	
	public WebElement enterpc() {
		return driver.findElement(postalcode1);
	}
	
	public WebElement entercty() {
		return driver.findElement(city1);
	}
	
	public WebElement entercomp() {
		return driver.findElement(company1);
	}
	
	public WebElement entercont() {
		return driver.findElement(country1);
	}
	
	public WebElement enterst() {
		return driver.findElement(state1);
	}
	
	public WebElement enterindustry() {
		return driver.findElement(industrytype1);
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
	
	public WebElement entercreditno() {
		return driver.findElement(creditcardno);
	}
	
	public WebElement enterexpiredate() {
		return driver.findElement(expiredate);
	}
	
	public WebElement entercvv() {
		return driver.findElement(cardverifyno);
	}
	
	public WebElement Clickdiscount() {
		return driver.findElement(entercode);
	}
	
	public WebElement Clickapplydiscount() {
		return driver.findElement(applycode);
	}
	
	public void checkterm() {
		driver.findElement(termcheckbox).click();
		driver.findElement(termlink).click();
		driver.findElement(termclose).click();
		driver.findElement(termcheckbox).click();
	}
	
	public double gettotalprice() {
		String tot=driver.findElement(ordertotal).getText().replace("£", "").trim();
		double total=Double.parseDouble(tot);
		return total;
	}
	
	public double getsumprices() {
		String subtot=driver.findElement(subtotal).getText().replace("£", "").trim();
		String tax=driver.findElement(taxprice).getText().replace("£", "").trim();
		String ship=driver.findElement(shippingprice).getText().replace("£", "").trim();
	    double subtotalValue = Double.parseDouble(subtot);
	    double taxValue = Double.parseDouble(tax);
	    double shippingValue = Double.parseDouble(ship);
	    double totalSum = subtotalValue + taxValue + shippingValue;
	    return totalSum;
	}
	
	public WebElement Isordertotaldisplayed() {
		return driver.findElement(ordertotal);
	}
	
	public WebElement IsSubtotalDisplayed() {
		return driver.findElement(subtotal);
	}
	
	public WebElement IsTaxDisplayed() {
		return driver.findElement(taxprice);
	}
	
	public void ClickPlaceOrder() {
		driver.findElement(placeorder).click();
	}
	
	public List<WebElement> errormsg(){
		return driver.findElements(errormsg);
	}
	
	public List<WebElement> requiredfields(){
		return driver.findElements(requiredfields);
	}
}
