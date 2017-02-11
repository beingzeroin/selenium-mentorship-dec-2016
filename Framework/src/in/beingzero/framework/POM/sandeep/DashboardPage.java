package in.beingzero.framework.POM.sandeep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DashboardPage extends BasePage{
	
	public DashboardPage() {
		super();
	}

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	
	public LoginPage logout(){
		//click(By.id("logoutLink"));
		return new LoginPage(driver);
	}

	public String getWelcomeText() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
