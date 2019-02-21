package test;

//import java.text.SimpleDateFormat;
//import java.util.Date;
import utility.ScreenShots;
import utility.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import base.TestBaseSetup;
import objectpage.UltimatixSignInPage;
import objectpage.UltimatixMainPage;


public class MainPageTest extends TestBaseSetup

{

  private WebDriver driver;
  private ScreenShots screenshot; 
  private UltimatixSignInPage signInPage;
  private UltimatixMainPage mainPage;


  @BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	
	@Test
	public void verifyMainPage() throws Throwable {
		System.out.println("Sign In functionality details...");
		signInPage = new UltimatixSignInPage(driver);
		signInPage.verifyValidSignIn();
		
		mainPage = new UltimatixMainPage(driver);
		
		
		screenshot=new ScreenShots();
		
		
		Assert.assertTrue(mainPage.verifyMainPageTitle(), "Sign In page title doesn't match");
		screenshot.takeSnapShot(driver, "D://Selenium/"+System.currentTimeMillis()+"_take.png");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("Main page title matched",ExtentColor.GREEN));
		
		Assert.assertTrue(mainPage.verifyUltimatixLogo(), "Page text not matching");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("Ultimatix Logo Displayed",ExtentColor.GREEN));
		
		Assert.assertTrue(mainPage.verifySearchEmployee(), "Page text not matching");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("Employee Details Displayed",ExtentColor.GREEN));
		
			
		
	}
	
	
	
}