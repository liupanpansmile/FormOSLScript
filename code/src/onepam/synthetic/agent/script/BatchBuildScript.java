package onepam.synthetic.agent.script;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import net.sf.json.JSONObject;

public class BatchBuildScript {

	public void batchBuildScript(String templateFile,String destPath,int count) {
		
		String jsonContext = readFile(templateFile) ;
		JSONObject jsonObject = JSONObject.fromObject(jsonContext);
		
		for(int i =0 ;i < count ;++i){
			if(jsonObject.containsKey("id") )
			{
				jsonObject.put("id", i) ;	
			}
			String filename =destPath + i +".osl" ;
			writeFile(filename, jsonObject.toString());			
		}

	}

	//read template script
	public String readFile(String path) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	
	//write script to file
	public void writeFile(String filename,String content){
		FileWriter file = null;
        try {
        	file = new FileWriter(filename);
            file.write(content+"\r\n\r\n");
        } catch (IOException e) {
            e.printStackTrace();
 
        } finally {
            try {
            	if(file != null){
            		file.flush();
            		file.close();
            	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
		
	}
}
