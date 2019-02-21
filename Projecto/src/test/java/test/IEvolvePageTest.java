package test;

//import java.text.SimpleDateFormat;
//import java.util.Date;
import utility.ScreenShots;
import utility.ExtentTestManager;
import utility.ExcelSheetDriver;
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
import objectpage.IEvolvePage;


public class IEvolvePageTest extends TestBaseSetup

{

  private WebDriver driver;
  private ScreenShots screenshot; 
  private UltimatixSignInPage signInPage;
  private UltimatixMainPage mainPage;
  private IEvolvePage ievolvepage;
  private ExcelSheetDriver excel;
  @BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	
	@Test
	public void verifyiePage() throws Throwable {
		System.out.println("Sign In functionality details...");
		signInPage = new UltimatixSignInPage(driver);
		signInPage.verifyValidSignIn();
	    mainPage = new UltimatixMainPage(driver);
		ievolvepage= new IEvolvePage(driver);
		screenshot=new ScreenShots();
		excel = new ExcelSheetDriver();
		mainPage.goToIEvolvePage();
		
		
		excel.copy("TestExcel.xlsx","Test.xlsx");
		
		Assert.assertTrue(ievolvepage.verifyCourseSearch(), "Sign In page title doesn't match");
		screenshot.takeSnapShot(driver, "D://Selenium/"+System.currentTimeMillis()+"_take.png");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel("Main page title matched",ExtentColor.GREEN));

		
		
		
	}
	
	
	
}