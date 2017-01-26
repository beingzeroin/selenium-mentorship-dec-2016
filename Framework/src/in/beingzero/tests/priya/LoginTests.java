package in.beingzero.tests.priya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.priya.ConfigManager;
import in.beingzero.framework.config.priya.IConfigManager;


public class LoginTests {

	@BeforeMethod
	public void setup()
	{
		// Do setup based on Configuration Manager
		
		WebDriver driver = null;
		
		// Launching Browser
		ConfigManager cm = new ConfigManager();
		String b = cm.getBrowser();
		if(b.equals("chrome"))
		    driver = new ChromeDriver();
		else if(b.equals("fireFox"))
			driver = new FirefoxDriver();
		else if(b.equals("IE"))
			driver = new InternetExplorerDriver();
		
		// URL to open
		String opnUrl = cm.getUrl();
		driver.get(opnUrl);
		
		// Full Screen
		String max = cm.getFullScreen();
		if(max.equals("true"))
			driver.manage().window().maximize();
		
		//Imp Wait
		String tmeout = cm.getImpWait();
		long timeout = Long.parseLong(tmeout);
		driver.manage().timeouts().implicitlyWait(timeout, null);
		

		
	}
	
	@AfterMethod
	public void cleanup()
	{
		
	}
	
	@Test
	public void validLoginTest()
	{
		
	}
}
