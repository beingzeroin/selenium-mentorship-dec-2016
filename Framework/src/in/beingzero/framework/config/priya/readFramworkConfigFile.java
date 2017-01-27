package in.beingzero.framework.config.priya;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class readFramworkConfigFile {

	protected Properties pro = null;
	protected InputStream input = readFramworkConfigFile.class.getClassLoader().getResourceAsStream("frameworkConfig.properties");
	
	public readFramworkConfigFile()
	{
		pro = new Properties();
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		System.out.println(System.getProperty("user.dir"));
		System.out.println("Path of file :"+ readFramworkConfigFile.class.getClassLoader().getResourceAsStream(""));
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
	
	public String getLogOutBtn()
	{
			return pro.getProperty("LogOut");
	}
	
	public String getFullScreen()
	{
		return pro.getProperty("runFullScreen");
	}
	
	
	public String getImpWait() {
		return pro.getProperty("implicitTimeoutInSeconds");
	}

	

}
