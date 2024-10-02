package com.eatwithfresh.registration;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.foodapp.dao.UserDAO;
import com.foodapp.dao.UserDAOImpl;
import com.foodapp.dto.User;

public class Registration extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String confirmpassword=req.getParameter("confirmpassword");
		
		
		UserDAO user=new UserDAOImpl();
		if(user.isMobileExist(mobile)) {
			
			resp.sendRedirect("alreadyhaveaccount.html");
		}
		else if(user.isEmailExist(email)) {
			
			resp.sendRedirect("alreadyhaveaccount.html");
		}
		
		else if(password.equals(req.getParameter("confirmpassword"))) {
			
			User u=new User(name,password,email,mobile);
			
			if(user.insertUser(u)>0) {
				resp.sendRedirect("registersuccess.html");
			}
			else {
				
				resp.sendRedirect("registerfail.html");
			}
			
			
		}
		else {
			
			resp.sendRedirect("confirmpwdfails.html");
			
		}
		
	}




		
		
	}


