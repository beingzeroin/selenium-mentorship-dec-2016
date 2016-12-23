package in.beingzero.Ravi;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import javafx.scene.control.Alert;

public class LogInOhrm {

	// Test One - Log in with Valid UserName and PassWord

	public void VuserAndVpwd() {
		System.out.println("Test - Log in with Valid Credentials");

		WebDriver browser = new ChromeDriver();
		browser.get("http://opensource.demo.orangehrmlive.com");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// browser.close();
		//String handle = browser.getWindowHandle();
		WebElement username = browser.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");

		WebElement password = browser.findElement(By.id("txtPassword"));
		password.clear();
		password.sendKeys("admin");

		// org.openqa.selenium.Alert alert = browser.switchTo().alert();
		// ((org.openqa.selenium.Alert) alert).dismiss();

		// browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// browser.switchTo().window("handle");

		WebElement login = browser.findElement(By.id("btnLogin"));
		login.click();
		WebElement wlcm = browser.findElement(By.id("welcome"));
		String Message = wlcm.getText();
		System.out.println(Message);

	}

}
