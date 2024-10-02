package com.foodapp.dao;

import java.util.List;


import com.foodapp.dto.Orders;

public interface OrdersDAO 
{
	int insertOrders(Orders o);
	List<Orders>getOrders();
	Orders getordersById(int order_id);
	int updateOrders(int order_id,String status);
	int deleteOrders(int order_id );
	
	

}
