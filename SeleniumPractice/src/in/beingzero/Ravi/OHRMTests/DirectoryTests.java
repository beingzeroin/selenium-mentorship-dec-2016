package in.beingzero.Ravi.OHRMTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DirectoryTests {
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
	public void directoryFilterTests() {
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
		// TODO: SANDEEP ToDebug
		/*System.out.println(
				"Name: " + nm.getAttribute("value") + "\n" + "Job Title: " + sjt.getFirstSelectedOption().getText()
						+ "\n" + "Location: " + slct.getFirstSelectedOption().getText());*/
	}

	@Test
	public void verifyResultSet() {
		System.out.println("Currently on " + browser.getTitle());
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		System.out.println(browser.findElement(By.id("welcome")).getText());
		browser.findElement(By.id("menu_directory_viewDirectory")).click();
		Select jt = new Select(browser.findElement(By.id("searchDirectory_job_title")));
		jt.selectByVisibleText("CEO");
		browser.findElement(By.id("searchBtn")).click();
		WebElement table = browser.findElement(By.id("resultTable"));
		WebElement talbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trvals = talbody.findElements(By.tagName("tr"));
		int rows = trvals.size() - 1;
		System.out.println("# of rows: " + rows);
		WebElement firstrow = trvals.get(1);
		List<WebElement> tdvals = firstrow.findElements(By.tagName("td"));
		System.out.println("# of columns: " + tdvals.size());
		boolean result = true;
		for (int i = 1; i < trvals.size(); i++) {
			String rowText = trvals.get(i).getText();
			if (!rowText.contains("CEO")) {
				result = false;
				break;
			}
		System.out.println(result);
		}
	}
}
