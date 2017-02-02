package in.beingzero.objectoriented.prudhvi;

import org.openqa.selenium.WebDriver;

public abstract class BrowserBase implements IBrowser 

{
	protected WebDriver wd;
	public void purpose() 
	{
		System.out.println("Browser helps you fetch info from WEB");
		
	}
	
	 void launch(boolean launchMaximized)
	 {
		 if(launchMaximized)
		 {
			 //wd.manage().window().maximize();
			 System.out.println("Browser is Maximized");
		 }
		 		 
	 }
	

}
