package in.beingzero.tests.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.priya.readFramworkConfigFile;


public class LoginTests {
	
	WebDriver driver = null;
	readFramworkConfigFile cm;
	
	public LoginTests() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		// Launching Browser
		cm = new readFramworkConfigFile();
		System.out.println(System.getProperty("user.dir"));
		
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
			System.out.println("Window Maximized");
		
		//Imp Wait
		String tmeout = cm.getImpWait();
		long timeout = Long.parseLong(tmeout);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		System.out.println("Implicit wait applied");
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
		System.out.println("Username located");
		driver.findElement(By.id(cm.getPwdTxt())).sendKeys(cm.getPwd());
		System.out.println("pwd located");
		driver.findElement(By.id(cm.getLgnBtn())).click();
		System.out.println("login clicked");
		//System.out.println("Logout Xpath :"+By.xpath(cm.getLogOutBtn()));
		//driver.findElement(By.xpath(cm.getLogOutBtn())).click();
		//System.out.println("logout clicked");
	}
}
