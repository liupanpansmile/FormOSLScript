package onepam.synthetic.agent.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("config")
public class Config {
    @XStreamAlias("templateFilename")
    private String templateFilename;
    @XStreamAlias("destFilePath")
    private String destFilePath;
    @XStreamAlias("scriptCount")
    private int scriptCount;
    
	
	public String getTemplateFilename() {
		return templateFilename;
	}
	
	public void setTemplateFilename(String templateFilename) {
		this.templateFilename = templateFilename;
	}
	
	public String getDestFilePath() {
		return destFilePath;
	}
	
	public void setDestFilePath(String destFilePath) {
		this.destFilePath = destFilePath;
	}
	public int getScriptCount() {
		return scriptCount;
	}
	public void setScriptCount(int scriptCount) {
		this.scriptCount = scriptCount;
	}

   
}
