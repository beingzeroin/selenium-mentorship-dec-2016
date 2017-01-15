package in.beingzero.swetha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Week2AboutLogout {

	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		// Launch browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@AfterMethod
	public void cleanup()
	{
		// Quit browser
		driver.quit();
	}

	@Test
	public void verifyAboutCompanyNameContainsOrangeHRM() throws InterruptedException {
		
		driver.get("http://opensource.demo.orangehrmlive.com");
	
		WebElement Username = driver.findElement(By.id("txtUsername"));
		Username.sendKeys("Admin");

		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();

		WebElement Welcome = driver.findElement(By.id("welcome"));
		System.out.println(Welcome.isDisplayed());
		System.out.println(Welcome.isEnabled());
		Thread.sleep(1000);
		//Welcome.submit();
		Welcome.click();

		Thread.sleep(1000);

		WebElement Aboutlnk = driver.findElement(By.id("aboutDisplayLink"));
		Aboutlnk.click();

		if (driver.findElement(By.xpath(".//div[@id='displayAbout']//h3[contains(text(),'About')]"))
				.isDisplayed() == true) {

			WebElement AboutWindow = driver.findElement(
					By.xpath(".//div[@id='companyInfo']//p[contains(text(),'Company Name: OrangeHRM (Pvt) Ltd')]"));
			Thread.sleep(1000);
			String ActualName = AboutWindow.getText();
			System.out.println(ActualName);
			String ExpectedName = "Company Name: OrangeHRM (Pvt) Ltd";
			if (ActualName.equals(ExpectedName)) {
				System.out.println("Company Name verified");
			}
			WebElement CloseWindow = driver.findElement(By.xpath(".//div[@id='displayAbout']//a[@class='close']"));
			CloseWindow.click();
		}
	}

	@Test
	public void verifyLogoutWorks() throws InterruptedException {

		driver.get("http://opensource.demo.orangehrmlive.com");

		driver.manage().window().maximize();

		WebElement Username = driver.findElement(By.id("txtUsername"));
		Username.sendKeys("Admin");

		WebElement Password = driver.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = driver.findElement(By.id("btnLogin"));
		Login.click();

		Thread.sleep(1000);

		WebElement Welcome = driver.findElement(By.id("welcome"));
		Welcome.click();

		Thread.sleep(1000);

		WebElement Logout = driver.findElement(By.xpath(".//div[@id='welcome-menu']//a[contains(text(),'Logout')]"));
		Logout.click();
	}

}
