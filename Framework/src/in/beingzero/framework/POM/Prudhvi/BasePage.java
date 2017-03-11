package in.beingzero.framework.POM.Prudhvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import in.beingzero.framework.config.Prudhvi.BrowserManager;

public class BasePage {
	
	private WebDriver driver;  
	private static WebElement objPIMTab ;
	private static By employeeListLink;
	public BasePage()
	{
		BrowserManager objBM=new BrowserManager();
		setDriver(objBM.launchBrowser());
		
	}

	//This constructor will be used when navigating from one page to another such that new page get opened in the same browser window.
		public BasePage(WebDriver driver)
		{
			this.setDriver(driver);
		}
		
		
		public AddEmployeePage navigateToAddEmployeePage()
		{
			objPIMTab =getDriver().findElement(By.id("menu_pim_viewPimModule"));
			Actions objAction=new Actions(getDriver());
			objAction.moveToElement(objPIMTab).build().perform();
			getDriver().findElement(By.id("menu_pim_addEmployee")).click();
			return new AddEmployeePage(getDriver());
		
		}
		
		
		public EmployeeListPage navigateToEmployeeListPage()
		{
				employeeListLink=By.id("menu_pim_viewEmployeeList");
				Actions objAction=new Actions(getDriver());
				objAction.moveToElement(objPIMTab).build().perform();
				getDriver().findElement(employeeListLink).click();
				return new EmployeeListPage(getDriver());
			
		
		}

		public WebDriver getDriver() {
			return driver;
		}

		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}


}
