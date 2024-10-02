package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.connector.ConnectorFactory;
import com.foodapp.dto.Orderitems;


public class OrderitemsimplDAO implements OrderitemsDAO  
{

	private Connection con;
	private PreparedStatement psmt;
	private Statement stmt;
	private ResultSet resultset;
	private PreparedStatement pstmt;

	@Override
	public int insertOrderitems(Orderitems o) 
	{
		final String SQl="INSERT INTO Order_items(order_id,menu_id,quantity,subtotal,order_items)values(?,?,?,?,?)";
		
		 int x=0;
		
			try 
			{
			con=ConnectorFactory.requestConnection();
			
		    psmt = con.prepareStatement(SQl);
		    
			psmt.setInt(1,o.getOrder_id());
			psmt.setInt(2,o.getMenu_id());
			psmt.setInt(3,o.getQuantity());
			psmt.setFloat (4,o.getSubtotal());
			psmt.setString(5,o.getOrder_items());
			
			
			
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
	public List<Orderitems> getOrderitems()
	{
		final String orderitemlistall="SELECT *FROM Order_items";
		ArrayList<Orderitems> reslist=new ArrayList<Orderitems>();
		try
		{
			con=ConnectorFactory.requestConnection();
			stmt=con.createStatement();
			resultset = stmt.executeQuery(orderitemlistall);
			while(resultset.next())
			{
				reslist.add(new Orderitems(resultset.getInt(1),resultset.getInt(2),resultset.getInt(3),resultset.getFloat(4),resultset.getString(5)));
			}
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		return reslist; 
		
		
	}

	@Override
	public Orderitems getorderitemsById(int order_items_id) 
	{
		final String getByid="SELECT * FROM order_items  where order_items_id=?";
		Orderitems res=null;
		try 
		{
			con=ConnectorFactory.requestConnection();
			pstmt =con.prepareStatement(getByid);
		    pstmt.setInt(1,order_items_id);
		    resultset=pstmt.executeQuery();
		    while(resultset.next())
		    {
		    	
		    	 res =new Orderitems(resultset.getInt(1),resultset.getInt(2),resultset.getInt(3),resultset.getFloat(4),resultset.getString(5));
			}
			
		    
		} 
		catch(Exception e) 
		{
			
			e.printStackTrace();
		} 
		
	    
		
		return res;
	
		
	}

	@Override
	public int updateOrderitems(int order_items_id, float subtotal) 
	{
		int x = 0;
		final String orderitemsUPDATE_DATA="update order_items set subtotal=? where order_items_id=?";
		try 
		{
			con=ConnectorFactory.requestConnection();
		
			pstmt=con.prepareStatement(orderitemsUPDATE_DATA);
			pstmt.setFloat(1,subtotal);
			pstmt.setInt(2, order_items_id);
		    x=pstmt.executeUpdate();
		
	    } 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		 return x;
		
	}

	@Override
	public int deleteOrderitems(int order_items_id) 
	{
		final String orderitemsDELETE="delete from order_items  where order_items_id=?";
		int x=0;
		try
		{
			con=ConnectorFactory.requestConnection();
			pstmt=con.prepareStatement(orderitemsDELETE);
			pstmt.setInt(1,order_items_id);
			x=pstmt.executeUpdate();
		
			 
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		} 
		
		
		
		return x;
		
	    }
		
	}


