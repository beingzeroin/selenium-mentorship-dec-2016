package in.beingzero.framework.POM.Priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MentorPickLogin extends MentorPickSetup{

	public MentorPickLogin()
	{
		// Inheritance by default will call constructor of superclass so if we comment it out then also it will work. 
		//super();
	}
	public MentorPickLogin(WebDriver driver)
	{
		super(driver);
	}
	
	public MentorPickDashBoardPage validLogin() {
		
		driver.findElement(By.xpath(objConfig.getProperty("LogIn"))).click();
		driver.findElement(By.xpath(objConfig.getProperty("LgnWGgle"))).click();
		driver.navigate().to(objConfig.getProperty("GgleAuthUrl"));
		driver.findElement(By.id(objConfig.getProperty("UsrEmail"))).sendKeys(objConfig.getProperty("userEmail"));
		driver.findElement(By.id(objConfig.getProperty("NxtBtn"))).click();
		driver.findElement(By.id(objConfig.getProperty("PwdTxt"))).sendKeys(objConfig.getProperty("pwd"));
		driver.findElement(By.id(objConfig.getProperty("SignInBtn"))).click();
		driver.navigate().to(objConfig.getProperty("DashBoardUrl"));
		
		//if(driver.findElement(By.xpath(objConfig.getProperty("DshBrdLogin"))).isDisplayed())
			
		return new MentorPickDashBoardPage(driver);
		
		
	}
}
