package com.eatwithfresh.login;

import java.io.IOException;

import com.foodapp.dao.UserDAO;
import com.foodapp.dao.UserDAOImpl;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class Login extends HttpServlet {
	
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDAO user=new UserDAOImpl();
        if(user.isEmailExist(email)) 
        {
			
			if(user.getpasswordByemail(email).equals(password))
			{
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("username", user.getUsernameByEmail(email));
				response.sendRedirect("homepage.jsp");
			}
    	
        else
        {
        	response.sendRedirect("Loginfail.html");
        }
       }
        else
        {
        	response.sendRedirect("register.html");
        }

    }
}
