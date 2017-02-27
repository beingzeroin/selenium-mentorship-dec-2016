package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import in.beingzero.framework.config.Prudhvi.BrowserManager;

public class BasePage {
	
	WebDriver driver;
	
	
	public BasePage()
	{
		BrowserManager objBM=new BrowserManager();
		driver=objBM.launchBrowser();
		
	}

	//This constructor will be used when navigating from one page to another such that new page get opened in the same browser window.
		public BasePage(WebDriver driver)
		{
			this.driver = driver;
		}
		
		
		public AddEmployeePage NavigateToAddEmployee1()
		{
			//By PIMLink=By.id("menu_pim_viewPimModule");
			//By AddEmployeeLink=By.id("menu_pim_addEmployee");
			WebElement objPIMTab=driver.findElement(By.id("menu_pim_viewPimModule"));
			Actions objAction=new Actions(driver);
			objAction.moveToElement(objPIMTab).build().perform();
			driver.findElement(By.id("menu_pim_addEmployee")).click();
			return new AddEmployeePage(driver);
		
		}


}
