package in.beingzero.priya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCommands {

	public static void main(String[] args) throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		
		Navigation navigator = driver.navigate();
		
		navigator.to("http://google.com");
		Thread.sleep(2000);
		
		navigator.to("http://yahoo.com");
		Thread.sleep(2000);
		
		navigator.to("http://microsoft.com");
		Thread.sleep(2000);
		
		navigator.back();
		Thread.sleep(2000);
		
		navigator.forward();
		Thread.sleep(2000);
		
		String currenturl = driver.getCurrentUrl();
		String titleofcurrentpage = driver.getTitle();
		
		System.out.println("Current URL : " + currenturl);
		System.out.println("Current page Title is : " + titleofcurrentpage);
		
		driver.quit();
		
	}

}
