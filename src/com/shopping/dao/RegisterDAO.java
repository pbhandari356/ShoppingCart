package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.bean.User;
import com.shopping.connection.DBConnection;

public class RegisterDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	 	
	public boolean registerUser(User user) {
		String fname = user.getFname();
		String lname = user.getLname();
		String uname = user.getUname();
		String email = user.getEmail();
		String password = user.getPwd();		
		boolean register = false; 
		try{
			con = DBConnection.getConnection();			
			ps = con.prepareStatement("insert into user_db values(?,?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, password);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, email);			
			int i = ps.executeUpdate();
			if (i != 0) {
				register = true; 
			}
			return register; 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if (ps != null) {				
					ps.close();
				}
				if (con!=null) {
					con.close();
				}
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return register;
	}
}
