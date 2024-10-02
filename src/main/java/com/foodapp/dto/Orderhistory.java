package com.foodapp.dto;

public class Orderhistory 
{
	 private int user_id;
	 private int order_id;
	  private float total; 
	 private String status;
	public Orderhistory() 
	{
		
	}
	public Orderhistory(int user_id, int order_id, float total, String status) 
	{
		
		this.user_id = user_id;
		this.order_id = order_id;
		this.total = total;
		this.status = status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return  user_id+" "+order_id+" "+total+" "+status;
	}
	
	
	 
	 
	

}
