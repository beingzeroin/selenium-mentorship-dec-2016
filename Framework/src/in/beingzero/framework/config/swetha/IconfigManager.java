package in.beingzero.framework.config.swetha;

public interface IconfigManager {
	
	public boolean isPropertyExisting(String propName);
    public String getProperty(String propName);
    public int getLongProperty(String propName);
	public boolean getBooleanProperty(String propName);

}
