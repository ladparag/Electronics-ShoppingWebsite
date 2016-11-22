package com.electronicshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.dao.ShoppingInterface;
import com.electronicshop.pojo.Customer;
import com.electronicshop.utility.HibernateUtils;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
		
		String action=request.getParameter("action");
		System.out.println("Action" +action);
		if(action!=null && action.equals("Register"))
		{

			System.out.println("After Submit clicked");
			String custName=request.getParameter("custName");
			String addr=request.getParameter("addr");
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			String mobile= request.getParameter("mobile");
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			System.out.println( custName+","+addr+","+city);
			
			Customer cust=new Customer();
			cust.setCustName(custName);
			cust.setAddr(addr);
			cust.setCity(city);
			cust.setEmail(email);
			cust.setMobile(mobile);
			cust.setUserName(userName);
			cust.setPassword(password);
			 SessionFactory factory = HibernateUtils.getSessionFactory();
		        Session session = factory.openSession();
		 
		        Transaction tx = session.beginTransaction();
		        session.save(cust);
		 
		        session.flush();
		        tx.commit();
		        session.close();
		        System.out.println("Success");
				response.sendRedirect("index.jsp");
			
			
			
			/*ShoppingInterface si=new ShoppingImpl();
			System.out.println("After Interface");
			if(si.addCustomer(cust))
			{
				System.out.println("Success");
				response.sendRedirect("index.jsp");

			}
			else 
			{
				response.sendRedirect("error.jsp");

			}*/
		}
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
