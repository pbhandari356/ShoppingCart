package com.shopping.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.shopping.bean.User;
import com.shopping.dao.RegisterDAO;

import java.io.*;
import java.sql.*;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		
		String firstName= req.getParameter("fname");
		String lastName= req.getParameter("lname");
		String email = req.getParameter("email");
		String userName = req.getParameter("uname");
		String password = req.getParameter("pwd");			
		User user = new User(firstName,lastName,email,userName,password);
		
		RegisterDAO reg = new RegisterDAO();
		boolean isRegister = reg.registerUser(user);		
		if (isRegister) {
			res.sendRedirect("login.html");
		} else {
			PrintWriter pw = res.getWriter();
			pw.println("Error. Please try again");			
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.include(req,res);
		}
	
	}
		
}
