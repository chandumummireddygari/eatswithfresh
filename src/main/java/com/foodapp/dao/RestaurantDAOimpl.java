package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.connector.ConnectorFactory;
import com.foodapp.dto.Restaurant;


public  class RestaurantDAOimpl implements RestaurantDAO
{

	private Connection con;
	private PreparedStatement psmt;
	private ResultSet resultset;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	@Override
	public int insertRestaurant(Restaurant restaurant) 
	{
	final String SQl="insert into restaurant(name,cuisine_type,delivery_time,isactive,ratings,imgpath,Cityname)values(?,?,?,?,?,?,?)";
		
		 int x=0;
		
			try 
			{
			con=ConnectorFactory.requestConnection();
			
		    psmt = con.prepareStatement(SQl);
		    
			psmt.setString(1,restaurant.getName());
			psmt.setString(2,restaurant.getCuisine_type());
			psmt.setFloat(3,restaurant.getDelivery_time());
	        psmt.setBoolean(4,restaurant.isIsactive());
			psmt.setFloat(5,restaurant.getRatings());
			psmt.setString(6,restaurant.getImgpath());
			psmt.setString(7,restaurant.getCityname());
			
			
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
	public List<Restaurant> getRestaurant() 
	{
		final String listall="SELECT *FROM restaurant";
		ArrayList<Restaurant> reslist=new ArrayList<Restaurant>();
		try
		{
			con=ConnectorFactory.requestConnection();
			stmt=con.createStatement();
			resultset=stmt.executeQuery(listall);
			while(resultset.next())
			{
				reslist.add(new Restaurant(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getFloat(4),resultset.getBoolean(5),resultset.getFloat(6),resultset.getString(7),resultset.getString(8)));
			}
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		} 
		
	    return reslist;
		
		
		
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) 
	{
		final String getByid="SELECT * FROM restaurant where restaurant_id=?";
		Restaurant res=null;
		try 
		{
			con=ConnectorFactory.requestConnection();
			pstmt =con.prepareStatement(getByid);
		    pstmt.setInt(1,restaurantId);
		    resultset=pstmt.executeQuery();
		    while(resultset.next())
		    {
		    	
		    	 res = new Restaurant(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getFloat(4),resultset.getBoolean(5),resultset.getFloat(6),resultset.getString(7),resultset.getString(8));
					
		    }
		} 
		catch(Exception e) 
		{
			
			e.printStackTrace();
		} 
		
	    
		
		return res;
	}

	@Override
	public int updaterestaurant(int restaurantId, String name) 
	{
		int x = 0;
	final String RESUPDATE_DATA="update restaurant set name=? where restaurant_id=?";
	try 
	{
		con=ConnectorFactory.requestConnection();
		pstmt=con.prepareStatement(RESUPDATE_DATA);
		pstmt.setString(1,name);
		pstmt.setInt(2, restaurantId);
	    x=pstmt.executeUpdate();
	
    } 
	catch (Exception e) 
	{
		e.printStackTrace();
	} 
	 return x;
	}

	@Override
	public int deleterestaurant(int restaurantid)
	{
		final String DELETE="delete from Restaurant where restaurant_id=? ";
		int x=0;
		try
		{
			con=ConnectorFactory.requestConnection();
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1,restaurantid);
			x=pstmt.executeUpdate();
		
			 
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		} 
		
		
		
		return x;
	}
	public List<Restaurant> getRestaurantsByLocation(String cityName) {
		
		
        List<Restaurant> al=new ArrayList<Restaurant>();
		
        try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
			        .prepareStatement("select * from restaurant where Cityname=?");
			pstmt.setString(1, cityName);
			
		ResultSet res=	pstmt.executeQuery();
	    
		while(res.next()) {
		  
			Restaurant rest=new Restaurant(res.getInt(1),
		    		  res.getString(2),
		    		  res.getString(3),
		    		  res.getFloat(4),
		    		  res.getBoolean(5),
		    		  res.getFloat(6),
		    		  res.getString(7),
		    		  res.getString(8));
			
			al.add(rest);
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al;
}

}
