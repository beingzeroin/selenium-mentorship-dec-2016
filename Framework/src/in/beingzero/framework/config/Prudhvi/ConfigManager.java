
package in.beingzero.framework.config.Prudhvi;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager implements IConfigManager
{
	String str;
	
	Properties objProperties;
	
	public ConfigManager()
	{
		try
		{
			File objFile=new File("./src/in/beingzero/framework/config/Prudhvi/FrameWorkConfig.txt");	
			FileInputStream objFIS  = new FileInputStream(objFile);
			objProperties=new Properties();
			objProperties.load(objFIS);		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	public boolean isPropertyExisting(String propName) 
	{
		boolean boolIsPropertyExist = false;
		objProperties.containsKey(propName);
		return boolIsPropertyExist;
	}

	
	public String getProperty(String propName) 
	{
		
		return objProperties.getProperty(propName);
	}


	public int getLongProperty(String propName) 
	{
		return Integer.parseInt(objProperties.getProperty(propName));
	}


	public boolean getBooleanProperty(String propName) 
	{
		return Boolean.parseBoolean(objProperties.getProperty(propName));
	}
	
}
