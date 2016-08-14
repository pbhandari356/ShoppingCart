package com.shopping.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null; 
		String driver = ConnectionUtil.driver;
		String url = ConnectionUtil.url;
		String uname = ConnectionUtil.user;
		String pwd = ConnectionUtil.password;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,uname,pwd);			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
		
}
