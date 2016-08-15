package com.shopping.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shopping.bean.Item;

public class ItemQuantity {
	
	public static HashMap<Integer,Item> addItemQuantity(HashMap<Integer,Item> cart, HttpServletRequest req){
		Iterator it = cart.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			int i = (int) pair.getKey();			
			String row = String.valueOf(i);					
			String item_id = req.getParameter(row);			
			if (item_id == null) {				
				it.remove();
			} else {
				Item item = (Item) pair.getValue();
				item.setQuantity(Integer.parseInt(item_id));				
			}
		}		
		return cart; 
	}

}
