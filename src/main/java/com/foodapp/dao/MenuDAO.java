package com.foodapp.dao;

import java.util.List;

import com.foodapp.dto.Menu;


public interface MenuDAO 
{
	int insertMenu(Menu m);
	List<Menu> getAllRestMenu(int restaurant_id);
	 Menu getMenuById(int menu_id);
	 int deleteMenuById(int menu_id);
	 int updateMenuById(int id, boolean isAvailable);
	List<Menu> getResItems(int restaurant_id);
}
