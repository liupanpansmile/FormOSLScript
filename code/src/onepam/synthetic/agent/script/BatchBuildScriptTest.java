package onepam.synthetic.agent.script;

import onepam.synthetic.agent.config.Config;
import onepam.synthetic.agent.config.Configuration;

public class BatchBuildScriptTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration configuration = Configuration.instance() ;
		
		
		int count = configuration.getConfig().getScriptCount() ;
		String templateFilename = configuration.getConfig().getTemplateFilename() ;
		String destPath = configuration.getConfig().getDestFilePath() ;
		
		BatchBuildScript batchBuildScript = new BatchBuildScript() ;
		batchBuildScript.batchBuildScript(templateFilename, destPath, count);
		
		
	
		
	}

}


