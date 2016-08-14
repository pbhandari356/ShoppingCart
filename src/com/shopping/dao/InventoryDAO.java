package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.shopping.bean.Item;
import com.shopping.connection.DBConnection;

public class InventoryDAO {
	
	Connection con = null;	
	PreparedStatement ps = null;
		
	public HashMap<Integer,Item> populateInventory() { 

		HashMap<Integer,Item> data = new HashMap<>();		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("select * from inventory");
			ResultSet rs = ps.executeQuery();						
			while (rs.next()) {
				Item item = new Item();
				item.setItem_no((rs.getInt(1)));
				item.setDescription(rs.getString(2));
				item.setPrice(rs.getInt(3));
				item.setQuantity(rs.getInt(4));
				data.put(rs.getInt(1),item);
			}			
		} catch (SQLException e) {
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
		
		return data;
	}

}
