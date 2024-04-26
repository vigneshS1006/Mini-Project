package Alerts;

import java.util.Properties;

public class AccessProperties {
	
	static Properties propertyFile=ReadProperties.readPropertiesFile();
	
	public static String getUrl() {//return the Url from the property file
		return propertyFile.getProperty("url");
	}
	
	static String nameInput=ReadProperties.readExcel();
	
	public static String getName() {//return the input from excel
		return nameInput;
	}

}
