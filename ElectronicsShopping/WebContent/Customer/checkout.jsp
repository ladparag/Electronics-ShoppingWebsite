<%@ page import="com.electronicshop.pojo.*,java.util.*"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Customer Checkout</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
<script>
function myFunction() {
    window.print();
}
</script>

<style type="text/css">


@media print
{
.noprint {display:none;}
}

@media screen
{
...
}

</style>




</head>
<body>
<div id="main_container">
  <div class="top_bar" class="noprint">
    <div class="top_search">
     <!--  <div class="search_text"></div> -->
      <form method="get" action="../ProductViewEditDeleteServlet">
      <input type="hidden" name="action" value="CustomerSearch">
     &nbsp; <input type="text" class="search_input" name="itemName" id="itemName"/>&nbsp;
       <input  type="submit" name="submit" value="Search">
      
     </form>
    </div>
    <div class="languages" class="noprint">
      <div class="lang_text" class="noprint">Languages:</div>
      <a href="#" class="lang"><img src="images/en.gif" alt="" border="0" /></a> <a href="#" class="lang"><img src="images/de.gif" alt="" border="0" /></a> </div>
  </div>
  <div id="header" class="noprint" >
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
        <div class="oferta_pagination" class="noprint"> <span class="current">1</span> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> </div>
      </div>
      <div class="top_divider" class="noprint"><img src="images/header_divider.png" alt="" width="1" height="164" /></div>
    </div>
    <!-- end of oferte_content-->
  </div>
  <div id="main_content">
    <div id="menu_tab" class="noprint">
      <div class="left_menu_corner"></div>
      <ul class="menu">
        <li><a href="../CustomerCategory" class="nav1"> Home</a></li>
        <li class="divider"></li>
        <li><a href="../AllProductCustomerServlet" class="nav2">Products</a></li>
        <li class="divider"></li>
      <%String Name=(String)session.getAttribute("welcomeuser"); %>
        <li><a href="../CustServlet?action=editCustomer&userName=<%=Name %>" class="nav4">Edit Profile</a></li>
       	
       	<li class="divider"></li>
        <li><a href="../CartServlet" class="nav5">Cart</a></li> 
        <li class="divider"></li>
         <%String uName=(String)session.getAttribute("welcomeuser"); %>
         <li><a href="../CustomerOrderCart?userName=<%=uName %>" class="nav5">Order Product</a></li> 
        <li class="divider"></li>
        <li><a href="Logout.jsp" class="nav6">Logout</a></li>
        
      </ul>
      <div class="right_menu_corner"></div>
    </div>
    <!-- end of menu tab -->
    <div class="crumb_navigation" class="noprint"> Navigation: <span class="current" class="noprint">Home</span> </div>
    <div class="left_content" class="noprint">
      <div class="title_box" class="noprint">Categories</div>
      <ul class="left_menu" class="noprint">
         <c:forEach items="${catlist}" var="cat">
        <li class="odd" ><a href="../CustomerCategory?action=getCustomerProductByCategory&catName=${cat.catName}">${cat.catName}</a></li>
        
         </c:forEach>
      </ul>
      <div class="title_box" class="noprint">Special Products</div>
      <div class="border_box" class="noprint">
        <div class="product_title" class="noprint"><a href="#">Motorola 156 MX-VL</a></div>
        <div class="product_img" class="noprint"><a href="#"><img src="images/laptop.png" alt="" border="0" /></a></div>
        <div class="prod_price" class="noprint"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
     
      <div class="banner_adds" class="noprint"> <a href="#"><img src="images/bann2.jpg" alt="" border="0" /></a> </div>
    </div>
    <!-- end of left content -->
    <div class="center_content">
      <%String userName=(String)session.getAttribute("welcomeuser"); %>
      <h2><span style="color: #003300"><font color="red"><blink><center> WELCOME ! <%=userName %> </center></blink></font></span></h2>
      <form action="../CheckoutServlet" method="post">
    <table width="100%" border="1" bordercolor="#003300">
	<tr>

		
		<td bgcolor="#006666" class="style10 style3"><strong>ItemName</strong></td>
		<td bgcolor="#006666" class="style10 style3"><strong>Quantity</strong></td>
		<td bgcolor="#006666" class="style10 style3"><strong>Price</strong></td>
		<td bgcolor="#006666" class="style10 style3"><strong>Total</strong></td>
		<td bgcolor="#006666" class="style10 style3"><strong>OrderDate</strong></td>
		<td bgcolor="#006666" class="style10 style3"><strong>Email</strong></td>
		
	</tr>
	

<%

List list=(List)session.getAttribute("list");

