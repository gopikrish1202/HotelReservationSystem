package com.management;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {
	
	private static Connection con;
	private static Properties property=new Properties();
	public static Connection getConnection() {
		try {
			FileInputStream fis=new FileInputStream("database.properties");
			property.load(fis);
			String drivername=property.getProperty("drivername");
			
			Class.forName(drivername);
			
			String url=property.getProperty("url");
			String username=property.getProperty("username");
			String password=property.getProperty("password");
			con=DriverManager.getConnection(url,username,password);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			
		}
		catch(IOException e) {
			
		}
		
		return con;
	}
	
}
