package in.beingzero.objectoriented.swetha;

public class ChromeBrowser implements Browser{

	public void launch() {
		System.out.println("Launching Chrome Browser");
		
	}

	public void quit() {
		System.out.println("Quitting Chrome Browser");
		
	}

	public void purpose() {
		System.out.println("Browser helps you fetch info from WEB");
		
	}
	
	public String getBrowserName(){
		return "Google Chrome";
	}



}
