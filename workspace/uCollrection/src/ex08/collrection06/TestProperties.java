package ex08.collrection06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		String path
			= TestProperties.class.getResource("database.properties").getPath();
		System.out.println(path);
		//.properties 파일은 iso-8859-1 encoding 으로 저장됨
		path = URLDecoder.decode(path,"utf-8");
		prop.load(new FileReader(path));
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
	}
}
