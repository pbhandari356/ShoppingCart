package com.shopping.controller;

import com.shopping.bean.Item;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateCart")
public class UpdateCart extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();		
		HashMap<Integer,Item> data = (HashMap<Integer,Item>) session.getAttribute("inventory");
		HashMap<Integer, Item> cart = (HashMap<Integer, Item>) session.getAttribute("cart");
		
		if (cart == null) {
			cart = new HashMap<Integer, Item>();
		}
				
		int item_no = Integer.parseInt(req.getParameter("item_no"));				
		Item item = data.get(item_no);
		if (!cart.containsKey(item))
			cart.put(item_no, item);
		session.setAttribute("cart", cart);
		
		try {
			RequestDispatcher rd = req.getRequestDispatcher("inventory.jsp");
			rd.forward(req, res);		
		} catch (ServletException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
