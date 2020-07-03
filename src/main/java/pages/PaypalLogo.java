package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class PaypalLogo extends BaseClass{
	
	
@FindBy(xpath="//div[@class='paypal-button-label-container']//img[2]")
WebElement paypal;

public PaypalLogo() {
	PageFactory.initElements(driver, this);
}

public paymentDebitOrCredit clickOnpaypal() {
	ScrolldownbyWindow();
	paypal.click();
	for(String handle:driver.getWindowHandles()) {
		driver.switchTo().window(handle);
	}
	return new paymentDebitOrCredit();
}




}
