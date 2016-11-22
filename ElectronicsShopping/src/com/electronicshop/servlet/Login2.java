package com.electronicshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.dao.ShoppingInterface;
import com.electronicshop.pojo.Admin;
import com.electronicshop.pojo.Customer;

/**
 * Servlet implementation class Login2
 */
@WebServlet("/Login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		String type=request.getParameter("rdType");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("im here");
		System.out.println(action);
		System.out.println(type);
		
		if(type !=null && type.equals("Cust"))
		{
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			
			session.removeAttribute("welcomeuser");
			session.setAttribute("welcomeuser", userName);
			Customer c=new Customer();
			Admin admin= new Admin();
			//admin.setUserName(userName);
			//admin.setPassword(password);
			System.out.println(password);
			ShoppingInterface si=new ShoppingImpl();
	        System.out.println("After Interface");
	   	
	        if(si.customerLogin(userName, password))
	        {
	        	response.sendRedirect("Customer/orderCart.jsp");
	        	
	        	
	        }
	        else
	        {	
	        	out.println("<script type=\"text/javascript\">");  
	        	out.println("alert('user name or password incorrect');");  
	        	out.println("</script>");
	        	response.sendRedirect("index.jsp");
	        }
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
