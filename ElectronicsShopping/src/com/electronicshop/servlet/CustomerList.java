package com.electronicshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.pojo.Category;
import com.electronicshop.pojo.Customer;
import com.electronicshop.pojo.Product;

/**
 * Servlet implementation class CustomerList
 */
@WebServlet("/CustomerList")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ShoppingImpl si=new ShoppingImpl();
		String action = request.getParameter("action");
		
		if(action!=null && action.equals("getAllCustomers"))
		{
			List<Customer> custList = si.getAllCustomers();
			
			session.setAttribute("custList", custList);
			response.sendRedirect("Admin/customerList.jsp");
			return;
		}
		
		else if(action!=null && action.equals("delete"))
		{
			int custId = (Integer.parseInt(request.getParameter("custId")));
			String itemId=request.getParameter("itemId");
			boolean flag=si.deleteCustomer(custId);
			
			 if(flag==true)
			 {
				
				 List<Customer> custList = si.getAllCustomers();
				 session.removeAttribute("custList");
				 session.setAttribute("custList", custList);
				 response.sendRedirect("Admin/customerList.jsp");
				 return;
			}
			 else
			 {
				 response.sendRedirect("Admin/customerList.jsp") ;
			 }
			/*List<Customer> custList = si.getAllCustomers();
			session.removeAttribute("custList");
			session.setAttribute("custList", custList);
			response.sendRedirect("Admin/customerList.jsp");
			return;*/
		}
		else
		{
			List<Product> prodlist=si.getAllProduct();
			List<Category> catlist=si.getAllcategory();
		
		
			session.setAttribute("prodlist",prodlist);
			session.setAttribute("catlist",catlist);
			
			response.sendRedirect("index.jsp");
			
			return;
			
		}
		
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

	}
}
	

