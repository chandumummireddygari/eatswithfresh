package com.foodapp.dto;

public class Menu 
{
	private int menu_id;
    private String item_name; 
    private String description;
    private float price; 
    private boolean is_avilable; 
    private String img_path; 
    private int restaurant_id;
public Menu() 
{
	
}
public Menu(int menu_id, String item_name, String description, float price, boolean is_avilable, String img_path,
		int restaurant_id) 
{
	
	this.menu_id = menu_id;
	this.item_name = item_name;
	this.description = description;
	this.price = price;
	this.is_avilable = is_avilable;
	this.img_path = img_path;
	this.restaurant_id = restaurant_id;
}
public Menu(String item_name, String description, int price, boolean is_avilable, String img_path,
		int restaurant_id) {
	super();
	this.item_name = item_name;
	this.description = description;
	this.price = price;
	this.is_avilable = is_avilable;
	this.img_path = img_path;
	this.restaurant_id = restaurant_id;
}
public int getMenu_id() {
	return menu_id;
}
public void setMenu_id(int menu_id) {
	this.menu_id = menu_id;
}
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public boolean isIs_avilable() {
	return is_avilable;
}
public void setIs_avilable(boolean is_avilable) {
	this.is_avilable = is_avilable;
}
public String getImg_path() {
	return img_path;
}
public void setImg_path(String img_path) {
	this.img_path = img_path;
}
public int getRestaurant_id() {
	return restaurant_id;
}
public void setRestaurant_id(int restaurant_id) {
	this.restaurant_id = restaurant_id;
}
public int getRatings() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public String toString() {
	return menu_id+" "+item_name+" "+description+" "+price+" "+is_avilable+" "+img_path+" "+restaurant_id;
}



}






