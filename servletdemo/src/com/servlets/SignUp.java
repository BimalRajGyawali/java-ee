package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.model.User;


@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		
		 User user = new User();
		 
		 
		 user.setFname(request.getParameter("fname"));
		 user.setLname(request.getParameter("lname"));
		 user.setUsername(request.getParameter("username"));
		 user.setPassword(request.getParameter("password"));
		 
		 UserDAO userDAO = new UserDAOImpl();
		 
		 userDAO.signup(user);
		 
		 
		 request.getRequestDispatcher("signupsuccess.jsp").forward(request, response);
		 	
			}
		
	}


