package in.beingzero.prudhvi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NavigatorCommands {
	
	@Test
	public void Navigation()
	{
		//FirefoxDriver driver=new FirefoxDriver();
		ChromeDriver driver=new ChromeDriver();
		Navigation navigator=driver.navigate();
		navigator.to(" http://google.com");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		navigator.to("http://yahoo.com");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		navigator.to("http://microsoft.com ");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}
	@Test
	public void FindSourcePageLength()
	{
		
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumProject\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://beingzero.in/our-team");
		System.out.println("Current page title is: "+driver.getTitle());
		System.out.println("Current page URL is: "+driver.getCurrentUrl());
		System.out.println("No. of characters in source page: "+driver.getPageSource().length());
		driver.close();
	}

}
