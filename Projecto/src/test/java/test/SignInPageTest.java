package test;

import utility.ScreenShots;
import utility.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import base.TestBaseSetup;


import objectpage.UltimatixSignInPage;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class SignInPageTest extends TestBaseSetup{
private WebDriver driver;
private UltimatixSignInPage signInPage;
private ScreenShots screenshot; 


	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	
	
	@Test
	public void verifySignInFunction() throws Throwable {
		System.out.println("Sign In functionality details...");
		signInPage = new UltimatixSignInPage(driver);
		screenshot=new ScreenShots();
		
		
		
		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		screenshot.takeSnapShot(driver, "D://Selenium/"+System.currentTimeMillis()+"_take.png");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("Sign in page title matched",ExtentColor.GREEN));
		
		Assert.assertTrue(signInPage.verifyTCSLogo(), "Page text not matching");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("TCS Lopgo Displayed",ExtentColor.GREEN));
		
		Assert.assertTrue(signInPage.verifySignInError(), "Unable to sign in");
		screenshot.takeSnapShot(driver, "D://Selenium/"+System.currentTimeMillis()+"_take.png");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("Error message displayed",ExtentColor.GREEN));
	
		Assert.assertTrue(signInPage.verifyBlankUserPopup(), "Unable to sign in");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("PopUp Displayed",ExtentColor.GREEN));

		
		Assert.assertTrue(signInPage.verifyValidSignIn(), "Unable to sign in");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("Sign in succesful",ExtentColor.GREEN));
	
       	
	
	}
	
	
	

}