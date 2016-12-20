package in.beingzero.Ravi;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInOhrm {

	// Test One - Log in with Valid UserName and PassWord
	public void VuserAndVpwd() {
		System.out.println("Test - Log in with Valid Credentials");
		FirefoxDriver browser = new FirefoxDriver();
		browser.get("http://opensource.demo.orangehrmlive.com");

	}
}
