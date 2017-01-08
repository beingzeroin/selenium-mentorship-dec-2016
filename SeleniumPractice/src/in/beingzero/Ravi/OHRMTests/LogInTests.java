package in.beingzero.Ravi.OHRMTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LogInTests {
	WebDriver browser;

	@BeforeClass
	public void logInSetUp() {
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
	}

	@AfterClass
	public void cleanUp() {
		browser.quit();
	}

	@Test
	public void vUserAndvPwd() {
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		String wlcmsg = browser.findElement(By.id("welcome")).getText();
		Assert.assertTrue(wlcmsg.contains("Welcome Admin"));		
	}
	
	@Test
	public void invUserVpwd(){
		browser.findElement(By.id("txtUsername")).sendKeys("Admin123");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		String msg = browser.findElement(By.id("spanMessage")).getText();
		Assert.assertTrue(msg.contains("Invalid credentials"));
	}
	
	@Test
	public void blankUserValidPwd(){
		browser.findElement(By.id("txtUsername")).sendKeys("");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		String msg = browser.findElement(By.id("spanMessage")).getText();
		Assert.assertTrue(msg.contains("Username cannot be empty"));
	}
	
	@Test
	public void vUserBlankPwd(){
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("");
		browser.findElement(By.id("btnLogin")).click();
		String msg = browser.findElement(By.id("spanMessage")).getText();
		Assert.assertTrue(msg.contains("Password cannot be empty"));
	}
}
