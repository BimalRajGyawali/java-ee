package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DB;
import com.model.User;



public class UserDAOImpl implements UserDAO
{

	@Override
	public void signup(User user) {
		
		String sql = "insert into usertable(fname,lname,username,password) values(?,?,?,?)";
		
		try {
			  
			Connection con = DB.getConnection();
			
			if(con==null)
			{
				System.out.println("No Connection ");
				return;
			}
			 
			 PreparedStatement stmt = con.prepareStatement(sql);
			   stmt.setString(1, user.getLname());
               stmt.setString(2, user.getLname());
               stmt.setString(3, user.getUsername());
               stmt.setString(4, user.getPassword());
			   
			   stmt.execute();
			   
			   
			   
			   
			   
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public boolean login(String username, String password) {
	
		String sql = "select * from usertable where username=? and password=?";
		
		
		try {
			 
Connection con = DB.getConnection();
			
			if(con==null)
			{
				System.out.println("No Connection ");
				return false;
			}
			 
			 PreparedStatement stmt = con.prepareStatement(sql);
			  
			 ResultSet resultset = stmt.executeQuery();
			   
			   if(resultset.next()){
				   
				   return true;
			   }

			   
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		return false;
	}

}
