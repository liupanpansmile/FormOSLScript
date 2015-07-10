package onepam.synthetic.agent.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {

    private static final Logger logger = LogManager.getLogger(Configuration.class.getName());
    private Config config;


	static class ConfigurationHolder {    
	    static Configuration instance = new Configuration();    
	  }   
	
	private Configuration(){
        readConfig();
	}
	
	public static Configuration instance(){
		return ConfigurationHolder.instance;
	}
	
	
	
	
    public void readConfig() {
        logger.info("---readConfig---");
        try {
            //TODO toXML src\oneapm\synthetic\agent\runner\config\  src/main/resources/
            config = XMLUtil.toBeanFromFile("", "config.xml", Config.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Config getConfig() {
        return config;
    }

  
  
}

