package in.beingzero.framework.POM.sandeep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation {

	WebDriver wd;
	public Navigation(WebDriver driver) {
		wd = driver;
	}

	public void goToDirectoryPage()
	{
		wd.findElement(By.linkText("Directory"));
	}
	public void goToDashboardPage()
	{
		wd.findElement(By.linkText("Directory"));
	}
}
