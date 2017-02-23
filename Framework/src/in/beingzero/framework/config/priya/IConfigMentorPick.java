package in.beingzero.framework.config.priya;

public interface IConfigMentorPick {
	
	public boolean isPropertyExisting(String propName);
    public String getProperty(String propName);
    public int getLongProperty(String propName);
	public boolean getBooleanProperty(String propName);
	
}
