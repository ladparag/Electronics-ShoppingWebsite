package com.electronicshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.dao.ShoppingInterface;
import com.electronicshop.pojo.Cart;
import com.electronicshop.pojo.Customer;
import com.electronicshop.pojo.Orders;
import com.electronicshop.pojo.Product;
import com.electronicshop.utility.SendEmail;



/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	    private String host;
	    private String port;
	    private String user;
	    private String pass;
	 
	    public void init() {
	        // reads SMTP server setting from web.xml file
	        ServletContext context = getServletContext();
	        host = context.getInitParameter("host");
	        port = context.getInitParameter("port");
	        user = context.getInitParameter("user");
	        pass = context.getInitParameter("pass");
	    }
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
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
		
		
		HttpSession session = request.getSession();
		int custId=Integer.parseInt(request.getParameter("custId"));
		//int itemId=Integer.parseInt(request.getParameter("itemId"));
		//System.out.println(itemId);
		
		String recipient = request.getParameter("email");
		String itemName = request.getParameter("itemName");
		System.out.println(itemName);
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity);
		float price = Float.parseFloat(request.getParameter("price"));
		float total = Float.parseFloat(request.getParameter("total"));
		
		
		List list=new ArrayList();
		
		Cart k=new Cart();
		k.setCustId(custId);
		k.setEmail(recipient);
		k.setItemName(itemName);
		k.setQuantity(quantity);
		k.setPrice(price);
		k.setTotal(total);
        String subject = "Confirmation of Order";
        String content = " Item Name:" +itemName + "  Quantity:" +quantity + "  Price:" +price +"  Total:" +total +"  Order Cancelation Link:" +"http://localhost:8087/ElectronicsShopping/Login2.jsp";
		

		ShoppingInterface si=new ShoppingImpl();
		
		 
		
		 
	    if(si.addFinalCart(custId))
		{
	    	ShoppingInterface so=new ShoppingImpl();
	    	//String ItemName=request.getParameter("itemName");
	    	//int stock=Integer.parseInt(request.getParameter("stocks"));
			//int Quantity=Integer.parseInt(request.getParameter("quantity"));
	    	
			Product p=new Product();
			Orders o=new Orders();
			//p.setStocks(stock);
			o.setQuantity(quantity);
			p.setItemName(itemName);
			
			//p.setItemId(itemId);
			if(so.updateProductWhenInsertintoCart(p))
			{
	    	
	    	
	    	try {
	    		System.out.println("in mail sending process");
	        	SendEmail.sendEmail(host, port, user, pass, recipient, subject,content);
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            
	        }
	    	
			response.sendRedirect("Customer/Welcome.jsp");
			}
		}
	    else
	    {
	    	response.sendRedirect("error.jsp");
	    }
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	}
