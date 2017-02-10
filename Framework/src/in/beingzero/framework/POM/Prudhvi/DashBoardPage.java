package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import in.beingzero.framework.config.Prudhvi.BrowserManager;

public class DashBoardPage
{
	By welcomeLabel=By.id("welcome");
	By logOutButton=By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a");
	WebDriver driver;
	
	public DashBoardPage()
	{
		BrowserManager objBM=new BrowserManager();
		driver=objBM.launchBrowser();
	}
	
	

	
	public DashBoardPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public LoginPage logOutAction()
	{
		if(isLoginSuccessfull())
		{
			driver.findElement(welcomeLabel).click();
			driver.findElement(logOutButton).click();	
		}
		return new LoginPage(driver);
	}
	
	public boolean isLoginSuccessfull()
	{
		boolean isWelcomeLabelExists=false;
		if(driver.findElement(welcomeLabel).isDisplayed())
			isWelcomeLabelExists=true;
		return isWelcomeLabelExists;
	}

	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		String strLabelMessage="";
		WebElement objLabel=driver.findElement(welcomeLabel);
		if(objLabel.isDisplayed())
		{
			 strLabelMessage =objLabel.getText();
		}
			
		
		return strLabelMessage;
	}
	
}
