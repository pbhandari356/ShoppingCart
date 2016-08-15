package com.shopping.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.bean.Item;
import com.shopping.util.ItemQuantity;

@WebServlet("/checkout")
public class Checkout extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	
		HttpSession session = req.getSession();
		HashMap<Integer, Item> cart = (HashMap<Integer, Item>) session.getAttribute("cart");
		cart = ItemQuantity.addItemQuantity(cart, req);
		session.setAttribute("cart", cart);
		
		RequestDispatcher rd = req.getRequestDispatcher("checkout.jsp");
		rd.forward(req, res);
	}
}