Cart k=new Cart();
if(list!=null && list.size()>0)
{
for(int i=0;i<list.size();i++)
{
 k=(Cart)list.get(i);	

%>
	<tr>

		
		<td class="style3">
		<input type="hidden" name="custId"  value="<%=k.getCustId() %>" />	
		<div align="left" class="style9 style5"><strong><%=k.getItemName() %></strong></div>
		<input type="hidden" name="itemName"  value="<%=k.getItemName() %>" />
		</td>
		
		<td class="style3">
		<div align="left" class="style9 style5"><strong><%=k.getQuantity() %></strong></div>
		<input type="hidden" name="quantity"  value="<%=k.getQuantity() %>" />
		</td>
		
		<td class="style3">
		<div align="left" class="style9 style5"><strong><%=k.getPrice() %></strong></div>
		<input type="hidden" name="price"  value="<%=k.getPrice() %>" />
		</td>
		
		<td class="style3">
		<div align="left" class="style9 style5"><strong><%=k.getTotal() %></strong></div>
		<input type="hidden" name="total"  value="<%=k.getTotal()%>" />
		</td>
		
		<td class="style3">
		<div align="left" class="style9 style5"><strong><%=k.getOrderDate() %></strong></div>
		<input type="hidden" name="orderdate"  value="<%=k.getOrderDate() %>" />
		</td>
		
		<td class="style3">
		<div align="left" class="style9 style5"><strong><%k.getEmail();  %></strong></div>
		<input type="hidden" name="email"  value="<%=k.getEmail() %>" />
		</td>
		
		
		
		</tr>
	
				<%
}
}	
	%>

</table>

<table width="100%" border="1" cellspacing="3" cellpadding="3">
<%List list1=(List)session.getAttribute("l");



Cart k1=new Cart();
if(list1!=null && list1.size()>0)
{
for(int i=0;i<list1.size();i++)
{
 k1=(Cart)list1.get(i);	

%>
<tr>
		<td><div align="right"></div><B><h3>TotalQuantity=<%=k1.getTotalQuantity() %></h2></B></td>
		</tr>
		
		<tr>
		<td><div align="right"></div><B><h3>Total=<%=k1.getFinalTotal() %></h2></B></td>
		</tr>
<%}} %>

		</table>
		
		<table width="100%" border="1" cellspacing="3" cellpadding="3">
		 <%  List list2=(List)session.getAttribute("editlist");
      
      Customer customer=new Customer();
      if(list2 !=null && list2.size()>0)
      {
      for(int i=0;i<list2.size();i++)
      {
      customer=(Customer)list2.get(i); 
     

%>
<tr>
		<td><div align="right"></div><B><h3>Address=<%=customer.getAddr()%></h2></B></td>
		</tr>
		
		<tr>
		<td><div align="right"></div><B><h3>City=<%=customer.getCity()%></h2></B></td>
		</tr>
		<tr>
		<td><div align="right"></div><B><h3>Mobile=<%=customer.getMobile()%></h2></B></td>
		</tr>
<%}} %>
		
		</table>
		 <tr>
          <td>&nbsp;</td>
          <td><label>
            <input type="submit" name="button" id="button" value="Process To Order" />
          </label></td>
          <td>
          <button onclick="myFunction()">Print Order placed</button></td>
        </tr>	
   
    
     
      </form>
      
    </div>
    <!-- end of center content -->
    <div class="right_content" class="noprint">
     <!--  <div class="shopping_cart">
        <div class="cart_title">Shopping cart</div>
        <div class="cart_details"> 3 items <br />
          <span class="border_cart"></span> Total: <span class="price">350$</span> </div>
        <div class="cart_icon"><a href="#" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="images/shoppingcart.png" alt="" width="48" height="48" border="0" /></a></div>
      </div> -->
      <div class="title_box" class="noprint" >What’s new</div>
      <div class="border_box" class="noprint">
        <div class="product_title" class="noprint"><a href="#">Motorola 156 MX-VL</a></div>
        <div class="product_img" class="noprint"><a href="#"><img src="images/p2.gif" alt="" border="0" /></a></div>
        <div class="prod_price" class="noprint"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
     
  </div>
  <!-- end of main content -->
  <div class="footer" class="noprint">
    <div class="left_footer" class="noprint"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div>
    <div class="center_footer" class="noprint">  All Rights Reserved 2008<br />
      <br />
      <img src="images/payment.gif" alt="" /> </div>
    <div class="right_footer" class="noprint" > <a href="index.jsp">home</a> <a href="#">about</a>  <a href="contactus.jsp">contact us</a> </div>
  </div>
</div>
<!-- end of main_container -->
</body>
</html>
