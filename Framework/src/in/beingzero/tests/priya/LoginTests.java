package in.beingzero.tests.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.priya.readFramworkConfigFile;
import junit.framework.Assert;


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
		if(doLoginSucceed())
		{
			System.out.println("Login Succeeded");
			driver.findElement(By.id(cm.getWelcomeTxt())).click();
			System.out.println("Welcome clicked");
			WebDriverWait wait = new WebDriverWait(driver, 2000); 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")));
			
			driver.findElement(By.xpath(cm.getLogOutBtn())).click();
			System.out.println("Logout clicked");
			driver.navigate().to(cm.getLogoutUrl());
			if(cm.getLogoutUrl().equals(driver.getCurrentUrl()))
				System.out.println("Logout is succeeded");
		}
		else
			System.out.println("Login Failed");
	}	
	
	public boolean doLoginSucceed()
	{
		boolean loginSrc = false;
		driver.findElement(By.id(cm.getUsrNmeTxt())).sendKeys(cm.getUserName());
		System.out.println("Username located");
		driver.findElement(By.id(cm.getPwdTxt())).sendKeys(cm.getPwd());
		System.out.println("pwd located");
		driver.findElement(By.id(cm.getLgnBtn())).click();
		System.out.println("login clicked");
				
		//System.out.println("Logout Xpath :"+By.xpath(cm.getLogOutBtn()));
		//driver.findElement(By.xpath(cm.getLogOutBtn())).click();
		//System.out.println("logout clicked");
		if(driver.findElement(By.id(cm.getWelcomeTxt())).isDisplayed())
			loginSrc = true;
		
		
		return loginSrc;
	}
	/*@Test(dependsOnMethods = {"validLoginTest"})
	public void logoutOhrm()
	{
		driver.findElement(By.id(cm.getWelcomeTxt())).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 2); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")));
		
		driver.findElement(By.xpath(cm.getLogOutBtn())).click();
		driver.navigate().to(cm.getLogoutUrl());
		if(cm.getLogoutUrl().equals(driver.getCurrentUrl()))
			System.out.println("Logout is succeeded");

	}*/

}
