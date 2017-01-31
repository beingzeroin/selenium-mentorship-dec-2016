package in.beingzero.objectoriented.swetha;

public class IEBrowser extends BrowserBase {

	@Override
	public void launch() {
		System.out.println("Launching IE Browser");
		
	}

	@Override
	public void quit() {
		System.out.println("Quitting IE Browser");
		
	}
	

	String getBrowserVersion(){
		return "9.11";
		
	}
	
	public void purpose() {
		System.out.println("IE Browser helps you fetch info from WEB SECURELY");
		
	}


}
