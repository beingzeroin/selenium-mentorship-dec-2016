package in.beingzero.Ravi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogOutAboutCompany {
	public void verifyLogoutWorks(){
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		browser.findElement(By.id("welcome")).click();
		WebDriverWait wait = new WebDriverWait(browser, 2);
		WebElement logoutLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
		logoutLink.click();
		String lnktext = browser.findElement(By.linkText("OrangeHRM, Inc")).getText();
		System.out.println(lnktext);
		Assert.assertTrue(lnktext.contains("Orange"));
		browser.quit();
	}
    public void verifyAboutCompanyNameContainsOrangeHRM(){
    	WebDriver browser = new ChromeDriver();
    	browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		browser.findElement(By.id("welcome")).click();
		browser.findElement(By.id("aboutDisplayLink")).click();
		String abttext = browser.findElement(By.xpath("//*[@id='companyInfo']/ul/li[1]/p")).getText();
		Assert.assertTrue(abttext.contains("Company Name: OrangeHRM (Pvt) Ltd"));
		System.out.println(abttext);
		browser.quit();
    }
	public static void main(String[] args) {
		//TODO:  RAVI.  This is a Compilation error, Class has been removed.  FIX IT.
		LogOutAboutCompany run = new LogOutAboutCompany();
		run.verifyLogoutWorks();
		run.verifyAboutCompanyNameContainsOrangeHRM();
	}

}
