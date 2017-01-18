package in.beingzero.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BeforeAfterTestNG {

	WebDriver driver;
	
	/*@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(@Optional("FF") String browser)
	{
		if(browser.equalsIgnoreCase("FF"))
		{
			System.out.println("In Firefox Browser");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("In Chrome browser");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else
		{
			System.out.println("In IE Browser");
			driver = new InternetExplorerDriver();
		}
	
	}*/
	
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println("In Chrome browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		if (driver != null)
		{
			driver.quit();
			driver = null;
		}
		
	}

}
