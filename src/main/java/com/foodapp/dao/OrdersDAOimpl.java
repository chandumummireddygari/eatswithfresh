package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.connector.ConnectorFactory;

import com.foodapp.dto.Orders;

public class OrdersDAOimpl implements OrdersDAO  
{

	private Connection con;
	private PreparedStatement psmt;
	private Statement stmt;
	private ResultSet resultset;
	private PreparedStatement pstmt;

	@Override
	public int insertOrders(Orders o) 
	{
		final String SQl="INSERT INTO Orders(user_id,restaurant_id,total_amount,status,payment_option) values(?,?,?,?,?)";
		
		 int x=0;
		
			try 
			{
			con=ConnectorFactory.requestConnection();
			
		    psmt = con.prepareStatement(SQl);
		    
			psmt.setInt(1,o.getUser_id());
			psmt.setInt(2,o.getRestaurant_id());
			psmt.setFloat(3,o.getTotal_amount());
			psmt.setString (4,o.getStatus());
			psmt.setString(5,o.getPayment_option());
			
			
			
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
	public List<Orders> getOrders() 
	{
		final String orderlistall="SELECT *FROM Orders";
		ArrayList<Orders> reslist=new ArrayList<Orders>();
		try
		{
			con=ConnectorFactory.requestConnection();
			stmt=con.createStatement();
			resultset = stmt.executeQuery(orderlistall);
			while(resultset.next())
			{
				reslist.add(new Orders(resultset.getInt(1),resultset.getInt(2),resultset.getFloat(3),resultset.getString(4),resultset.getString(5)));
			}
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		} 
		
	    return reslist;
		
}

	@Override
	public Orders getordersById(int order_id)
	{
		final String getByid="SELECT * FROM Orders  where order_id=?";
		Orders res=null;
		try 
		{
			con=ConnectorFactory.requestConnection();
			pstmt =con.prepareStatement(getByid);
		    pstmt.setInt(1,order_id);
		    resultset=pstmt.executeQuery();
		    while(resultset.next())
		    {
		    	
		    	 res =new Orders(resultset.getInt(1),resultset.getInt(2),resultset.getFloat(3),resultset.getString(4),resultset.getString(5));
			}
			
		    
		} 
		catch(Exception e) 
		{
			
			e.printStackTrace();
		} 
		
	    
		
		return res;
	
		
		
	}

	@Override
	public int updateOrders(int order_id, String status)
	{
		
		int x = 0;
		final String orderUPDATE_DATA="update orders set status=? where order_id=?";
		try 
		{
			con=ConnectorFactory.requestConnection();
		
			pstmt=con.prepareStatement(orderUPDATE_DATA);
			pstmt.setString(1,status);
			pstmt.setInt(2, order_id);
		    x=pstmt.executeUpdate();
		
	    } 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		 return x;
	}
	
    @Override
	public int deleteOrders(int order_id) 
	{
    	final String orderDELETE="delete from Orders where order_id=?";
		int x=0;
		try
		{
			con=ConnectorFactory.requestConnection();
			pstmt=con.prepareStatement(orderDELETE);
			pstmt.setInt(1,order_id);
			x=pstmt.executeUpdate();
		
			 
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		} 
		
		
		
		return x;
	    }
		
		
	}
	
	


