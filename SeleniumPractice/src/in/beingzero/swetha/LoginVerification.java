package in.beingzero.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LoginVerification {

	public String URL = "http://opensource.demo.orangehrmlive.com";
	public String UserName = "";
	public String PassWord = "";
	public String ExpectedPageText = "";
	public String ActualPageText = "";
	public String ID1 = "txtUsername";
	public String ID2 = "txtPassword";
	public String ID3 = "btnLogin";

	// Constructor to pass the test credentials and expected value text

	public LoginVerification(String UserID, String Pass, String Expectedtext) {
		UserName = UserID;
		PassWord = Pass;
		ExpectedPageText = Expectedtext;
	}

	// valid user name and password
	@Test
	public void Test1() throws InterruptedException {

		FirefoxDriver fd = new FirefoxDriver();

		fd.get(URL);
		WebElement Username = fd.findElement(By.id(ID1));
	    Username.clear();
		Username.sendKeys(UserName);

		WebElement Password = fd.findElement(By.id(ID2));
		Password.sendKeys(PassWord);

		WebElement Login = fd.findElement(By.id(ID3));
		Login.click();
		Thread.sleep(1000);

		ActualPageText = fd.findElement(By.id("welcome")).getText();

		if (ActualPageText.equals(ExpectedPageText)) {
			System.out.println("Verification successful, test case1 PASS");
		} else {
			System.out.println("Verification failed, test case1 FAIL");

		}

	}

	// Incorrect Password
	public void Test2() throws InterruptedException {

		FirefoxDriver fd = new FirefoxDriver();

		fd.get(URL);

		WebElement Username = fd.findElement(By.id(ID1));
		Username.sendKeys(UserName);

		WebElement Password = fd.findElement(By.id(ID2));
		Password.sendKeys(PassWord);

		WebElement Login = fd.findElement(By.id(ID3));
		Login.click();
		Thread.sleep(1000);

		ActualPageText = fd.findElement(By.xpath(".//span[contains(text(),'Password cannot be empty')]")).getText();

		if (ActualPageText.equals(ExpectedPageText)) {
			System.out.println("Verification successful, test case2 PASS");
		} else {
			System.out.println("Verification failed, test case2 FAIL");

		}

	}

	// Incorrect User name
	public void Test3() throws InterruptedException {
		FirefoxDriver fd = new FirefoxDriver();

		fd.get(URL);

		WebElement Username = fd.findElement(By.id(ID1));
		Username.sendKeys(UserName);

		WebElement Password = fd.findElement(By.id(ID2));
		Password.sendKeys(PassWord);

		WebElement Login = fd.findElement(By.id(ID3));
		Login.click();
		Thread.sleep(1000);

		ActualPageText = fd.findElement(By.xpath("//span[contains(text(),'Username cannot be empty')]")).getText();

		if (ActualPageText.equals(ExpectedPageText)) {
			System.out.println("Verification successful, test case3 PASS");
		} else {
			System.out.println("Verification failed, test case3 FAIL");

		}

	}

	// Incorrect User name and Password
	public void Test4() throws InterruptedException {
		FirefoxDriver fd = new FirefoxDriver();

		fd.get(URL);

		WebElement Username = fd.findElement(By.id(ID1));
		Username.sendKeys(UserName);

		WebElement Password = fd.findElement(By.id(ID2));
		Password.sendKeys(PassWord);

		WebElement Login = fd.findElement(By.id(ID3));
		Login.click();
		Thread.sleep(1000);

		ActualPageText = fd.findElement(By.xpath("//span[contains(text(),'Invalid credentials')]")).getText();

		if (ActualPageText.equals(ExpectedPageText)) {
			System.out.println("Verification successful, test case4 PASS");
		} else {
			System.out.println("Verification failed, test case4 FAIL");

		}
	}
}
