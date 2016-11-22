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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		if(type !=null && type.equals("Login2"))
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		String type=request.getParameter("rdType");
		//String customer=request.getParameter("rdtype");
		//System.out.println("Action Info "+action);
		System.out.println("Type "+type);
		
		if(action !=null && action.equals("Login"))
		{
			
		if(type!=null && type.equals("Admin"))
		{
			ShoppingInterface sf=new ShoppingImpl();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			
			Admin admin= new Admin();
			
			session.setAttribute("userName",userName);
			// boolean flag=sf.adminLogin(userName, password);
			
			
			
			//admin.setUserName(userName);
			//admin.setPassword(password);
			
			
	    //    System.out.println("After Interface");
	   	
	        if(sf.adminLogin(userName, password))
	        {
	        	response.sendRedirect("Admin/index.jsp");
	        	return;
	        	//response.sendRedirect("success.jsp");
	        	
	        }
	        else
	        {
	        	out.println("<script type=\"text/javascript\">");  
	        	out.println("alert('user name or password incorrect');");  
	        	out.println("</script>");
	        	response.sendRedirect("index.jsp");
	        }
			    

		
		// TODO Auto-generated method stub
	}
		else if(type !=null && type.equals("Customer"))
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
	        	response.sendRedirect("Customer/index.jsp");
	        	
	        	
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
		
		
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
