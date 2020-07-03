package com.test;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.Util.BaseClass;
import Com.Util.DataDriven;
import pages.CoursePreview;
import pages.GetEnrolledPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyCourses;
import pages.PayPalGuestCheckOut;
import pages.PaypalLogo;
import pages.SignUp;
import pages.paymentDebitOrCredit;

public class SparkDataBoxCourseTest extends BaseClass{
	HomePage hp;
	SignUp Su;
	CoursePreview CP;
	GetEnrolledPage gt;
	LoginPage lpp;
	MyCourses mc;
	PaypalLogo pp;
	paymentDebitOrCredit pdc;
	PayPalGuestCheckOut ppgo;
	
	@BeforeMethod
	public void setUp() {
		BaseClass bas=BaseClass.GetInstance();
		bas.openBrowser();
		hp=new HomePage();
		
}
	@DataProvider
	public String[][] getQueryData() throws Exception {
		String[][] data=DataDriven.Query();
		return data;
	}
	
	@Test(priority=1,dataProvider="getQueryData")
	public void SearchQueryTest(String query,String validatequery) {
		String act=hp.verifytitle();
		Assert.assertEquals(act, "Online Courses with Certificate of Completion | SparkDatabox");
		hp.searchcourse(query);
		hp.validateQuerySearch(validatequery);
		
	}
	@DataProvider
	public String[][] getData() throws Exception {
		String[][] data2=DataDriven.getregisteredData();
		return data2;
		
	}
	@Test(priority=2,dataProvider="getData")
	public void userSignupTest(String fname,String lname,String eml,String pass,String cpass) {
		Su=hp.clickOnSignUp();
		Su.registration(fname, lname, eml, pass, cpass);
	}
	@DataProvider
	public String[][] login() throws Exception {
		String[][] data3=DataDriven.loginData();
		return data3;
		
	}
	@Test(priority=3,dataProvider="login")
	 public void verifyLoginTest(String email,String password,String specificcourse,String validatecourse,String validateaddedcourse) {
		lpp=hp.clickOnLogin();
		hp=lpp.verifylogin(email, password);
		hp.searchSpecificCourse(specificcourse);
		gt=hp.searchfreecourse(validatecourse);
		mc= gt.clickOnGetEnrolled();
        mc.validateAddedCourse(validateaddedcourse);
      
	}
        @DataProvider
    	public String[][] couponFreeCourse() throws Exception {
    		String[][] data3=DataDriven.freecouponCourse();
    		return data3;
    		
    	}
		@Test(priority=4,dataProvider="couponFreeCourse")
		
		public void validateFreeCouponforPythonCourseTest(String username,String pass,String query,String coupon,String validatecours ){
			lpp=hp.clickOnLogin();
			hp=lpp.verifylogin(username, pass);
			hp.searchcourse(query);
			gt=hp.clickOnfreecouponcours();
			mc=gt.clickOnApplyCoupon(coupon);
			mc.validateAddedCourse(validatecours);
				}


    @DataProvider
	public String[][] selfPacedAndLive() throws Exception {
		String[][] data4=DataDriven.TopSelfPacedAndLiveCoursesTest();
		return data4;
		
	}
	@Test(priority=5,dataProvider="selfPacedAndLive")
	public void validateTopSelfPacedAndLiveCoursesTest(String username,String password,String LiveAndSelfPaced,String cno,String edate,String cv,String fnam,String lnam,String add,String cit,String stat,String pcode,String tele,String emai) {
	    lpp=hp.clickOnLogin();
		hp=lpp.verifylogin(username, password);
		gt=hp.selectLiveAndSelfPacedCourses(LiveAndSelfPaced);
		pp=gt.clickOnEnrollNow();
		pdc=pp.clickOnpaypal();
		ppgo=pdc.clickOndebitOrcredit();
		ppgo.clickOnguestCheckout(cno, edate, cv, fnam, lnam, add, cit, stat, pcode, tele, emai);			
}
		
	
	
	@AfterMethod
	public void TearDown() {
		if(driver!=null) 
		driver.quit();
	}
	
}
