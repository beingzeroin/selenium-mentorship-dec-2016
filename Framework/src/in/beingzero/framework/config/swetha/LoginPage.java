package in.beingzero.framework.config.swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver wd;
	
	public void loginWithValidUser(String username, String password){
		
		wd.get("http://opensource.demo.orangehrmlive.com/");
		
		WebElement userName = wd.findElement(By.id("txtUsername"));
		userName.sendKeys("username");

		WebElement passWord = wd.findElement(By.id("txtPassword"));
		passWord.sendKeys("password");

		WebElement login = wd.findElement(By.id("btnLogin"));
		login.click();
		
		//return null;
		
	}
	
	public void validatePage(String actualText){
		
	}


}
