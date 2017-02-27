package in.beingzero.framework.POM.Swetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


	public LoginPage() {
		
		super();  
	}
	
	public LoginPage(WebDriver wd) {
		
		driver = wd;
		
	}

	public DashboardPage validLogin(String userName, String password) {
		
		WebElement usrName = driver.findElement(By.id("txtUsername"));
		usrName.sendKeys(userName);

		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys(password);

		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
		
		return new DashboardPage(driver);
	}
	
}