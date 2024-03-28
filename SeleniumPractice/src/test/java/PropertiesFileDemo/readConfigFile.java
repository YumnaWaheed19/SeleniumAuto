package PropertiesFileDemo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class readConfigFile {

	Properties properties;
	String path="C:\\Users\\kjkj\\git\\repository\\SeleniumPractice\\src\\test\\java\\PropertiesFileDemo\\Config.Properties";

	public readConfigFile() throws IOException {
		properties=new Properties();
		try {
			FileInputStream inputStream= new FileInputStream(path);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUrl() {
		String url=properties.getProperty("Url");
		if(url!=null) {
			return url;
		}
		else {
			throw new RuntimeException("Url not found");
		}
	}
	
	public String getName() {
		String username=properties.getProperty("username");
		if(username!=null) {
			return username;
		}
		else {
			throw new RuntimeException("username not found");
		}
	}
	public String getPassword() {
		String password=properties.getProperty("password");
		if(password!=null) {
			return password;
		}
		else {
			throw new RuntimeException("password not found");
		}
	}
	
}

