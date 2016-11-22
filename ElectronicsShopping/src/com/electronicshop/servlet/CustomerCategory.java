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
import com.electronicshop.pojo.Product;

/**
 * Servlet implementation class CustomerCategory
 */
@WebServlet("/CustomerCategory")
public class CustomerCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCategory() {
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
		
		if(action!=null && action.equals("getCustomerProductByCategory"))
		{
			String catName=request.getParameter("catName");
			List<Product> list=dao.getProductByCategory(catName);
		
		
			session.setAttribute("list",list);
			response.sendRedirect("Customer/CustCategory.jsp");
			return;
			
		}
		
		else
		{
			
			List<Product> prodlist=dao.getAllProduct();
			List<Category> catlist=dao.getAllcategory();
		
			
			session.setAttribute("prodlist",prodlist);
			session.setAttribute("catlist",catlist);
			
			response.sendRedirect("Customer/index.jsp");
			
			
		}
		
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
