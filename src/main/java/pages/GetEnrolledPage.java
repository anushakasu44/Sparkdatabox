package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class GetEnrolledPage extends BaseClass{
	
	@FindBy(xpath="(//a[text()='Get Enrolled'])[position()=1]")
	WebElement getenrolled;
	
	@FindBy(xpath="//a[text()=' Apply Coupon ']")
	WebElement applycoupon;
	
	@FindBy(xpath="//input[@name='coupon_code']")
	WebElement coupontextbox;
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement apply;
	
	@FindBy(xpath="//div[@class='instructor-box menu-icon-box']//div//a")
	WebElement mycourse;
	
	@FindBy(xpath="//div[@class='schedule-btn schedule-btn-inline']//a")
	WebElement alreadypurchasd;
	
	@FindBy(xpath="//a[text()='Get Enrolled']")
	WebElement enrollnow;

	public GetEnrolledPage() {
		PageFactory.initElements(driver, this);
	}
	
	public MyCourses clickOnGetEnrolled() {
		if(getenrolled.isDisplayed()) {
		getenrolled.click();
		}
		else if(alreadypurchasd.isDisplayed()){
			System.out.println("Already purchased");
			alreadypurchasd.click();
		}
		return new MyCourses();
	}
	
	public MyCourses clickOnApplyCoupon(String coupon) {
		if(applycoupon.isDisplayed()) {
			applycoupon.click();
		coupontextbox.sendKeys(coupon);
		apply.click();
		enrollnow.click();
		
		}
		return new MyCourses();
	}
	
	
}
