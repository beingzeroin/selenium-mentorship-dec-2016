package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage
{
	By welcomeLabel=By.id("welcome");
	By logOutButton=By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a");
	
	
	
	
	public LoginPage logOutAction(WebDriver driver)
	{
		driver.findElement(welcomeLabel).click();
		driver.findElement(logOutButton).click();	
		LoginPage objLoginPage = null;
		return objLoginPage;
	}
	
	public boolean isLoginSuccessfull(WebDriver driver)
	{
		boolean isWelcomeLabelExists=false;
		if(driver.findElement(welcomeLabel).isDisplayed())
			isWelcomeLabelExists=true;
		return isWelcomeLabelExists;
	}
	
}
