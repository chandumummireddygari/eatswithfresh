package com.foodapp.dto;

public class Restaurant 
{
	private int restaurant_id;
	private String name;
	private String cuisine_type;
	private float delivery_time;
	private boolean isactive;
	private float ratings;
	private String imgpath;
	private String Cityname;
	
	public Restaurant() 
	{
		
	}

	public Restaurant(int restaurant_id, String name, String cuisine_type, float f, boolean isactive, float ratings,String imgpath,
			String Cityname)
	{
		
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.delivery_time=f;
		this.isactive = isactive;
		this.ratings = ratings;
		this.imgpath = imgpath;
		this.Cityname= Cityname;
	}

	

	public Restaurant(String name, String cuisine_type, boolean isactive, int ratings,
			String imgpath)
	{
		
		this.name = name;
		this.cuisine_type = cuisine_type;
	    this.isactive = isactive;
		this.ratings = ratings;
		this.imgpath = imgpath;
		
	}

	

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine_type() {
		return cuisine_type;
	}

	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}
    public boolean isIsactive() {
		return isactive;
	}

	public void setIsctive(boolean isactive) {
		this.isactive = isactive;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imapath) {
		this.imgpath = imapath;
	}
	public void setCityname(String Cityname)
	{
		this.Cityname=Cityname;
	}
	public String getCityname()
	{
		return Cityname;
	}
	public float getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(float delivery_time) {
		this.delivery_time = delivery_time;
	}

	@Override
	public String toString() {
		return restaurant_id+" "+name+" "+" "+cuisine_type+" "+isactive+" "+ratings+" "+imgpath+" "+Cityname+" "+delivery_time;
				}
	
}
