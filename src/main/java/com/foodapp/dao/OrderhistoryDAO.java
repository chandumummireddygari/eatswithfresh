package com.foodapp.dao;

import java.util.List;

import com.foodapp.dto.Orderhistory;


public interface OrderhistoryDAO 
{
	int insertorderhistory(Orderhistory oh);
	List<Orderhistory> gethistory();
	Orderhistory getHistoryById(int order_history_id);
	int updatehistory(int order_history_id,String status);
	int deletehistory(int order_history_id);

}
