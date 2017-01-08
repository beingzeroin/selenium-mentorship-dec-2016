package in.beingzero.Ravi.OHRMTests;

import java.util.List;
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
		WebElement wlcm = browser.findElement(By.id("welcome"));
		System.out.println(wlcm.getText());
		WebElement directory = browser.findElement(By.id("menu_directory_viewDirectory"));
		directory.click();
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
		// Thread.sleep(10000);
		// TODO:  SANDEEP ToDebug
		System.out.println("Job Title: " +
				sjt.getFirstSelectedOption().getText() + "\n" + "Location: "+
				slct.getFirstSelectedOption().getText());
	}
		
	
	//@Test
	public void verifyResultSet(){
		System.out.println("Currently on " + ch.getTitle());
		WebElement username = browser.findElement(By.id("txtUsername"));
		username.clear();
		username.sendKeys("Admin");
		WebElement password = browser.findElement(By.id("txtPassword"));
		password.clear();
		password.sendKeys("admin");
		WebElement login = browser.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = browser.findElement(By.id("welcome"));
		System.out.println(wlcm.getText());
		WebElement directory = browser.findElement(By.id("menu_directory_viewDirectory"));
		directory.click();
		WebElement username = browser.findElement(By.id("txtUsername"));
		username.clear();
		username.sendKeys("Admin");
		WebElement password = browser.findElement(By.id("txtPassword"));
		password.clear();
		password.sendKeys("admin");
		WebElement login = browser.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = browser.findElement(By.id("welcome"));
		System.out.println(wlcm.getText());
		WebElement directory = browser.findElement(By.id("menu_directory_viewDirectory"));
		directory.click();
		WebElement username = browser.findElement(By.id("txtUsername"));
		username.clear();
		username.sendKeys("Admin");
		WebElement password = browser.findElement(By.id("txtPassword"));
		password.clear();
		password.sendKeys("admin");
		WebElement login = browser.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = browser.findElement(By.id("welcome"));
		System.out.println(wlcm.getText());
		WebElement directory = browser.findElement(By.id("menu_directory_viewDirectory"));
		directory.click();
		WebElement jt = browser.findElement(By.id("searchDirectory_job_title"));
		Select sjt = new Select(jt);
		sjt.selectByVisibleText("CEO");
		browser.findElement(By.id("searchBtn")).click();
		WebElement table = browser.findElement(By.id("resultTable"));
		WebElement talbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trvals = talbody.findElements(By.tagName("tr"));
		int rows = trvals.size() - 1;
		System.out.println("# of Rows: " + rows);
		WebElement firstrow = trvals.get(1);
		List<WebElement> tdvals = firstrow.findElements(By.tagName("td"));
		System.out.println("# of columns: " + tdvals.size());

		boolean result = true;
		// Print table data
		for (int i = 1; i < trvals.size(); i++) {
			String rowText = trvals.get(i).getText();
			if(!rowText.contains("CEO")){
				result = false;
				break;
			}
			