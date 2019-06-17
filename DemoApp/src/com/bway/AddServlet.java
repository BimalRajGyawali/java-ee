package com.bway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3411861857855922356L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		
		int k = i+j;
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.println(k);
		
		
	}
	
	
	
}
