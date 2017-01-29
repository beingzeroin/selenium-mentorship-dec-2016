package in.beingzero.objectoriented.swetha;

public class IEBrowser implements Browser {

	@Override
	public void launch() {
		System.out.println("Launching IE Browser");
		
	}

	@Override
	public void quit() {
		System.out.println("Quitting IE Browser");
		
	}

	@Override
	public void purpose() {
		System.out.println("Browser helps you fetch info from WEB");
		
	}

	String getBrowserVersion(){
		System.out.println("Browser helps you fetch info from WEB");
		return "9.11";
		
	}


}
