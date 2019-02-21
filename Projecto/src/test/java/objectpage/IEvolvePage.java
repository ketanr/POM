package objectpage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ScreenShots;
public class IEvolvePage extends ScreenShots{

private WebDriver driver;

private By UMax_Logo = By.xpath("//*[@id=\"newPortal\"]/div[2]/div/div[2]/div[3]/div[1]/img");
private By searchBox = By.id("es_search");
private By searchBTN = By.id("appQuerySubmit");
private By employeeName = By.xpath("//*[@id=\"resultsTable\"]/table/tbody/tr[4]/td/table[2]/tbody/tr[1]/td/div/div/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/div/div/div[1]/a/span");
private By ievolvelogo = By.id("search");	
private By courseSearchBTN = By.id("searchIcon");
private By courseName = By.linkText("Java Solutions");

public IEvolvePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getMainPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifyMainPageTitle() {
		String expectedTitle = "Ultimatix: Digitally Connected";
		return getMainPageTitle().contains(expectedTitle);
	}
	
	public boolean verifyUltimatixLogo() {
		WebElement element = driver.findElement(UMax_Logo);
		if (element.isDisplayed()||element.isEnabled())
			{
			return true;}
		else return false;
	}
	
	public synchronized boolean verifyCourseSearch() {
		
		  
		WebElement courseSearchbox= driver.findElement(ievolvelogo);
		WebElement courseSearchbtn= driver.findElement(courseSearchBTN);
		
		
	    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	    
		System.out.println("Old "+driver.getWindowHandle());
	    courseSearchbox.sendKeys("Java Solutions");
	    
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		courseSearchbtn.click();
		
		WebElement course = driver.findElement(courseName);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    
	    // change focus to new tab
	    
		
	    System.out.println("New "+driver.getWindowHandle());
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		WebDriverWait wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(course));
		
		System.out.println(course.getText());
		if(course.isDisplayed())
		{
			driver.close();
			driver.switchTo().window(newTab.get(0));
			return true;
		}
		else
			driver.close();
		    driver.switchTo().window(newTab.get(0));
		return false;
	}
		
	public boolean verifySearchEmployee() {
			
		    WebElement searchbox= driver.findElement(searchBox);
		    WebElement searchbtn= driver.findElement(searchBTN);
		    System.out.println("Old "+driver.getWindowHandle());
		    
		    searchbox.sendKeys("962196");
			searchbtn.click();
			
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		    
		    // change focus to new tab
		    driver.switchTo().window(newTab.get(1));
			
		    System.out.println("New "+driver.getWindowHandle());
			WebElement employee= driver.findElement(employeeName);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);		
			if(employee.isDisplayed())
			{
				return true;
			}
			else
			
			return false;
		}
		
			
	
}