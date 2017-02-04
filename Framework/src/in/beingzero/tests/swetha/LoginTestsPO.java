package in.beingzero.tests.swetha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.beingzero.framework.config.swetha.ConfigManager;
import in.beingzero.framework.config.swetha.DashboardPage;
import in.beingzero.framework.config.swetha.LoginPage;

	public class LoginTestsPO extends ConfigManager {
			
		WebDriver wd;
		
		boolean logonStatus = false;
		
		String expectedLogonText = "Welcome Admin";
		String webUrl;
		
		
		@BeforeMethod
		public void setup() {
			
			//Read the browser
			String strDriver =  getProperty("browser");
			createDriverObject(strDriver);
			
			//Read the URL
			
			webUrl = getProperty("url");
			
			//Read and set the implicit timeout
			
			wd.manage().timeouts().implicitlyWait(getLongProperty("implicitTimeoutInSeconds"),TimeUnit.SECONDS);
			
			//To read and set the size of browser window.
			
			if(getBooleanProperty("runFullScreen")){
				wd.manage().window().maximize();
			}	
			
		}
		
		@Test
		public void logon(){
			
			//Open the URL
			
			//wd.get(webUrl);
			
			LoginPage LP = new LoginPage();
			
			String username = getProperty("username");
			
			String password = getProperty("password");
						
			DashboardPage dp = LP.loginWithValidUser(username,password);
			
			LP.validatePage();
			
			//LP = dp.logout();
			
		}
		
		
		@AfterMethod
		public void cleanup()
		{
			// Quit browser
			//wd.quit();
		}
		
		public WebDriver createDriverObject(String driverType)
		{
			driverType = "chrome"; 
			
			if(driverType.equals("chrome"))
				wd = new ChromeDriver();
			else if(driverType.equals("ie"))
				wd = new InternetExplorerDriver();
			else
				wd = new FirefoxDriver();
			
			return wd;
			
		}

		
		

	}

