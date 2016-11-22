<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Electronix Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>
<div id="main_container">
  <div class="top_bar">
    <div class="top_search">
      <div class="search_text"><a href="#">Advanced Search</a></div>
      <input type="text" class="search_input" name="search" />
      <input type="image" src="images/search.gif" class="search_bt"/>
    </div>
    <div class="languages">
      <div class="lang_text">Languages:</div>
      <a href="#" class="lang"><img src="images/en.gif" alt="" border="0" /></a> <a href="#" class="lang"><img src="images/de.gif" alt="" border="0" /></a> </div>
  </div>
  <div id="header">
    <div id="logo"> <a href="#"><img src="images/logo.png" alt="" border="0" width="237" height="140" /></a> </div>
    <div class="oferte_content">
      <div class="top_divider"><img src="images/header_divider.png" alt="" width="1" height="164" /></div>
      <div class="oferta">
        <div class="oferta_content"> <img src="images/laptop.png" width="94" height="92" alt="" border="0" class="oferta_img" />
          <div class="oferta_details">
            <div class="oferta_title">Samsung GX 2004 LM</div>
            <div class="oferta_text"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco </div>
            <a href="#" class="details">details</a> </div>
        </div>
        <div class="oferta_pagination"> <span class="current">1</span> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> </div>
      </div>
      <div class="top_divider"><img src="images/header_divider.png" alt="" width="1" height="164" /></div>
    </div>
    <!-- end of oferte_content-->
  </div>
  <div id="main_content">
    <div id="menu_tab">
      <div class="left_menu_corner"></div>
      <ul class="menu">
        <li><a href="Admin/index.jsp" class="nav1"> Home</a></li>
        <li class="divider"></li>
        <li><a href="Admin/Products.jsp" class="nav2">Add Products</a></li>
        <li class="divider"></li>
        <li><a href="ProductViewEditDeleteServlet?action=custproductlist" class="nav2">View Products</a></li>
        <li class="divider"></li>
        <li><a href="OrderServlet" class="nav4">Orders</a></li>
         <li class="divider"></li>
        <li><a href="customerList" class="nav4">Customer List</a></li>
       
        <!-- <li class="divider"></li>
        <li><a href="#" class="nav5">Shipping</a></li> -->
        <li class="divider"></li>
        <li><a href="Admin/logout.jsp" class="nav6">Logout</a></li>
        
      </ul>
      <div class="right_menu_corner"></div>
    </div>
    <!-- end of menu tab -->
    <div class="crumb_navigation"> Navigation: <span class="current">Home</span> </div>
    <div class="left_content">
      <div class="title_box">Categories</div>
      <ul class="left_menu">
         <c:forEach items="${catlist}" var="cat">
        <li class="odd" ><a href="AdminCategory?action=getAdminProductByCategory&catName=${cat.catName}">${cat.catName}</a></li>
        
         </c:forEach>
      </ul>
      <div class="title_box">Special Products</div>
      <div class="border_box">
        <div class="product_title"><a href="#">Motorola 156 MX-VL</a></div>
        <div class="product_img"><a href="#"><img src="images/laptop.png" alt="" border="0" /></a></div>
        <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
     
      <div class="banner_adds"> <a href="#"><img src="images/bann2.jpg" alt="" border="0" /></a> </div>
    </div>
    <!-- end of left content -->
    <div class="center_content">
     <h2><span style="color:#003300"> <center>Welcome Administrator</center> </span></h2>  
     <center><p style="color:#003300;font-size:14px;">Customer List</p></center>    
     <table border="2" width="80%" cellpadding="2" align="center">  
<tr><th>Customer Id</th><th>Name</th><th>Addr</th><th>City</th><th>email</th><th>Mobile</th></tr>  
   <c:forEach var="cust" items="${list}">   
   <tr>  
   <td>${cust.custId}</td>  
   <td>${cust.custName}</td>  
   <td>${cust.addr}</td>  
   <td>${cust.city}</td>  
   <td>${cust.email}</td>  
   <td>${cust.mobile}</td>  
   </tr>  
   </c:forEach>  
   </table>  
    
   
    
     
      
      
    </div>
    <!-- end of center content -->
    <div class="right_content">
     
      <div class="title_box">What’s new</div>
      <div class="border_box">
        <div class="product_title"><a href="#">Motorola 156 MX-VL</a></div>
        <div class="product_img"><a href="#"><img src="images/p2.gif" alt="" border="0" /></a></div>
        <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
      <div class="title_box">Manufacturers</div>
      <ul class="left_menu">
        <li class="odd"><a href="#">Sony</a></li>
        <li class="even"><a href="#">Samsung</a></li>
        <li class="odd"><a href="#">Daewoo</a></li>
        <li class="even"><a href="#">LG</a></li>
        <li class="odd"><a href="#">Fujitsu Siemens</a></li>
        <li class="even"><a href="#">Motorola</a></li>
        <li class="odd"><a href="#">Phillips</a></li>
        <li class="even"><a href="#">Beko</a></li>
      </ul>
     
    </div>
    <!-- end of right content -->
  </div>
  <!-- end of main content -->
  <div class="footer">
    <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div>
    <div class="center_footer">  All Rights Reserved 2008<br />
      <br />
      <img src="images/payment.gif" alt="" /> </div>
    <div class="right_footer"> <a href="index.jsp">home</a> <a href="#">about</a> <a href="contactus.jsp">contact us</a> </div>
  </div>
</div>
<!-- end of main_container -->
</body>
</html>
