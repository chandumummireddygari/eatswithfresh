package com.foodapp.dao;

import java.util.List;

import com.foodapp.dto.Restaurant;


public interface RestaurantDAO
{
	int insertRestaurant(Restaurant restaurant);
	List<Restaurant>getRestaurant();
	Restaurant getRestaurantById(int restaurantId);
	int updaterestaurant(int restaurantId,String name);
	int deleterestaurant(int restaurantid);
	
	

}



