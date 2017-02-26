package in.beingzero.Ravi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogInOhrm {
	public void vUserAndVpwd(){
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		String wlcmsg = browser.findElement(By.id("welcome")).getText();
		System.out.println(wlcmsg);
		Assert.assertTrue(wlcmsg.contains("Welcome Admin"));
		browser.quit();
	}
	public void invUserAndVpwd(){
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.findElement(By.id("txtUsername")).sendKeys("Admin123");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		String msg = browser.findElement(By.id("spanMessage")).getText();
		System.out.println(msg);
		Assert.assertTrue(msg.contains("Invalid credentials"));
		browser.quit();
	}
	public void blankUserVpwd(){
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.findElement(By.id("txtUsername")).sendKeys("");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		String msg = browser.findElement(By.id("spanMessage")).getText();
		System.out.println(msg);
		Assert.assertTrue(msg.contains("Username cannot be empty"));
		browser.quit();
	}
	public void vUserBlankPwd(){
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.findElement(By.id("txtUsername")).sendKeys("admin");
		browser.findElement(By.id("txtPassword")).sendKeys("");
		browser.findElement(By.id("btnLogin")).click();
		String msg = browser.findElement(By.id("spanMessage")).getText();
		System.out.println(msg);
		Assert.assertTrue(msg.contains("Password cannot be empty"));
		browser.quit();
	}

	public static void main(String[] args) {
		//TODO:  RAVI.  This is a Compilation error, Class has been removed.  FIX IT.
		LogInOhrm login = new LogInOhrm();
		//login.vUserAndVpwd();
		//login.invUserAndVpwd();
		//login.blankUserVpwd();
		login.vUserBlankPwd();
		}

}
