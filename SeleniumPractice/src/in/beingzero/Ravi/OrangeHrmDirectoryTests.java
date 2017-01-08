package in.beingzero.Ravi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHrmDirectoryTests {
	public void searchOptionsDirectory() {
		WebDriver ch = new ChromeDriver();
		ch.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ch.manage().window().maximize();
		ch.get("http://opensource.demo.orangehrmlive.com/");
		System.out.println("Currently on " + ch.getTitle());
		WebElement username = ch.findElement(By.id("txtUsername"));
		username.clear();
		username.sendKeys("Admin");
		WebElement password = ch.findElement(By.id("txtPassword"));
		password.clear();
		password.sendKeys("admin");
		WebElement login = ch.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = ch.findElement(By.id("welcome"));
		System.out.println(wlcm.getText());
		WebElement directory = ch.findElement(By.id("menu_directory_viewDirectory"));
		directory.click();
		// WebElement srchoptions = ch.findElement(By.id("tiptip_holder"));
		// System.out.println(srchoptions.getText());
		WebElement nm = ch.findElement(By.id("searchDirectory_emp_name_empName"));
		WebElement jt = ch.findElement(By.id("searchDirectory_job_title"));
		Select sjt = new Select(jt);
		WebElement lct = ch.findElement(By.id("searchDirectory_location"));
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
		ch.findElement(By.id("searchBtn")).click();
		ch.findElement(By.id("resetBtn")).click();
		System.out.println("After Reset");
		// Thread.sleep(10000);
		// System.out.println("Job Title: " +
		// sjt.getFirstSelectedOption().getText() + "\n" + "Location: "+
		// slct.getFirstSelectedOption().getText());
		ch.quit();
	}

	public void verifyResultSet() {
		WebDriver ch = new ChromeDriver();
		ch.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ch.manage().window().maximize();
		ch.get("http://opensource.demo.orangehrmlive.com/");
		System.out.println("Currently on " + ch.getTitle());
		WebElement username = ch.findElement(By.id("txtUsername"));
		username.clear();
		username.sendKeys("Admin");
		WebElement password = ch.findElement(By.id("txtPassword"));
		password.clear();
		password.sendKeys("admin");
		WebElement login = ch.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = ch.findElement(By.id("welcome"));
		System.out.println(wlcm.getText());
		WebElement directory = ch.findElement(By.id("menu_directory_viewDirectory"));
		directory.click();
		// WebElement srchoptions = ch.findElement(By.id("tiptip_holder"));
		// System.out.println(srchoptions.getText());
		WebElement jt = ch.findElement(By.id("searchDirectory_job_title"));
		Select sjt = new Select(jt);
		sjt.selectByVisibleText("CEO");
		ch.findElement(By.id("searchBtn")).click();
		WebElement table = ch.findElement(By.id("resultTable"));
		WebElement talbody = table.findElement(By.tagName("tbody"));
		List<WebElement> trvals = talbody.findElements(By.tagName("tr"));
		int rows = trvals.size() - 1;
		System.out.println("# of Rows: " + rows);
		WebElement firstrow = trvals.get(1);
		List<WebElement> tdvals = firstrow.findElements(By.tagName("td"));
		System.out.println("# of columns: " + tdvals.size());

		// Print table data
		for (int i = 1; i < trvals.size(); i++) {
			List<WebElement> tdlist = trvals.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < tdlist.size(); j++) {
				System.out.print(tdlist.get(j).getText() + " ");
			}
			System.out.println();
		}
		ch.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		OrangeHrmDirectoryTests runs = new OrangeHrmDirectoryTests();
		runs.searchOptionsDirectory();
		runs.verifyResultSet();
	}

}
