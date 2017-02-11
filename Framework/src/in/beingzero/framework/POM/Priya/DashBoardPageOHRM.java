package in.beingzero.framework.POM.Priya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPageOHRM extends BasePage{
	
	String Expectedlogger = "Linda";
	WebElement Actualtxt;
	
	public DashBoardPageOHRM()
	{
		super();
	}
	
	public DashBoardPageOHRM(WebDriver driver)
	{
		super(driver);
	}
	
	public void validateValidUser(String UName,String Pwd)
	{
		Actualtxt = driver.findElement(By.id("welcome"));
		String Actuallogger = Actualtxt.getText();
		System.out.println("Actual Text: "+Actuallogger );
		//Assert.assertTrue(Actuallogger.toLowerCase().contains(Expectedlogger));
	}
	
	public LoginPageOHRM logout()
	{
		driver.findElement(By.id("welcome")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")));
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		return new LoginPageOHRM(driver);
	}
}
