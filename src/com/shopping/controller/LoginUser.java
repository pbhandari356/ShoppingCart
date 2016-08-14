package com.shopping.controller;

import com.shopping.dao.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginUser extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/html");
		String userName = req.getParameter("user");
		String password = req.getParameter("pwd");
		UserDAO u = new UserDAO(); 
		boolean login = new UserDAO().isValidUser(userName, password);
		
		try {
			if (login) {
				HttpSession session = req.getSession();
				session.setAttribute("user", userName);			
				RequestDispatcher rd = req.getRequestDispatcher("displayInventory");
				rd.forward(req,res);
			} else {			
				PrintWriter pw = res.getWriter();
				pw.println("Invalid Username/Password");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req,res);			
			}
		} catch (IOException e) {
			 e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
