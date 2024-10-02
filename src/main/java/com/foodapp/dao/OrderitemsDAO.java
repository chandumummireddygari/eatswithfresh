package com.foodapp.dao;

import java.util.List;

import com.foodapp.dto.Orderitems;


public interface OrderitemsDAO 
{
	int insertOrderitems(Orderitems o);
	List<Orderitems>getOrderitems();
	Orderitems getorderitemsById(int order_items_id);
	int updateOrderitems(int order_items_id,float subtotal);
	int deleteOrderitems(int order_items_id);
	
	
	

}
