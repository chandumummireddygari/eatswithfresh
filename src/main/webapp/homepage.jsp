<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="com.foodapp.dao.UserDAO" %>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.foodapp.dto.Restaurant" %>
  <%@ page import="com.foodapp.dao.RestaurantDAOimpl" %>
  <%@ page import="com.foodapp.dao.MenuDAOimpl" %>
  <%@ page import="com.foodapp.dto.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
<link rel="stylesheet" type="text/css" href="homepage.css">
<style type="text/css">
     
     .location
      {
	       display: flex;
	       gap:7px;
	       align-items: center;
	      
      }
     .location img
      {
           width:45px
      }
      #selectcity
     {
        
            background-color: black;
            color:yellow;
            border: none;
            border-radius: 4px;
            font:inherit;
            font-size:15px;
           margin: 0;      
          -webkit-box-sizing: border-box;
          -moz-box-sizing: border-box;
           box-sizing: border-box;
          -webkit-appearance: none;
          -moz-appearance: none;

     }

        .username p
        
        {
           margin-left:-5px;
	       position: absolute;

        }
        #declaration
         {
             display:none;
         }
        

    
</style>
<script src="homepage.js"></script>
</head>

<body>
<div id="declaration">
   	  
   	  
           
          <%! Cookie[] cookies =null;
          String cityName=null;
          %>
         <%=  cookies=request.getCookies()%>
         
         <% if (cookies != null) {
             for (Cookie cookie : cookies) {
                 if ("selectCity".equals(cookie.getName())) {
                     
                     cityName = java.net.URLDecoder.decode(cookie.getValue(), "UTF-8");
                    
                     break;
                 }
             }
         } 
         %>
         
         
         <%! UserDAO userdao=null; %>
           <%= user=(UserDAO)session.getAttribute("user") %>

           
          
       </div>
     
      
    
    <header class="nav-bar">
    
           
      <div class="logo"> 
   	  	<a href="homepage.jsp" target="_self"><img src="logohome.png" /></a>
   	  </div>
   	  
   	  <div class="location">
   	       <img  src="logolocation.png" >
   	       
   	       
   	      <select  name="selectcity" id="selectcity" onchange="getCity()" >
   	          
   	             <option  value="Banglore">Banglore</option>
   	             <option  value="Chennai">Chennai</option>
   	             <option  value="Hyderabad" >Hyderabad</option>
   	             <option  value="Tirupati">Tirupati</option>
   	             
   	          
   	       </select>
   	         
   	  </div>

   	  <div class="search-box"> 
           <input type="text" placeholder="Search your favourite food">
           <button>Explore</button>
   	  </div>
   	  
   	<div class="declaration"><%! UserDAO user=null; %>
           <%= user=(UserDAO)session.getAttribute("user")  %>
    </div>  
   	 
   	 <%  if(user!=null) 
   	  { %>
   	     
   	    <div class="nav-links">
   	  	<a href="" target="_self">Offers</a>
   	  	<a href="" target="_self">Help</a>
   	  	<a href="" target="_self">Restaurants</a>
   	  	<a href="" target="_self">Orders</a>

   	    </div>
   	    
   	    <div class="username">
             
             <p><%= (String)session.getAttribute("username") %></p>

       </div>
   	     
   	  <%}else{%> 
   		  
   		<div class="nav-links">
   	  	<a href="" target="_self">Offers</a>
   	  	<a href="" target="_self">Help</a>
   	  	<a href="login.html" target="_self">Login</a>
   	  	<a href="" target="_self">Signup</a>
   	  	</div>
   		  <% }%> 
    

   	  <div class="nav-icons">
   	  	
   	  	<img src="my.png">
   	  	<img src="cart.png">

   	  </div>
   	 

   </header> 
   
   
   
      <section class="menu">

        
        
             <h2 class="heading" style="color:black">What's on your mind?</h2>
             <div class="items-group">
                
                 <div class="item">
                 
                     <a href=""><img src="idli.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="biryani.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="bonda.png"></a>
                    
                 </div>

                 <div class="item">
                 
                     <a href=""><img src="dosa.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="paratha.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="uttappam.png"></a>
                    
                 </div>
                  <div class="item">
                 
                     <a href=""><img src="appam.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="juice.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="poori.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="pongal.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="chole.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="coffe.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="cake.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="omeleta.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="pancakes.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="pattu.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="poha.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="salad.png"></a>
                    
                 </div>
                 <div class="item">
                 
                     <a href=""><img src="vada.png"></a>
                    
                 </div>
           </div>
       </section> 
       <% ArrayList<Restaurant> arr = (ArrayList<Restaurant>)new RestaurantDAOimpl().getRestaurantsByLocation(cityName); %>
  
      <section class="restaurants">
              
            <h2 class="heading"> Explore Restaurants in <%=cityName %></h2>
            <div class="restaurant-group">
                
            <%for(Restaurant res:arr){%>
            	
                  	
                  <% ArrayList<Menu> arr1 = (ArrayList<Menu>)new MenuDAOimpl().getResItems(res.getRestaurant_id()); %>
                 
                     <div class="restaurant">
                    
                  <img src="<%= res.getImgpath() %>" alt="Image">
                   
                   <div class="description">

                      <h4><%=res.getName().toUpperCase()%></h4>

                          <span class="rating">
                             <img src="rating.png"> 
                              <p><%=res.getRatings()%></p>
                              <li><%=res.getDelivery_time()%> mins</li>
                          </span>
                         <div class="info">

                            
                            <p class="items"> <%for(Menu item:arr1){%>
                            
                            	<%= item.getItem_name().substring(0,1).toUpperCase()+item.getItem_name().substring(1) %>,
                            	
                            
                          <% }  %>
                      
                            </p>
                            
                            
                             <p class="address"> <%=res.getCityname().substring(0, 1).toUpperCase()+res.getCityname().substring(1)%></p> 
                         </div>
                   
                      
                       
                   </div>

                </div>
                <% }%>


  </div>
          
       
   </section>
   

   
      
</body>
</html>

                 
             
             
             
             
             
             
             
             
             
             
             
             
             
                 
     
        