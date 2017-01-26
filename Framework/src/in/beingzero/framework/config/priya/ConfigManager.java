package in.beingzero.framework.config.priya;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ConfigManager {

	protected Properties pro = null;
	protected InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("frameworkConfig.properties");
	
	public void readFramworkConfigFile() throws Exception
	{
		pro = new Properties();
		pro.load(input);
	}
	
	/*public String getBrowser() throws IOException
	{
			return pro.getProperty("browser");
	}*/
			
	public String getUrl()
	{
			return pro.getProperty("url");
	}	
	
	public String getBrowser() 
	{
			return pro.getProperty("browser");
	}
	
	public String getUserName()
	{
			return pro.getProperty("userName");
	}
	
	public String getPwd()
	{
			return pro.getProperty("pwd");
	}
	
	public String getUsrNmeTxt()
	{
			return pro.getProperty("UsrNmeTxt");
	}
	
	public String getPwdTxt()
	{
			return pro.getProperty("PwdTxt");
	}
	
	public String getLgnBtn()
	{
			return pro.getProperty("LgnBtn");
	}
	
	public String getFullScreen()
	{
		return pro.getProperty("runFullScreen");
	}
	
	
	public String getImpWait() {
		return pro.getProperty("implicitTimeoutInSeconds");
	}

	

}
