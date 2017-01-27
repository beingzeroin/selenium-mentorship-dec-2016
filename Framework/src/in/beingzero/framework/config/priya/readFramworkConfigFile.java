package in.beingzero.framework.config.priya;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class readFramworkConfigFile {

	 Properties pro = null;
	 
	
	public readFramworkConfigFile() throws Exception 
	{
		
		File input = new File(System.getProperty("user.dir").concat("\\src\\in\\beingzero\\framework\\config\\priya\\frameworkConfig.properties"));
		FileInputStream freader = new FileInputStream(input);
		pro = new Properties();
		
		System.out.println("File Path: "+input);
		try {
			pro.load(freader);
		} catch (Exception e) {
			System.out.println("Exception is :"+ e.getMessage());
		}
		
	}
	
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
