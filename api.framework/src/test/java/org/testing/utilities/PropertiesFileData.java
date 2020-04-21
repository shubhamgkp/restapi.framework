package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileData {
	
	public static Properties propertiesData(String filePath) throws IOException {
		
		File file = new File(filePath);
		FileInputStream fi = new FileInputStream(file);
		Properties pr = new Properties();
		pr.load(fi);
		return pr;		
	}
}
