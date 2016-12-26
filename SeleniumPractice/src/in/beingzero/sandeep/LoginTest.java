package in.beingzero.sandeep;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginTest {

	// Test Case 1
	@Test
	public void validUserNameAndPasswordLogin() {
		
		BrowserManager bm = new BrowserManager();
		
		
		// Creational Design Pattern
		WebDriver fd = bm.createDriverObject();
		
		fd.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		
		WebElement we = fd.findElement(By.id("userName"));
		String pvalue = we.getAttribute("placeholder");
		
		List<WebElement> list =  fd.findElements(By.tagName("input"));
		
		// How do i know how many elements are there in list???
		int x = list.size();
		
		
		
		System.out.println("Running test1");
		// Open the browser

		// Go to site - http://opensource.demo.orangehrmlive.com

		// Enter username - admin

		// Enter password - admin

		// Click Login Button

		// Verify login succceed by verifying Welcome Admin should be ther on
		// topright
	}

	// Test Case 2
	@Test
	public void invalidUserNameAndPasswordLogin() {
		// Open the browser

		// Go to site - http://opensource.demo.orangehrmlive.com

		// Enter username - admin123

		// Enter password - admin

		// Click Login Button

		// Verify that we see "Invalid credentials" error message

	}

	// Test Case 3
	public void blankUserNameAndPasswordLogin() {
		// Open the browser

		// Go to site - http://opensource.demo.orangehrmlive.com

		// Leave username blank

		// Enter password - admin

		// Click Login Button

		// Verify that we see "Username can not be empty" error message

	}

	// Test Case 4
	public void userNameAndBlankPasswordLogin() {
		// Open the browser

		// Go to site - http://opensource.demo.orangehrmlive.com

		// Leave username blank

		// Enter password - admin

		// Click Login Button

		// Verify that we see "Username can not be empty" error message

	}

}
