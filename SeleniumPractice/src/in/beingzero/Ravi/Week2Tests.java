package in.beingzero.Ravi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Week2Tests {
	public void verifyAboutCompanyNameContainsOrangeHRM() {
		WebDriver browser = new ChromeDriver();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement username = browser.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");

		WebElement password = browser.findElement(By.id("txtPassword"));
		password.sendKeys("admin");

		WebElement login = browser.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = browser.findElement(By.id("welcome"));
		wlcm.click();
		WebElement about = browser.findElement(By.id("aboutDisplayLink"));
		about.click();
		//WebElement wlcmtxt = browser.findElement(By.xpath("//*[@id="companyInfo"]/ul/li[1]/p"));"
		//String wlcmabout = wlcmtxt.getText();
		//System.out.println(wlcmabout);
	}

	public void verifyLogoutWorks() {
		System.out.println("Test - Log in with Valid Credentials");

		WebDriver browser = new ChromeDriver();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		browser.quit();
	}
}
