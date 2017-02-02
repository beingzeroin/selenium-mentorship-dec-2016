package in.beingzero.objectoriented.prudhvi;

public class ChromeBrowser extends BrowserBase
{

	@Override
	public void launch() {
		System.out.println("Launching Chrome Browser");
		
	}

	@Override
	public void quit() {
		System.out.println("Quitting Chrome Browser");
		
		
	} 

	String getBrowserName()
	{
		return "Google Chrome";
	}
	

}
