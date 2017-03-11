package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashBoardPage extends BasePage
{
	By welcomeLabel=By.id("welcome");
	By logOutButton=By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a");
	By PIMLink=By.id("menu_pim_viewPimModule");
	By AddEmployeeLink=By.id("menu_pim_addEmployee");
	
	
	WebElement PIM=getDriver().findElement(PIMLink);
	
	public DashBoardPage()
	{
		//BrowserManager objBM=new BrowserManager();
		//driver=objBM.launchBrowser();
	}
	
	
	public DashBoardPage(WebDriver driver) 
	{
		
		//this.driver=driver;
		super(driver);
	}

	public LoginPage logOutAction()
	{
		if(isLoginSuccessfull())
		{
			getDriver().findElement(welcomeLabel).click();
			getDriver().findElement(logOutButton).click();	
		}
		return new LoginPage(getDriver());
	}
	
	public boolean isLoginSuccessfull()
	{
		boolean isWelcomeLabelExists=false;
		if(getDriver().findElement(welcomeLabel).isDisplayed())
			isWelcomeLabelExists=true;
		return isWelcomeLabelExists;
	}

	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		String strLabelMessage="";
		WebElement objLabel=getDriver().findElement(welcomeLabel);
		if(objLabel.isDisplayed())
		{
			 strLabelMessage =objLabel.getText();
		}
			
		
		return strLabelMessage;
	}
	
	
	
	
}








