package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.connector.ConnectorFactory;
import com.foodapp.dto.Orderhistory;


public class OrderhistoryDAOimpl implements OrderhistoryDAO 
{

	private Connection con;
	private PreparedStatement psmt;
	private Statement stmt;
	private ResultSet resultset;
	private PreparedStatement pstmt;

	@Override
	public int insertorderhistory(Orderhistory oh) 
	{
		final String SQl="insert into order_history( user_id,order_id,total,status) values(?,?,?,?)";
		
		 int x=0;
		
		 
		  
		 
		
				try 
				{
					con=ConnectorFactory.requestConnection();
					
				    psmt = con.prepareStatement(SQl);
				    
					psmt.setInt(1,oh.getUser_id());
					psmt.setInt(2,oh.getOrder_id());
					psmt.setFloat(3,oh.getTotal());
					psmt.setString(4,oh.getStatus());
					
					
					psmt.executeUpdate();
					
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
							
		return x;
		
	}

	@Override
	public List<Orderhistory> gethistory() 
	{
		
		final String GET_ALL="select * from order_history";
		ArrayList<Orderhistory > orderlist=new ArrayList<Orderhistory >();
		
		
		
		try
		{
			con=ConnectorFactory.requestConnection();
			stmt=con.createStatement();
			resultset=stmt.executeQuery(GET_ALL);
			while(resultset.next())
			{
				orderlist.add(new Orderhistory (resultset.getInt(1),resultset.getInt(2),resultset.getFloat(3),resultset.getString(4)));
			}
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		} 
		
	    return orderlist;
		
	}

	@Override
	public Orderhistory getHistoryById(int order_history_id) 
	{final String GET_SPECIFIC="select * from order_history where order_history_id=?";
	Orderhistory oh=null;
	try 
	{
		con=ConnectorFactory.requestConnection();
	    pstmt =con.prepareStatement(GET_SPECIFIC);
	    pstmt.setInt(1,order_history_id);
	    resultset=pstmt.executeQuery();
	    while(resultset.next())
	    {
	    	oh=new Orderhistory(resultset.getInt(1),resultset.getInt(2),resultset.getFloat(3),resultset.getString(4));
		}
	    
		
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	
	return oh;
		
	}

	@Override
	public int updatehistory(int order_history_id, String status)
	{
		int x = 0;
		final String UPDATE_DATA="update order_history set status=? where order_history_id=?";
		try 
		{
			con=ConnectorFactory.requestConnection();
			pstmt=con.prepareStatement(UPDATE_DATA);
			pstmt.setString(1,status);
			pstmt.setInt(2, order_history_id);
		    x=pstmt.executeUpdate();
		
	  } 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		
		
		return x;
		
	}

	@Override
	public int deletehistory(int order_history_id) 
	{
		final String DELETE="delete from order_history  where order_history_id=? ";
		int x=0;
		try
		{
			con=ConnectorFactory.requestConnection();
			pstmt=con.prepareStatement(DELETE);
			 pstmt.setInt(1,order_history_id);
			 x=pstmt.executeUpdate();
		
			 
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		} 
		
		
		
		return x;
		
	}

}
