package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;

@WebServlet("/login")

public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.getRequestDispatcher("login.jsp").forward(request, response);

		UserDAO userDAO = new UserDAOImpl();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		/*
		 * if(username.equals("admin") && password.equals("111")) {
		 * request.setAttribute("user", username);
		 * request.getRequestDispatcher("home.jsp").forward(request, response); }
		 * 
		 * else {
		 * 
		 * request.setAttribute("error","User Doesnot Exist");
		 * request.getRequestDispatcher("login.jsp").forward(request, response); }
		 * 
		 */

		if (userDAO.login(username, password)) {
			request.setAttribute("user", username);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}

		else {

			request.setAttribute("error", "User Doesnot Exist");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
