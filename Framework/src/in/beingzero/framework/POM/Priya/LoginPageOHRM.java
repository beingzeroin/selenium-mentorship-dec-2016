package in.beingzero.framework.POM.Priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageOHRM extends BasePage{

	WebElement UserId;
	WebElement PassWord;
	WebElement LoginBtn;
	
	public LoginPageOHRM()
	{
		// Inheritance by default will call constructor of superclass so if we comment it out then also it will work. 
		//super();
	}
	public LoginPageOHRM(WebDriver wd)
	{
		driver = wd;
	}
	
	public DashBoardPageOHRM validLogin(String UName, String Pwd)
	{
		UserId = driver.findElement(By.id("txtUsername"));
		PassWord = driver.findElement(By.id("txtPassword"));
		LoginBtn = driver.findElement(By.id("btnLogin"));
		UserId.sendKeys(UName);
		PassWord.sendKeys(Pwd);
		LoginBtn.click();
		return new DashBoardPageOHRM(driver);
	}
}
