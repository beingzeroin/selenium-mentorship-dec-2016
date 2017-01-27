package in.beingzero.tests.priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.priya.IConfigManager;
import in.beingzero.framework.config.priya.readFramworkConfigFile;


public class LoginTests {

	WebDriver driver = null;
	readFramworkConfigFile cm = new readFramworkConfigFile();
	System.out.println(System.getProperty("user.dir"));
	
	public void readFramworkConfigFile()
	{
		
	}
	@BeforeMethod
	public void setup()
	{
		// Do setup based on Configuration Manager
			
		// Launching Browser
		
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
		driver.close();
		driver.quit();
	}
	
	@Test
	public void validLoginTest()
	{
		driver.findElement(By.id(cm.getUsrNmeTxt())).sendKeys(cm.getUserName());
		driver.findElement(By.id(cm.getPwd())).sendKeys(cm.getPwdTxt());
		driver.findElement(By.id(cm.getLgnBtn())).click();
		driver.findElement(By.xpath(cm.getLogOutBtn())).click();
	}
}
