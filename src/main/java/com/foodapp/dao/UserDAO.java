package com.foodapp.dao;

import java.util.List;

import com.foodapp.dto.User;

public interface UserDAO 
{
	int insertUser(User user);
	List<User> getUsers();
	User getUserById(int userId);
	int updateUser(int userId,String password);
	int deleteUser(int userId);
	boolean isEmailExist(String email);
	boolean isMobileExist(String mobile);
	String  getpasswordByemail(String email);
	String  getUsernameByEmail(String email);
	

}
