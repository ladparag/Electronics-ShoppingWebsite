<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Register</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
<script>
function validate()
{
	 // event.preventDefault();
	//var custId=document.registerForm.custId.value;
 	var custName=document.registerForm.custName.value;
	var addr=document.registerForm.addr.value;
 	var city=document.registerForm.city.value;
 	var email=document.registerForm.email.value;
 	var atposition=email.indexOf("@");  
 	var dotposition=email.lastIndexOf("."); 
 	var userName=document.registerForm.userName.value;
 	var password=document.registerForm.password.value;
 	var mobile=document.registerForm.mobile.value;

	/* if(custId=="" || custId==null)
	{
		alert("please enter customer id");
		
		return false;
	}
	else */ if(custName=="" || custName==null)
    		{
    	alert("please enter customer name ");
    	return false;
    		}
	else if(addr=="" || addr==null)
	{
	alert("please enter your Address ");
	return false;
	}
	else if(city=="" || city==null)
		{
		alert("please enter your City ");
		return false;
		}
	else if(email=="" || email==null || atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length)
	{
	alert("please enter a valid Email Id ");
	return false;
	}
	else if(userName=="" || userName==null)
    {
      alert("User Name can not be left blank");
      return false;
    }
	else if(password=="" || password==null)
	{
	alert("Password should not be blank ");
	return false;
	}
	else if(mobile=="" || mobile==null || mobile.length!=10)
    	{
    	alert("enter valid Contact No.");	
    	return false;
    	}
	/* else if(isNaN(custId))
    	{
    	alert("Customer Id should be number");
    	return false;
    	
    	} */
	else if(!isNaN(custName))
	{
	alert("your name should be character");
	return false;
	}
	else  if(isNaN(mobile))
    	{
    	alert("Contact No. should be 10 digit number");
    	return false;
    	}
   
}

function validateForm(event)
{
   // event.preventDefault(); // this will prevent the submit event.
    if(document.loginform.userName.value=="")
    {
      alert("User Name can not be left blank");
      document.loginform.userName.focus();
      return false;
    }
    else if(document.loginform.password.value=="")
    {
      alert("Password can not be left blank");
      document.loginform.password.focus();
      return false;
    }
    else {
        document.loginform.submit();// fire submit event
    }
}

</script>

<style type="text/css">

.style8 {
	font-size: 24px
}

