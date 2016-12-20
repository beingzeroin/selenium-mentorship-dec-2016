package in.beingzero.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginVerification {

	@Test
	//valid user name and password
	public void Test1() throws InterruptedException {

		FirefoxDriver fd = new FirefoxDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys("Admin");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		Thread.sleep(1000);

		String VerifyPageTitle = fd.findElement(By.xpath("//*[@id='welcome']")).getText();
		System.out.println(VerifyPageTitle);
		String ActualPageTitle = "Welcome Admin";

		if (VerifyPageTitle.equals(ActualPageTitle)) {
			System.out.println("Verification successful, test case PASS");
		} else {
			System.out.println("Verification failed, test case FAIL");

		}
		// fd.quit();
	}
	
	// Incorrect Password
	public void Test2() throws InterruptedException {

		FirefoxDriver fd = new FirefoxDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
	
		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys("Admin");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		Thread.sleep(1000);

		String VerifyPageTitle = fd.findElement(By.xpath(".//span[contains(text(),'Password cannot be empty')]"))
				.getText();
		System.out.println(VerifyPageTitle);
		String ActualPageTitle = "Password cannot be empty";

		if (VerifyPageTitle.equals(ActualPageTitle)) {
			System.out.println("Verification successful, test case PASS");
		} else {
			System.out.println("Verification failed, test case FAIL");

		}
		// fd.quit();
	}

	// Incorrect User name
	public void Test3() throws InterruptedException {
		FirefoxDriver fd = new FirefoxDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
		
		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys("");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys("admin");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		Thread.sleep(1000);

		String VerifyPageTitle = fd.findElement(By.xpath("//span[contains(text(),'Username cannot be empty')]"))
				.getText();
		System.out.println(VerifyPageTitle);
		String ActualPageTitle = "Username cannot be empty";

		if (VerifyPageTitle.equals(ActualPageTitle)) {
			System.out.println("Verification successful, test case PASS");
		} else {
			System.out.println("Verification failed, test case FAIL");

		}
		// fd.quit();
	}

	// Incorrect User name and Password
	public void Test4() throws InterruptedException {
		FirefoxDriver fd = new FirefoxDriver();

		fd.get("http://opensource.demo.orangehrmlive.com");
	
		WebElement Username = fd.findElement(By.id("txtUsername"));
		Username.sendKeys(" ");

		WebElement Password = fd.findElement(By.id("txtPassword"));
		Password.sendKeys(" ");

		WebElement Login = fd.findElement(By.id("btnLogin"));
		Login.click();
		Thread.sleep(1000);

		String VerifyPageTitle = fd.findElement(By.xpath("//span[contains(text(),'Invalid credentials')]")).getText();
		System.out.println(VerifyPageTitle);
		String ActualPageTitle = "Invalid credentials";

		if (VerifyPageTitle.equals(ActualPageTitle)) {
			System.out.println("Verification successful, test case PASS");
		} else {
			System.out.println("Verification failed, test case FAIL");

		}
		// fd.quit();
	}
}
