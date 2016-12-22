package in.beingzero.prudhvi;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginOrangeHRM {
	
	public String strURL="http://opensource.demo.orangehrmlive.com";	
	public void validUserNamevalidPWD()
	{
		//System.out.print(strURL);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		
		FirefoxDriver ffDriver=new FirefoxDriver();
		//ChromeDriver chDriver=new ChromeDriver();
		
		//chDriver.get(strURL);
		ffDriver.get("http://opensource.demo.orangehrmlive.com");
		//ffDriver.get(strURL);
		
	}

}
