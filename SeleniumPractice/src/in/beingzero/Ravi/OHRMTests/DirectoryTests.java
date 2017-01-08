package in.beingzero.Ravi.OHRMTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DirectoryTests {
	WebDriver browser;
	
	@BeforeTest
	public void logInSetUp() {
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
	}
	
	@AfterTest
	public void cleanUp() {
		browser.quit();
	}
	
	@Test
	public void directoryFilterTests(){
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		browser.findElement(By.id("menu_directory_viewDirectory")).click();
		WebElement nm = browser.findElement(By.id("searchDirectory_emp_name_empName"));
		WebElement jt = browser.findElement(By.id("searchDirectory_job_title"));
		Select sjt = new Select(jt);
		WebElement lct = browser.findElement(By.id("searchDirectory_location"));
		Select slct = new Select(lct);
		System.out.println("Default Filter Values");
		System.out.println(
				"Name: " + nm.getAttribute("value") + "\n" + "Job Title: " + sjt.getFirstSelectedOption().getText()
						+ "\n" + "Location: " + slct.getFirstSelectedOption().getText());
		nm.sendKeys("Linda Anderson");
		sjt.selectByVisibleText("CEO");
		slct.selectByValue("3,1,2,-1");
		System.out.println("Selected Filter Values");
		System.out.println(
				"Name: " + nm.getAttribute("value") + "\n" + "Job Title: " + sjt.getFirstSelectedOption().getText()
						+ "\n" + "Location: " + slct.getFirstSelectedOption().getText());
		browser.findElement(By.id("searchBtn")).click();
		browser.findElement(By.id("resetBtn")).click();
		System.out.println("After Reset");
		System.out.println(
				"Name: " + nm.getAttribute("value") + "\n" + "Job Title: " + sjt.getFirstSelectedOption().getText()
						+ "\n" + "Location: " + slct.getFirstSelectedOption().getText());		
		}
	}
			
	