package in.beingzero.oops.abstraction;

public class CrossPackageClass {

	public void callMe1()
	{
		callMe2();
		callMe3();
	}
	
	private void callMe2()
	{
		callMe3();
	}
	
	protected void callMe3()
	{
		
	}
	
	void callMe4()
	{
		
	}
	
}
