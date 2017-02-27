package in.beingzero.framework.POM.Swetha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(){
		
		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}

}
