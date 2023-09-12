package tek.insurance.app.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	
	private static ReadYamlFiles realYamlFiles;
	
	private HashMap propertyType;

	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);
		Yaml yaml = new Yaml();
		this.propertyType = yaml.load(fileInputStream);
	}

	public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if(realYamlFiles == null) 
			return new ReadYamlFiles(filePath);
		
		return realYamlFiles;
	}
	
	public HashMap getYamlProperty(String key) {
		return (HashMap) this.propertyType.get(key);
	}
	
}
