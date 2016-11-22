package com.electronicshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.dao.ShoppingInterface;
import com.electronicshop.pojo.Cart;
import com.electronicshop.pojo.Orders;
import com.electronicshop.pojo.Product;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/CancelOrderServlet")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in do get");
		
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int cartId=Integer.parseInt(request.getParameter("cartId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String itemName = request.getParameter("itemName");
		System.out.println("in cancel process");
		System.out.println(itemName);

		Orders o=new Orders();
		o.setQuantity(quantity);
		Cart c =new Cart();
		
		
		c.setCartId(cartId);
		
		Product p=new Product();
		p.setItemName(itemName);
		
		ShoppingInterface si=new ShoppingImpl();
		if(si.updateProductWhenDeletedFromOrders(p))
		{
			ShoppingInterface so=new ShoppingImpl();
			System.out.println("inside the update deleted orders");
			if(so.deleteOrderByCustomer(cartId)){
				
				System.out.println("inside delete orders");
				
				response.sendRedirect("CustomerOrderCart");
				return;
			}
			
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String itemName = request.getParameter("itemName");
		System.out.println("in cancel process");
		System.out.println(itemName);
		System.out.println("in do post");
		doGet(request, response);
	}

}
