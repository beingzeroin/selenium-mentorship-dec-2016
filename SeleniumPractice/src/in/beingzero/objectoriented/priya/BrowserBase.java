package in.beingzero.objectoriented.priya;

import org.openqa.selenium.WebDriver;

public abstract class BrowserBase implements IBrowser{

	WebDriver driver = null;
	@Override
	public void launch() {
				
	}

	@Override
	public void quit() {
		
	}

	@Override
	public void purpose() {
		System.out.println("Browser helps you fetch info from World Wide WEB");
	}
	
	public void maximized(boolean launchMaximized)
	{
		if (launchMaximized)
		{
			System.out.println("Browser is Maximized");
			driver.manage().window().maximize();
		}
	}
	
}
