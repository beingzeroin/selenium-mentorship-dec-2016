package in.beingzero.framework.POM.sandeep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BasePage {
	protected WebDriver driver;
	
	public BasePage(){
		driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		// Max, timtouts
	}
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
}
