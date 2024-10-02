package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.connector.ConnectorFactory;
import com.foodapp.dto.Menu;


public class MenuDAOimpl implements MenuDAO
{
	@Override
	public int insertMenu(Menu m) {
		try {
			
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("insert into menu (item_name,description,price,is_available,img_path,restaurant_id)"
					 	+ " values (?,?,?,?,?,?)");
			  
			  pstmt.setString(1, m.getItem_name());
			  pstmt.setString(2, m.getDescription());
			  pstmt.setFloat(3, m.getPrice());
			  pstmt.setBoolean(4, m.isIs_avilable());
			  pstmt.setString(5, m.getImg_path());
			  pstmt.setInt(6, m.getRestaurant_id());
			  
			 return pstmt.executeUpdate();
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
			return 0;
	}

	@Override
	public List<Menu> getAllRestMenu(int restaurant_id) {
		
      List<Menu> al=new ArrayList<Menu>();
		
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
			        .prepareStatement("select * from menu where restaurant_id=?");
		     pstmt.setInt(1,restaurant_id );
		ResultSet res=	pstmt.executeQuery();
	    
		while(res.next()) {
		  
			Menu menu=new Menu(res.getInt(1),
					res.getString(2),
					res.getString(3),
					res.getFloat(4),
					res.getBoolean(5),
					res.getString(6),
			        res.getInt(7));
			
			al.add(menu);
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al;

	}
	
	

	@Override
	public Menu getMenuById(int menu_id) {
		Menu menu=null;
	    try {
			
	    	PreparedStatement pstmt=ConnectorFactory.
	    			requestConnection().prepareStatement("select * from menu where menu_id=?");
	    
	      pstmt.setInt(1, menu_id);
	      
	      ResultSet res=pstmt.executeQuery();
	      
	      if(res.next()) {
	      menu=new Menu(res.getInt(1),
					res.getString(2),
					res.getString(3),
					res.getFloat(4),
					res.getBoolean(5),
					res.getString(6),
			        res.getInt(7));
	      }
	      else {
	    	  System.out.println("no menu found");
	      }
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return menu;
	}
	@Override
	public List<Menu> getResItems(int restaurant_id) {
		
      List<Menu> al=new ArrayList<Menu>();
		
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
			        .prepareStatement("select * from menu where restaurant_id=?");
		     pstmt.setInt(1, restaurant_id);
		ResultSet res=	pstmt.executeQuery();
	    
		while(res.next()) {
		  
			
			
			al.add(new Menu(res.getInt(1),res.getString(2),res.getString(3),res.getFloat(4),res.getBoolean(5),res.getString(6),res.getInt(7)));
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al;

	}


	@Override
	public int deleteMenuById(int menu_id) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("delete from menu "
							+ "where menu_id=?");
			
			pstmt.setInt(1, menu_id);
			
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return 0;
	}

	@Override
	public int updateMenuById(int menu_id, boolean isAvailable) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("update menu "
							+ "set is_available=? where menu_id=?");
			
			pstmt.setBoolean(1, isAvailable);
			pstmt.setInt(2, menu_id);
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
			
		return 0;	
	}

	
	
}


	