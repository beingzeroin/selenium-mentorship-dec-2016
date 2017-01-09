package in.beingzero.Ravi.OHRMTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutAndLogOut {
	WebDriver browser;
	
	@BeforeMethod
	public void logInSetUp() {
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
	}
	
	@AfterMethod
	public void cleanUp() {
		browser.quit();
	}
	
	@Test
	public void verifyAboutCompanyNameContainsOrangeHRM(){
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		browser.findElement(By.id("welcome")).click();
		browser.findElement(By.id("aboutDisplayLink")).click();
		String abttext = browser.findElement(By.xpath("//*[@id='companyInfo']/ul/li[1]/p")).getText();
		Assert.assertTrue(abttext.contains("Company Name: OrangeHRM (Pvt) Ltd"));
		System.out.println(abttext);
	}
	
	@Test
	public void verifyLogoutWorks(){
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		browser.findElement(By.id("welcome")).click();
		WebDriverWait wait = new WebDriverWait(browser, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")));
		browser.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		String lnktext = browser.findElement(By.linkText("OrangeHRM, Inc")).getText();
		System.out.println(lnktext);
		Assert.assertTrue(lnktext.contains("Orange"));
	}

}
