package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.Util.BaseClass;

public class PayPalGuestCheckOut extends BaseClass{

	
	@FindBy(xpath="//button[text()='Accept Cookies']")
	WebElement acceptcookies;
	
	@FindBy(xpath="//select[@id='countrySelector']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='cc']")
	WebElement cardno;
	
	@FindBy(xpath="//input[@id='expiry_value']")
	WebElement expdate;
	
	@FindBy(xpath="//input[@id='cvv']")
	WebElement cvv;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='billingLine1']")
	WebElement add1;
	
	@FindBy(xpath="//input[@id='billingCity']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='billingState']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='billingPostalCode']")
	WebElement postalcode;
	@FindBy(xpath="//input[@id='telephone']")
	WebElement telephne;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//label[@class='noBottom ng-binding ng-scope']")
	WebElement paypalcheckbox;
	@FindBy(xpath="//input[@id='dobText']")
	WebElement dateofbirth;
	@FindBy(xpath="//select[@id='occupation']")
	WebElement occupation;
	
	@FindBy(xpath="//span[@class='bgImg']")
	WebElement bgimg;
	
	@FindBy(xpath="//label[@id='marketingOptinText']")
	WebElement agreeterms;
	
	@FindBy(xpath="(//label[@class='noBottom ng-binding'])[2]")
	WebElement nothanks;
	@FindBy(xpath="(//label[@class='noBottom ng-binding ng-scope'])[2]")
	WebElement nothanksterm;
	
	@FindBy(xpath="//button[@id='guestSubmit']")
	WebElement paynow;
	
	public PayPalGuestCheckOut() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnguestCheckout(String cno,String edate,String cv,String fnam,String lnam,String add,String cit,String stat,String pcode,String tele,String emai) {
		acceptcookies.click();
		Select sel=new Select(country);
		sel.selectByIndex(4);
		cardno.sendKeys(cno);
		expdate.sendKeys(edate);
		cvv.sendKeys(cv);
		fname.sendKeys(fnam);
		lname.sendKeys(lnam);
		add1.sendKeys(add);
		city.sendKeys(cit);
		Select sel1=new Select(state);
		sel1.selectByVisibleText(stat);
		postalcode.sendKeys(pcode);
		telephne.sendKeys(tele);
		email.sendKeys(emai);
//		paypalcheckbox.click();
//		password.sendKeys(pass);
//		dateofbirth.sendKeys(dob);
//		Select sel3=new Select(occupation);
//		sel3.selectByIndex(5);
//		bgimg.click();
//		agreeterms.click();
		
		paynow.click();
		
		//return new PayPalGuestCheckOut();
	}
}
