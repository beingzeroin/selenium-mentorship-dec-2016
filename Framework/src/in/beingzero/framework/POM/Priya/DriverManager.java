package in.beingzero.framework.POM.Priya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverManager {
	
	static WebDriver driver;
	
	static WebDriver getDriver(){
		if(driver==null)
			driver = new ChromeDriver();
		return driver;
	}
}
