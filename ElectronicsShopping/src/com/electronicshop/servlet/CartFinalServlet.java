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

/**
 * Servlet implementation class CartFinalServlet
 */
@WebServlet("/CartFinalServlet")
public class CartFinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartFinalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		ShoppingInterface si=new ShoppingImpl();
		List list=new ArrayList();
		list=si.getAllTotal();
		session.removeAttribute("l");
		session.setAttribute("l", list);
		
		List list1=new ArrayList();
		list1=si.getAllFinalCart();
		session.removeAttribute("list");
		session.setAttribute("list", list1);
		response.sendRedirect("Customer/checkout.jsp");
		
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
