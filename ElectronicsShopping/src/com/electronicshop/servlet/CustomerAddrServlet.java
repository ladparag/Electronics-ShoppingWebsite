package com.electronicshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.dao.ShoppingInterface;
import com.electronicshop.pojo.Customer;

/**
 * Servlet implementation class CustomerAddrServlet
 */
@WebServlet("/CustomerAddrServlet")
public class CustomerAddrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 HttpSession session=request.getSession();
		  int custId=Integer.parseInt(request.getParameter("custId"));
		  Customer c=new Customer();
		  c.setCustId(custId);
		  ShoppingInterface si=new ShoppingImpl();	 
		  List list=new ArrayList();
		  list=si.selectAddr(custId);
		  session.removeAttribute("ab");
		  session.setAttribute("ab", list);
		  response.sendRedirect("Admin/details.jsp");
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
