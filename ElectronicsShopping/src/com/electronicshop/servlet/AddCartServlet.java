package com.electronicshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.pojo.AddCart;
import com.electronicshop.pojo.Product;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		ShoppingImpl dao= new ShoppingImpl();
		
		String userName=(String)session.getAttribute("welcomeuser");
		String itemName=request.getParameter("itemName");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
	    float price=Float.parseFloat(request.getParameter("price"));
	   // int stocks=Integer.parseInt(request.getParameter("stocks"));
	    float total=Float.parseFloat(request.getParameter("total"));
	   float a=price*quantity;
	 //  	int stk=stocks-quantity;
	 //  Product p=new Product();
	    AddCart c=new AddCart();
	
	    c.setUserName(userName);
	    c.setItemName(itemName);
	    c.setQuantity(quantity);

	    c.setPrice(price);
	    
	    c.setTotal(a);
	  
	  //  p.setStocks(stk);
	    System.out.println(c);
	    
	  
	   boolean bo=dao.addCart(c);
	    if(bo==true)
	    {
	    	
	    	response.sendRedirect("CartServlet");
	    	return;
	    
	    }
	    else
	    {
	    	
	     response.sendRedirect("error.jsp");	
	    }
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
