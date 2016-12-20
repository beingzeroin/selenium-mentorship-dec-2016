package in.beingzero.Ravi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInOhrm {

	// Test One - Log in with Valid UserName and PassWord
	public void VuserAndVpwd() {
		System.out.println("Test - Log in with Valid Credentials");
		WebDriver browser = new ChromeDriver();
		browser.get("http://opensource.demo.orangehrmlive.com");

	}
}
