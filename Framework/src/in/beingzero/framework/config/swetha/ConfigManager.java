package in.beingzero.framework.config.swetha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager implements IConfigManager {

	Properties prop;
	
	public ConfigManager(){
		
		System.out.println(System.getProperty("user.dir"));
		
		File file = new File(System.getProperty("user.dir")+"/src/in/beingzero/framework/config/swetha/FrameWorkConfig.txt");
		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	@Override
	public boolean isPropertyExisting(String propName) {
		// Check property file
		// If propName is there return true
		// Else return false
		return false;
	}

	@Override
	public String getProperty(String propName) {
		
		return prop.getProperty(propName);
	}

	@Override
	public int getLongProperty(String propName) {
		
		return Integer.parseInt(prop.getProperty(propName));
	}

	@Override
	public boolean getBooleanProperty(String propName) {

		return Boolean.parseBoolean(prop.getProperty(propName));
	}


}
