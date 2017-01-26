package in.beingzero.framework.config.Prudhvi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager implements IConfigManager
{
	String str;
	
	Properties objProperties;
	FileReader objReader;

	public  void LoadPropertiesToReader() throws Exception
	{
		objReader=new FileReader(System.getProperty("user.dir")+"\\FrameWorkConfig.txt");
		objProperties.load(objReader);
		
	}
	@Override
	public boolean isPropertyExisting(String propName) 
	{
		boolean boolIsPropertyExist = false;
		objProperties.containsKey(propName);
		return boolIsPropertyExist;
	}

	@Override
	public String getProperty(String propName) 
	{
		return objProperties.getProperty(propName);
	}

	@Override
	public int getLongProperty(String propName) 
	{
		return Integer.parseInt(objProperties.getProperty(propName));
	}

	@Override
	public boolean getBooleanProperty(String propName) 
	{
		return Boolean.parseBoolean(objProperties.getProperty(propName));
	}

}
