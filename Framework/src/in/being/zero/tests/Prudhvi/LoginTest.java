package in.being.zero.tests.Prudhvi;

import org.testng.annotations.Test;

import in.beingzero.framework.config.Prudhvi.ConfigManager;

public class LoginTest {
	
	
	@Test
	public void Setup()
	{
		ConfigManager objConfig=new ConfigManager();
		
		System.out.println(objConfig.getProperty("browser"));
		
	}
}
