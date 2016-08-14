package com.shopping.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.bean.Item;
import com.shopping.dao.InventoryDAO;

@WebServlet("/displayInventory")
public class DisplayInventory extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession(false);		
		try{
			if (session != null) {			
				HashMap<Integer,Item> inventory = new InventoryDAO().populateInventory();
				session.setAttribute("inventory", inventory);					
				RequestDispatcher rd = req.getRequestDispatcher("inventory.jsp");
				rd.forward(req, res);
			} else {
				res.sendRedirect("login.html");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
				
	}

}
