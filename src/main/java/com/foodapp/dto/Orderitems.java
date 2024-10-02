package com.foodapp.dto;

public class Orderitems 
{
	
	private int order_id;
	 private int menu_id;
	 private int quantity; 
	 private float subtotal; 
	 private String order_items;
	 
	 public Orderitems() 
	 {
			 
	 }

	public Orderitems(int order_id, int menu_id, int quantity, float subtotal, String order_items) 
	{
		
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.order_items = order_items;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public String getOrder_items() {
		return order_items;
	}

	public void setOrder_items(String order_items) 
	{
		this.order_items = order_items;
	}

	@Override
	public String toString() {
		return order_id+" "+menu_id+" "+quantity+" "+subtotal+" "+order_items;
	}
	
	
	 
	

}
