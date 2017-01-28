package in.beingzero.tests.swetha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.swetha.ConfigManager;

public class LoginTests extends ConfigManager {
		
	WebDriver wd;
	
	boolean logonStatus = false;
	
	String expectedLogonText = "Welcome Admin";
	String webUrl;
	
	
	@BeforeMethod
	public void setup() {
		
		//Read the browser
		String strDriver =  getProperty("browser");
		createDriverObject(strDriver);
		
		//Read the URL
		
		webUrl = getProperty("url");
		
		//Read and set the implicit timeout
		
		wd.manage().timeouts().implicitlyWait(getLongProperty("implicitTimeoutInSeconds"),TimeUnit.SECONDS);
		
		//To read and set the size of browser window.
		
		if(getBooleanProperty("runFullScreen")){
			wd.manage().window().maximize();
		}	
		
	}
	
	@Test
	public void logon() throws InterruptedException{
		
		//Open the URL
		
		wd.get(webUrl);
		
		WebElement userName = wd.findElement(By.id("txtUsername"));
		userName.sendKeys(getProperty("username"));

		WebElement passWord = wd.findElement(By.id("txtPassword"));
		passWord.sendKeys(getProperty("password"));

		WebElement login = wd.findElement(By.id("btnLogin"));
		login.click();
		
		String actualLogonText = wd.findElement(By.id("welcome")).getText();

		if (actualLogonText.equals(expectedLogonText)) {
			
			System.out.println("LOGON Successful");
			
			wd.findElement(By.id("welcome")).click();
			
			WebDriverWait wait = new WebDriverWait(wd,3000);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='welcome-menu']//a[contains(text(),'Logout')]")));
			
			Thread.sleep(1000);
			
			wd.findElement(By.xpath(".//div[@id='welcome-menu']//a[contains(text(),'Logout')]")).click();

			
		} else {
			
			System.out.println("LOGON Failed");

		}
		
	}
	
	
	@AfterMethod
	public void cleanup()
	{
		// Quit browser
		wd.quit();
	}
	
	public WebDriver createDriverObject(String driverType)
	{
		driverType = "chrome"; 
		
		if(driverType.equals("chrome"))
			wd = new ChromeDriver();
		else if(driverType.equals("ie"))
			wd = new InternetExplorerDriver();
		else
			wd = new FirefoxDriver();
		
		return wd;
		
	}

	
	

}
