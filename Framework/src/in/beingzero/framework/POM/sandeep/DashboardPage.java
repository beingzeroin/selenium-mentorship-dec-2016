package in.beingzero.framework.POM.sandeep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DashboardPage extends BasePage{
	
	public DashboardPage() {
		super();
	}

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	
	public LoginPage logout(){
		driver.findElement(By.id("logoutLink")).click();
		return new LoginPage(driver);
	}

	public String getWelcomeText() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
