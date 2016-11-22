<%@ page language="java"  import="com.electronicshop.dao.*,com.electronicshop.pojo.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Customer InsertCart</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
<script>
function validate()
{ 
	 var qty=document.form1.quantity.value;
	 var stk=document.form1.stocks.value;
	if(document.form1.quantity.value=="")
		{
			alert("Quantity should not be blank");
			return false;
		}
	else if(document.form1.quantity.value==0)
		{
			alert("Quantity should not be 0");
				return false;
		}
	else if(parseInt(qty)>parseInt(stk))
		{
		alert("Stock not availble");
		return false;

		}


	}


</script>

</head>
<body>
<div id="main_container">
  <div class="top_bar">
   <div class="top_search">
     <!--  <div class="search_text"></div> -->
      <form method="get" action="../ProductViewEditDeleteServlet">
      <input type="hidden" name="action" value="CustomerSearch">
     &nbsp; <input type="text" class="search_input" name="itemName" id="itemName"/>&nbsp;
       <input  type="submit" name="submit" value="Search">
      
     </form>
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
    <div class="crumb_navigation"> Navigation: <span class="current">Home</span> </div>
    <div class="left_content">
      <div class="title_box">Categories</div>
      <ul class="left_menu">
         <c:forEach items="${catlist}" var="cat">
        <li class="odd" ><a href="../CustomerCategory?action=getCustomerProductByCategory&catName=${cat.catName}">${cat.catName}</a></li>
        
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
      <%String userName=(String)session.getAttribute("welcomeuser"); %>
      <h2><span style="color: #003300"><font color="red"><blink><center> WELCOME ! <%=userName %></center> </blink></font></span></h2>
      
    
     <form id="form1" name="form1" method="post" action="../AddCartServlet" onsubmit="return validate()";>
    
      <%List list=(List)session.getAttribute("list");
      InsertCart t=new InsertCart();
       if(list !=null && list.size()>0)
       {
        for(int i=0;i<list.size();i++)
        {
        	t=(InsertCart)list.get(i);
        
      %>
      <table width="100%" height="450" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td bgcolor="#00b3b3" width="60px"><strong>Item Code:</strong></td>
          <td bgcolor="#00b3b3"><%=t.getItemId() %></td>
         <label>
            <input type="hidden" name="itemid" id="itemId" value="<%=t.getItemId() %>" />
            </label> 
        </tr>
        <tr>
          <td bgcolor="#00b3b3"><strong>Item Name:</strong></td>
          <td bgcolor="#00b3b3"><%=t.getItemName() %></td>
           <label>
            <input type="hidden" name="itemName" id="itemName" value="<%=t.getItemName() %>" />
            </label>
        </tr>
        <tr>
          <td bgcolor="#00b3b3"><strong>Description:</strong></td>
          <td bgcolor="#00b3b3"><%=t.getDescription() %></td>
        </tr>
        <tr>
          <td bgcolor="#F1F9EC">&nbsp;</td>
          <td bgcolor="#F1F9EC"><img src="<%=t.getImage() %>" height="125px" width="125px"/></td>
        </tr>
        
        <tr>
          <td bgcolor="#00b3b3"><strong>Quantity:</strong></td>
          <td bgcolor="#00b3b3"><span id="sprytextfield1">
            <label>
            <input type="text" name="quantity" id="quantity" value="1" />
            </label>
          <span class="textfieldRequiredMsg">A value is required.</span></span></td>
        </tr>
        <tr>
          <td bgcolor="#00b3b3"><strong>Price:</strong></td>
          <td bgcolor="#00b3b3"><%=t.getPrice() %></td>
           <label>
            <input type="hidden" name="price" id="price" value="<%=t.getPrice() %>" />
            </label>
        </tr>
       
        <tr>
          <td bgcolor="#00b3b3"><strong>Total:</strong></td>
          <td bgcolor="#00b3b3"><%=t.getTotal() %></td>
           <label>
           
            <input type="hidden" name="total" id="total" value="<%=t.getTotal() %>" />
            </label>
        </tr>
         <tr>
          <td bgcolor="#00b3b3"><strong>Total available stocks</strong></td>
          <td bgcolor="#00b3b3"><%=t.getStocks() %></td>
           <label>
           
            <input type="hidden" name="stocks" id="stocks" value="<%=t.getStocks()  %>" />
            </label>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><label>
            <input type="submit" name="button" id="button" value="Add To Cart"  />
          </label></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
       <%
    
       }
      }
    %>
    </form>
   
    
     
      
      
    </div>
    <!-- end of center content -->
    <div class="right_content">
     <!--  <div class="shopping_cart">
        <div class="cart_title">Shopping cart</div>
        <div class="cart_details"> 3 items <br />
          <span class="border_cart"></span> Total: <span class="price">350$</span> </div>
        <div class="cart_icon"><a href="#" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="images/shoppingcart.png" alt="" width="48" height="48" border="0" /></a></div>
      </div> -->
      <div class="title_box">What’s new</div>
      <div class="border_box">
        <div class="product_title"><a href="#">Motorola 156 MX-VL</a></div>
        <div class="product_img"><a href="#"><img src="images/p2.gif" alt="" border="0" /></a></div>
        <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
      
  </div>
  <!-- end of main content -->
  <div class="footer">
    <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div>
    <div class="center_footer">  All Rights Reserved 2008<br />
    <br />
      <img src="images/payment.gif" alt="" /> </div>
    <div class="right_footer"> <a href="index.jsp">home</a> <a href="#">about</a>  <a href="contactus.jsp">contact us</a> </div>
  </div>
</div>
<!-- end of main_container -->
</body>
</html>
