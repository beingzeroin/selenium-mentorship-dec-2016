package in.beingzero.framework.POM.Priya;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasePage {
	
	protected WebDriver driver;
	
	// If Test Wants to open page in new browser this constructor has been called
	public BasePage()
	{	
		//DriverManager.getDriver();
		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	// This constructor has been called if same browser instance wants to use 
	// it means new page will be opened in the same browser window instead of getting opened in new window.
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}

}
