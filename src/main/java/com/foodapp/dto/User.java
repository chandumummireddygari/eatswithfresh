package com.foodapp.dto;

public class User 
{
	private  int userId;
	private  String userName;
	private  String  password;
	private  String email;
	private  String Adress;
	private String role;
	private String mobile;
	public User()
	{
		
	}
	
	public User(int userId, String userName, String password, String email, String adress, String role,String mobile) 
	{
	
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		Adress = adress;
		this.role = role;
		this.mobile=mobile;
	}
	public User( String userName, String password, String email, String adress, String role,String mobile) 
	{
	    this.userName = userName;
		this.password = password;
		this.email = email;
		Adress = adress;
		this.role = role;
		this.mobile=mobile;
	}
	

	public User(String userName, String password, String email,String  mobile) {
		
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile=mobile;
	}
	

	@Override
	public String toString() 
	{
		return userId+" "+userName+" "+password+" "+email+" "+Adress+" "+role;
	}
	
	
	
	

	
	
	
	
	

	

}
