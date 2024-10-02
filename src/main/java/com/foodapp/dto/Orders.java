package com.foodapp.dto;

public class Orders 
{
	
	private int user_id;
	private int restaurant_id;
	private float total_amount;
	private String status; 
    private String  payment_option;
	public Orders() 
	{
		
	}
	public Orders(int user_id, int restaurant_id, float total_amount,String payment_option, String string) 
	{
		
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.total_amount = total_amount;
		
		this.payment_option = payment_option;
	}
	public  int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_option() {
		return payment_option;
	}
	public void setPayment_option(String payment_option) {
		this.payment_option = payment_option;
	}
	@Override
	public String toString() {
		return user_id+" "+restaurant_id+" "+total_amount+" "+status+" "+payment_option;
	}
	
	

}
