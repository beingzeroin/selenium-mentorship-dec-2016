package in.beingzero.sandeep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuiteApproach {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		// Launch browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Login
	}
	
	@AfterMethod
	public void cleanup()
	{
		// Quit browser
		driver.quit();
	}
	
	@Test
	public void loginTest()
	{	
		driver.findElement(By.id("asdfasdfasd"));
	}
	
}
