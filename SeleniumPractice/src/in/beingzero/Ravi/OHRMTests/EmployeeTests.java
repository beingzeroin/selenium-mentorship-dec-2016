package in.beingzero.Ravi.OHRMTests;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTests {
	WebDriver browser;

	@BeforeMethod
	public void logInSetUp() {
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.findElement(By.id("txtUsername")).sendKeys("Admin");
		browser.findElement(By.id("txtPassword")).sendKeys("admin");
		browser.findElement(By.id("btnLogin")).click();
		String wlcmsg = browser.findElement(By.id("welcome")).getText();
		System.out.println(wlcmsg);
		Assert.assertTrue(wlcmsg.contains("Welcome Admin"));
	}

	@AfterMethod
	public void cleanUp() {
		browser.quit();
	}

	// @Test
	void addEmployeeTest() {
		browser.findElement(By.id("menu_pim_viewPimModule")).click();
		browser.findElement(By.name("btnAdd")).click();
		System.out.println("Currently on URL: " + browser.getCurrentUrl());
		browser.findElement(By.id("firstName")).sendKeys("RDTest7");
		browser.findElement(By.id("middleName")).sendKeys("RDTest8");
		browser.findElement(By.id("lastName")).sendKeys("RDTest9");
		String empid = browser.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println(empid);
		browser.findElement(By.id("chkLogin")).click();
		browser.findElement(By.id("user_name")).sendKeys("RDTest7");
		browser.findElement(By.id("user_password")).sendKeys("test");
		browser.findElement(By.id("re_password")).sendKeys("test");
		WebElement st = browser.findElement(By.id("status"));
		Select stts = new Select(st);
		String sttselect = stts.getFirstSelectedOption().getText();
		if (!sttselect.equals("Enabled")) {
			System.out.println("Enable status");
		}
		browser.findElement(By.id("btnSave")).click();
		Assert.assertTrue(
				browser.findElement(By.id("personal_txtEmpFirstName")).getAttribute("Value").equals("RDTest7"));
		Assert.assertTrue(
				browser.findElement(By.id("personal_txtEmpMiddleName")).getAttribute("Value").equals("RDTest8"));
		Assert.assertTrue(
				browser.findElement(By.id("personal_txtEmpLastName")).getAttribute("Value").equals("RDTest9"));
		Assert.assertTrue(browser.findElement(By.id("personal_txtEmployeeId")).getAttribute("Value").equals(empid));
	}

	// @Test
	void editEmployeeDOBTest() {
		String empid = "0001";
		browser.findElement(By.id("menu_pim_viewPimModule")).click();
		browser.findElement(By.id("menu_pim_viewEmployeeList")).click();
		System.out.println(browser.getCurrentUrl());
		browser.findElement(By.id("empsearch_id")).sendKeys(empid);
		browser.findElement(By.id("searchBtn")).click();
		browser.findElement(By.linkText(empid)).click();
		;
		browser.findElement(By.id("btnSave")).click();
		browser.findElement(By.id("personal_DOB")).click();
		Select month = new Select(browser.findElement(By.className("ui-datepicker-month")));
		month.selectByVisibleText("Dec");
		Select year = new Select(browser.findElement(By.className("ui-datepicker-year")));
		year.selectByVisibleText("1998");
		WebElement day = browser.findElement(By.className("ui-datepicker-calendar"));
		day.findElement(By.linkText("5")).click();
		browser.findElement(By.id("btnSave")).click();
		WebDriverWait wdv = new WebDriverWait(browser, 30);
		WebElement savedSuccessMsgWE = wdv.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message success fadable']")));
		System.out.println("Found Success Message");
		System.out.println(savedSuccessMsgWE.getText());
		wdv.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='message success fadable']")));
		System.out.println(browser.findElement(By.id("personal_DOB")).getAttribute("value"));
	}

	// @Test
	void uploadEmployeeImage() {
		String empid = "0005";
		String profilePicPath = System.getProperty("user.dir")
				.concat("C:/Users/Public/Pictures/Sample Pictures/Koala.jpg");
		browser.findElement(By.id("menu_pim_viewPimModule")).click();
		browser.findElement(By.id("menu_pim_viewEmployeeList")).click();
		System.out.println(browser.getCurrentUrl());
		browser.findElement(By.id("empsearch_id")).sendKeys(empid);
		browser.findElement(By.id("searchBtn")).click();
		browser.findElement(By.linkText("Thomas")).click();
		browser.findElement(By.id("btnSave")).click();
		browser.findElement(By.id("empPic")).click();
		browser.findElement(By.id("photofile")).click();
		browser.findElement(By.id("photofile")).sendKeys(profilePicPath);
		browser.findElement(By.id("btnSave")).click();
	}

	// @Test
	void deleteEmployeeTest() {
		browser.findElement(By.id("menu_pim_viewPimModule")).click();
		browser.findElement(By.id("menu_pim_viewEmployeeList")).click();
		System.out.println(browser.getCurrentUrl());
		browser.findElement(By.id("searchBtn")).click();
		WebElement table = browser.findElement(By.id("resultTable"));
		WebElement talbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trvals = talbody.findElements(By.tagName("tr"));
		int rows = trvals.size();
		System.out.println("# of Rows: " + rows);
		WebElement secrow = trvals.get(1);
		WebElement chkbox = secrow.findElements(By.tagName("td")).get(0);
		chkbox.click();
		browser.findElement(By.id("btnDelete")).click();
		browser.findElement(By.id("dialogDeleteBtn")).click();
		WebDriverWait wdv = new WebDriverWait(browser, 30);
		WebElement deleteSuccessWE = wdv.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message success fadable']")));
		System.out.println("Found Success Message");
		System.out.println(deleteSuccessWE.getText());
		wdv.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='message success fadable']")));
		table = browser.findElement(By.id("resultTable"));
		talbody = table.findElement(By.tagName("tbody"));
		String noRecord = talbody.getText();
		System.out.println(noRecord);

	}

	@Test
	void downloadEmpImportFile() throws Exception {
		WebElement tabPIM = browser.findElement(By.linkText("PIM"));
		tabPIM.click();

		// 7.�� Hover mouse over Configuration SubMenu and Click Data Import

		WebElement subMenuConfiguration = browser.findElement(By.id("menu_pim_Configuration"));

		Actions action = new Actions(browser);

		action.moveToElement(subMenuConfiguration).build().perform();

		browser.findElement(By.linkText("Data Import")).click();

		// 8.�� Click Download Link on CSV Data Import Page
		// 9. Verify that file has been downloaded to the computer.

		// Click to download

		browser.findElement(By.linkText("Download")).click();
		Thread.sleep(1000);

		// Verify file download
		String downloadPath = "C:/Users/Public/Pictures/Sample Pictures";
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals("importData.csv"))
				System.out.println("File downloaded successfully");
		}

		// 10. Click upload to upload the same file again.
		// 11. Quit the browser

		WebElement browseFile = browser.findElement(By.id("pimCsvImport_csvFile"));
		Thread.sleep(1000);
		browseFile.sendKeys("C:/Users/Public/Pictures/Sample Pictures/importData.csv");
		Thread.sleep(1000);

		WebElement uploadClick = browser.findElement(By.id("btnSave"));
		uploadClick.click();

	}

}
