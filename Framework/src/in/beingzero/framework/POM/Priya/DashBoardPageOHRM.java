package in.beingzero.framework.POM.Priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPageOHRM {
	WebDriver driver;
	WebElement Actualtxt;
	
	public DashBoardPageOHRM(WebDriver driver)
	{
		Actualtxt = driver.findElement(By.id("welcome"));
	}
	public void validateValidUser(String UName,String Pwd)
	{
		String Actuallogger = Actualtxt.getText();
		String Expectedlogger = "Welcome Admin";
	
		//Verify Welcome is displayed
		if(Actuallogger.equals(Expectedlogger))
		{
			System.out.println("Login succeeded for User: "+UName);
			
		}
		else
		{
			System.out.println("Login Failed for User: "+Pwd);
			
		}
	
	}
}
