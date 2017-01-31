package in.beingzero.objectoriented.swetha;

public class ChromeBrowser extends BrowserBase{

	public void launch() {
		System.out.println("Launching Chrome Browser");
		
	}

	public void quit() {
		System.out.println("Quitting Chrome Browser");
		
	}
	
	public String getBrowserName(){
		return "Google Chrome";
	}



}
