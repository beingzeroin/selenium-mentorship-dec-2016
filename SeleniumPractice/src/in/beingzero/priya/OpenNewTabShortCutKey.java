package in.beingzero.priya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenNewTabShortCutKey {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL,"t");
		driver.navigate().to("http://beingzero.in/");
	}

}
