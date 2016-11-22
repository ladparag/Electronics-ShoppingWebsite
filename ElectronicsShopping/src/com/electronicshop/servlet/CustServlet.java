package com.electronicshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.pojo.Customer;
import com.electronicshop.pojo.Product;
import com.electronicshop.utility.HibernateUtils;


/**
 * Servlet implementation class CustServlet
 */
@WebServlet("/CustServlet")
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		ShoppingImpl dao=new ShoppingImpl();
		String action=request.getParameter("action");
		System.out.println(action);
		
		
		 if(action!=null && action.equals("editCustomer"))
		{
			
			
			String userName=request.getParameter("userName");
			List<Customer> list=dao.getCustomerByUsername(userName);
			session.setAttribute("editlist",list);
			response.sendRedirect("Customer/editprofile.jsp");
			return;
		}
	
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		ShoppingImpl dao=new ShoppingImpl();
		String action=request.getParameter("action");
		System.out.println(action);
		if(action!=null && action.equalsIgnoreCase("updateCustomer"))
		{
		/*	String custId=request.getParameter("custId");
			String custName=request.getParameter("custName");
			String addr=request.getParameter("addr");
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			System.out.println(userName);
			Customer c=new Customer();
			c.setCustId(Integer.parseInt(custId));
			c.setCustName(custName);
			c.setAddr(addr);
			c.setCity(city);
			c.setEmail(email);
			c.setUserName(userName);
			c.setPassword(password);
			c.setMobile(mobile);
			System.out.println(c);
			boolean flag=dao.updateCustomer(c);
			if(flag)
			{
				response.sendRedirect("Customer/index.jsp");
				return;
			}
			else
			{
				response.sendRedirect("error.jsp");
				return;
			}*/
			
			

			System.out.println("After Submit clicked");
			String custId=request.getParameter("custId");
			String custName=request.getParameter("custName");
			String addr=request.getParameter("addr");
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			String mobile= request.getParameter("mobile");
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			System.out.println( custName+","+addr+","+city);
			
			 SessionFactory factory = HibernateUtils.getSessionFactory();
		        Session session1 = factory.openSession();
		        

				Customer cust=new Customer();
				cust.setCustId(Integer.parseInt(custId));
				cust.setCustName(custName);
				cust.setAddr(addr);
				cust.setCity(city);
				cust.setEmail(email);
				cust.setMobile(mobile);
				cust.setUserName(userName);
				cust.setPassword(password);
		 
		        Transaction tx = session1.beginTransaction();
		        session1.update(cust);
		        session1.flush();
		        tx.commit();
		        session1.close();
		        System.out.println("Success");
		        response.sendRedirect("Customer/index.jsp");
		        return;
			
			
		
	}
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
