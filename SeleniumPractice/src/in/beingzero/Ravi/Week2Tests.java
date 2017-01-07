package in.beingzero.Ravi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Week2Tests {
	public void verifyAboutCompanyNameContainsOrangeHRM() {
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
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
		WebElement wlcmtxt = browser.findElement(By.xpath("//*[@id='companyInfo']/ul/li[1]/p"));
		String wlcmabout = wlcmtxt.getText();
		System.out.println(wlcmabout);
		browser.quit();
	}

	public void verifyLogoutWorks() {
		System.out.println("Test - Log in with Valid Credentials");

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
		WebElement username = browser.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");

		WebElement password = browser.findElement(By.id("txtPassword"));
		password.sendKeys("admin");

		WebElement login = browser.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = browser.findElement(By.id("welcome"));
		wlcm.click();
		WebDriverWait wait = new WebDriverWait(browser, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")));
		WebElement logout = browser.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a"));
		logout.click();
		browser.quit();
	}
}
