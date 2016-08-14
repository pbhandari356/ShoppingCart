package com.shopping.dao;
import com.shopping.connection.DBConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;


public class UserDAO {
	Connection con = null;
	PreparedStatement ps = null; 
	ResultSet rs = null; 
	
	public boolean isValidUser(String username, String password) {								
		boolean isValid = false;						
		try {	
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select password from user_db where uname = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (password.equals(rs.getString(1))){ 
					isValid = true;									
				}	
			}
			return isValid; 
		} catch (SQLException e) {			 
			e.printStackTrace();
		} finally {
			try{
				if (rs != null) 
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return isValid;
	}
}
