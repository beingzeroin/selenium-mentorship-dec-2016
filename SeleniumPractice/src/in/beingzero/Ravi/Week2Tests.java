package in.beingzero.Ravi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Week2Tests {
		//public void verifyAboutCompanyNameContainsOrangeHRM() {

	//}

	
	public void verifyLogoutWorks() {
		System.out.println("Test - Log in with Valid Credentials");

		WebDriver browser = new FirefoxDriver();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// browser.close();
		// String handle = browser.getWindowHandle();
		WebElement username = browser.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");

		WebElement password = browser.findElement(By.id("txtPassword"));
		password.sendKeys("admin");

		WebElement login = browser.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = browser.findElement(By.id("welcome"));
		wlcm.click();
		WebElement logout = browser.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a"));
		logout.click();
	}
	}
