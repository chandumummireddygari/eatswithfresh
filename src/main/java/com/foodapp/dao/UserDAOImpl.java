package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.foodapp.connector.ConnectorFactory;
import com.foodapp.dto.User;
import com.mysql.cj.conf.url.ReplicationDnsSrvConnectionUrl;


public class UserDAOImpl implements UserDAO 
{

	
	
	private static ResultSet resultSet;
	private static List<User> userList;
	private Connection con;
	private PreparedStatement psmt;
	private Statement stmt;
	private ResultSet resultset;
	private PreparedStatement pstmt;


	@Override
	public int insertUser(User user) 
	{
		final String SQl="insert into user(user_Name,password,email,Mobileno) values (?,?,?,?)";
		
		 int x=0;
		
 				try 
 				{
					con=ConnectorFactory.requestConnection();
					
				    psmt = con.prepareStatement(SQl);
				    
					psmt.setString(1,user.getUserName());
					psmt.setString(2,user.getPassword());
					psmt.setString(3,user.getEmail());
					psmt.setString(4,user.getMobile());
					
					x=psmt.executeUpdate();
					
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
							
		return x;
	}

	@Override
	public List<User> getUsers() 
     {
		final String GET_ALL="select * from User";
		ArrayList<User> userlist=new ArrayList<User>();
		
		
		
		try
		{
			con=ConnectorFactory.requestConnection();
			stmt=con.createStatement();
			resultset=stmt.executeQuery(GET_ALL);
			while(resultset.next())
			{
				userlist.add(new User(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getString(6),resultset.getString(7)));
			}
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		} 
		
	    return userlist;
     }
	

	@Override
	public User getUserById(int userId) 
	{
		final String GET_SPECIFIC="select * from User where user_id=?";
		User user=null;
		try 
		{
			con=ConnectorFactory.requestConnection();
		    pstmt =con.prepareStatement(GET_SPECIFIC);
		    pstmt.setInt(1,userId);
		    resultset=pstmt.executeQuery();
		    while(resultset.next())
		    {
		    	user=new User(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5),resultset.getString(6),resultset.getString(7));
			}
		    
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return user;
	}

	@Override
	public int updateUser(int userId,String password) 
	{
		int x = 0;
		final String UPDATE_DATA="update User set password=? where user_id=?";
		try 
		{
			con=ConnectorFactory.requestConnection();
			pstmt=con.prepareStatement(UPDATE_DATA);
			pstmt.setString(1,password);
			pstmt.setInt(2, userId);
		    x=pstmt.executeUpdate();
		
	  } 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		
		
		return x;
	}

	
	@Override
	public int deleteUser(int userId) 
	{
		final String DELETE="delete from User where user_id=? ";
		int x=0;
		try
		{
			con=ConnectorFactory.requestConnection();
			pstmt=con.prepareStatement(DELETE);
			 pstmt.setInt(1,userId);
			 x=pstmt.executeUpdate();
		
			 
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		} 
		
		
		
		return x;
	}
	@Override
	public boolean isEmailExist(String email) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("select count(email) from user where email=? ");
			
			pstmt.setString(1, email);
			
			   ResultSet res=pstmt.executeQuery();
			    res.next();
			    if(res.getInt(1)>=1) {
			    	 return true;
			    }
			    
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return false;
	}
	@Override
	public boolean isMobileExist(String  mobile) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("select count(mobileno) from user where mobileno=? ");
			
			pstmt.setString(1, mobile);
			
			   ResultSet res=pstmt.executeQuery();
			    res.next();
			    if(res.getInt(1)>=1) {
			    	 return true;
			    }
			    
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return false;

	}
	public String  getpasswordByemail(String email) 
	{
		final String GET_SPECIFIC="select * from User where email=?";
		
		try 
		{
			con=ConnectorFactory.requestConnection();
		    pstmt =con.prepareStatement(GET_SPECIFIC);
		    pstmt.setString(1,email);
		    resultset=pstmt.executeQuery();
		    while(resultset.next())
		    {
		    	return resultset.getString("password");
			}
		    
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return null;
	}
	public String getUsernameByEmail(String email) {
	    try {
			
	    	PreparedStatement pstmt=ConnectorFactory.
	    requestConnection().prepareStatement("select * from user where email=?");
	    
	      pstmt.setString(1, email);
	      
	      ResultSet res=pstmt.executeQuery();
	      
	      if(res.next()) 
	      {
	          
	    	  return  res.getString(2);
	      }
	    }
	    	
		 catch (Exception e) 
	    {
			
			e.printStackTrace();
	    }
		
		
		
		return "";
	}


	
	
}

