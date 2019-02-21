package objectpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UltimatixSignInPage{

private WebDriver driver;
private By TCS_Logo = By.id("tcs_logo");
private By UMax_Logo = By.xpath("//*[@id=\"newPortal\"]/div[2]/div/div[2]/div[3]/div[1]/img");
private By emailTextBox = By.id("USER");
private By passwordTextBox = By.id("PASSWORD");
private By loginBtn = By.id("login_button");
private By errorMsgTxt = By.id("errorLabel");
	
	public UltimatixSignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifySignInPageTitle() {
		String expectedTitle = "Ultimatix - Digitally Connected !";
		return getSignInPageTitle().contains(expectedTitle);
	}
	
	public boolean verifyTCSLogo() {
		WebElement element = driver.findElement(TCS_Logo);
		if (element.isDisplayed()||element.isEnabled())
			{
			return true;}
		else return false;
	}
		
	
	
		
		
	public boolean verifySignInError() {
			enterUserName("96675");
			enterPassword("pass");
			clickOnSignIn();
			
			return getErrorMessage().contains("incorrect");
		}
		
		
	public void enterUserName(String userName) {
			WebElement emailTxtBox = driver.findElement(emailTextBox);
			if(emailTxtBox.isDisplayed())
				emailTxtBox.sendKeys(userName);
		}
		
		
	public void enterPassword(String password) {
			WebElement passwordTxtBox = driver.findElement(passwordTextBox);
			if(passwordTxtBox.isDisplayed())
				passwordTxtBox.sendKeys(password);
		}
		
		
	public void clickOnSignIn() {
			WebElement signInBtn = driver.findElement(loginBtn);
			if(signInBtn.isDisplayed())
				signInBtn.click();
		}

	public boolean verifyValidSignIn()
	{
		enterUserName("Enter Employee id");
		enterPassword("Enter Password");
		clickOnSignIn(); 
		WebElement logo= driver.findElement(UMax_Logo);
		if(logo.isDisplayed())
			return true;
		else return false;
		
	}
	
	
	
	public boolean verifyBlankUserPopup()
	{
		
		enterUserName("");
		enterPassword("");
		clickOnSignIn();
		
        driver.switchTo().alert().accept();
		
		return true;
	}
		
		
	public String getErrorMessage() {
			String strErrorMsg = null;
			WebElement errorMsg = driver.findElement(errorMsgTxt);
			if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
				strErrorMsg = errorMsg.getText();
			return strErrorMsg;
		}
}