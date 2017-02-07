package in.beingzero.framework.POM.Priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPageOHRM {

	WebDriver driver;
	WebElement UserId;
	WebElement PassWord;
	WebElement LoginBtn;
	
	public LoginPageOHRM(WebDriver driver)
	{
		//this.driver = driver;
		UserId = driver.findElement(By.id("txtUsername"));
		PassWord = driver.findElement(By.id("txtPassword"));
		LoginBtn = driver.findElement(By.id("btnLogin"));
	}
	
	public DashBoardPageOHRM loginWithValidUser(String UName, String Pwd)
	{
		UserId.sendKeys(UName);
		PassWord.sendKeys(Pwd);
		LoginBtn.click();
		return new DashBoardPageOHRM(driver);
	}
}