.style9 {
	font-size: 95%;
	font-weight: bold;
	color: #003300;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
<div id="main_container">
  <div class="top_bar">
    <div class="top_search">
     <!--  <div class="search_text"></div> -->
      <form method="get" action="ProductViewEditDeleteServlet">
      <input type="hidden" name="action" value="Search">
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
        <li><a href="CategoryServlet" class="nav1"> Home</a></li>
        <li class="divider"></li>
        <li><a href="AllProductMainServlet" class="nav2">Products</a></li>
        <li class="divider"></li>
       <!--  <li><a href="#" class="nav4">My account</a></li>
        <li class="divider"></li> -->
        <li><a href="Register.jsp" class="nav4">Sign Up</a></li>
        <!-- <li class="divider"></li>
        <li><a href="#" class="nav5">Shipping</a></li> -->
        <li class="divider"></li>
        <li><a href="contactus.jsp" class="nav6">Contact Us</a></li>
        
      </ul>
      <div class="right_menu_corner"></div>
    </div>
    <!-- end of menu tab -->
    <div class="crumb_navigation"> Navigation: <span class="current">Home</span> </div>
    <div class="left_content">
      <div class="title_box">Categories</div>
      <ul class="left_menu">
          <c:forEach items="${catlist}" var="cat">
        <li class="odd" ><a href="CategoryServlet?action=getProductByCategory&catName=${cat.catName}">${cat.catName}</a></li>
        
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
      <div class="center_title_bar">SignUp Here</div> 
      
            <div class="prod_box_big">
        <div class="top_prod_box_big"></div>
        <div class="center_prod_box_big">
         <form name="registerForm" action="Insert"  method="post" onsubmit="return validate();">
 <input type="hidden" name="action" value="Register">

<table border="1" width="400px" height="350px" align="center">
<!-- <tr>
<td class="tbheading">
Customer Id
</td>
<td><input class="customtxtbox"  type="text" name="custId" id="custId"><br>
</td>
</tr> -->
<tr>
<td class="tbheading">
Customer name
</td>
<td><input class="customtxtbox"  type="text" name="custName" id="custName"><br>
</td>
</tr>
<tr>
<td class="tbheading">Address
</td>
<td><input class="customtxtbox"  type="text" name="addr" id="addr"><br>
</td>
</tr>
<tr>
<td class="tbheading">City
</td>
<td><input class="customtxtbox"  type="text" name="city" id="city"><br>
</td>
</tr>
<tr>
<td class="tbheading">Email Id

</td>
<td><input class="customtxtbox" type="text" name="email" id="email"><br>
</td>
</tr>
<tr>
<td class="tbheading">
Mobile No.
</td>
<td><input class="customtxtbox" type="text" name="mobile" id="mobile"><br>
</td>
</tr>

<tr>

<td class="tbheading">
User Name
</td>
<td><input class="customtxtbox" type="text" name="userName" id="userName"><br>
</td>
</tr>
<tr>
<td class="tbheading">

Password
</td>
<td><input class="customtxtbox" type="password" name="password" id="password"><br>
</td>
</tr>


<tr>
<table border="1" width="400px" height="50px;" align="center">
<tr>
<td ><input type="submit"  value="submit"  width="40px">&nbsp;&nbsp;<input type="reset"  value="reset">
</td>
</tr>
</table>
</tr>

</table>
</form>
        
         
          
        </div>
        <div class="bottom_prod_box_big"></div>
      </div>
      
      
      
      
      
      
    
     
      
      
    </div>
    <!-- end of center content -->
    <div class="right_content">
    	<div class="title_box"><h2><blink>Login</blink></h2></div>
      <div class="border_box">
   <!--  <h2><mark><blink>Login</blink></mark></h2> -->
<div class="scroll">
<form name="loginform" method="post" action="Login" onsubmit="return validateForm(event);">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="26"><h3>User Name:</h3></td>
	</tr>
	<tr>
		<td height="30"><!-- <span id="sprytextfield1">  --><label>
		<input type="text" name="userName" id="userName" /> </label><!--  <span
			class="textfieldRequiredMsg">A value is required.</span></span> --></td>
	</tr>
	<tr>
		<td height="26"><h3>Password:</h3></td>
	</tr>
	<tr>
		<td height="31"><!-- <span id="sprytextfield2"> --> <label>
		<input type="password" name="password" id="password"> </label> <!-- <span
			class="textfieldRequiredMsg"> *</span></span>--></td>
	</tr>
	<tr>
		<td height="29"><h3>User Type:</h3></td>
	</tr>
	<tr>
		<td height="52">
		<label style="font-size:14px;font-weight:bold;"> <input type="radio" name="rdType" value="Admin"
			id="rdType_0">Admin</label> <br>
		<label style="font-size:14px;font-weight:bold;"> <input type="radio" name="rdType" value="Customer"
			id="rdType_1" checked="checked"> Customer</label> <br>
		
		</td>
	</tr>
	<tr>
		<td><label>
		<div align="center"><input type="submit" name="action" id="button" value="Login"></div>
		</label></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
  </div>
  
<h3>&nbsp;<a href="Register.jsp">NEW USER</h3>
    
    
    <!--   <div class="banner_adds"> <a href="#"><img src="images/bann1.jpg" alt="" border="0" /></a> </div> -->
    </div>
    <!-- end of right content -->
  </div>
  <!-- end of main content -->
  <div class="footer">
    <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div>
    <div class="center_footer">All Rights Reserved 2008<br />
      <br />
      <img src="images/payment.gif" alt="" /> </div>
    <div class="right_footer"> <a href="index.jsp">home</a> <a href="#">about</a> <a href="contactus.jsp">contact us</a> </div>
  </div>
</div>
<!-- end of main_container -->
</body>
</html>
