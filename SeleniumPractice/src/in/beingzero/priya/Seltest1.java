package in.beingzero.priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seltest1 {
	
	public static void main(String[] args)
	
	{
		
	WebDriver driver = new FirefoxDriver();
	
	driver.get("http://opensource.demo.orangehrmlive.com");
	WebElement UserId = driver.findElement(By.id("txtUsername"));
	UserId.clear();
	UserId.sendKeys("Admin");
	
	WebElement Password = driver.findElement(By.id("txtPassword"));
	Password.clear();
	Password.sendKeys("admin");
	
	WebElement Login = driver.findElement(By.id("btnLogin"));
	Login.click();
	
	String Actuallogger = driver.findElement(By.xpath("//a[@class='Welcome Admin']/@href)")).getText();
	
	String Expectedlogger = "Welcome Admin";
	
	Assert.assertEquals(Expectedlogger, Actuallogger);
	System.out.println("Successfully login into OrangeHRM by Admin");
	driver.close();
	
	
	
	}

}
