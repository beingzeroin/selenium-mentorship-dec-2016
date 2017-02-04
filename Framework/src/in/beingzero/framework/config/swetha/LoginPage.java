package in.beingzero.framework.config.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver wd;
	
	String expectedLogonText = "Welcome Admin";
	
	public DashboardPage loginWithValidUser(String usrname, String passwd){
		
		wd.get("http://opensource.demo.orangehrmlive.com/");
		
		WebElement userName = wd.findElement(By.id("txtUsername"));
		userName.sendKeys(usrname);

		WebElement passWord = wd.findElement(By.id("txtPassword"));
		passWord.sendKeys(passwd);

		WebElement login = wd.findElement(By.id("btnLogin"));
		login.click();
		
		return null;
		
		
		
	}
	
	public void validatePage(){
		
		String actualLogonText = wd.findElement(By.id("welcome")).getText();

		if (actualLogonText.equals(expectedLogonText)) {
			
			System.out.println("LOGON Successful");
			
		} else {
			
			System.out.println("LOGON Failed");
		}
	}


}
