package com.electronicshop.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.electronicshop.dao.ShoppingImpl;
import com.electronicshop.pojo.Category;
import com.electronicshop.pojo.Product;
import com.electronicshop.utility.HibernateUtils;


/**
 * Servlet implementation class ProductViewEditDeleteServlet
 */
@WebServlet("/ProductViewEditDeleteServlet")
@MultipartConfig(maxFileSize = 16177215)   
public class ProductViewEditDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductViewEditDeleteServlet() {
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
		if(action!=null && action.equals("editproduct"))
		{
			String itemId=request.getParameter("itemId");
			Product product=dao.getProductById(Integer.parseInt(itemId));
		
			session.setAttribute("product",product);
			response.sendRedirect("Admin/editProduct.jsp");
			return;
			
		}
		
		else if(action!=null && action.equals("delete"))
		{
			
			String itemId=request.getParameter("itemId");
			boolean flag=dao.deleteProduct(Integer.parseInt(itemId));
			
			 
			 if(flag==true)
			 {
				
				 List<Product> prodlist=dao.getAllProduct();
			
				 session.setAttribute("prodlist",prodlist);
				 response.sendRedirect("Admin/viewproduct.jsp");
				 return;
			}
			 else
			 {
				 response.sendRedirect("error.jsp") ;
			 }
			
		}
		
		
		else if(action!=null && action.equals("ViewProductDetails"))
		{
			String itemId=request.getParameter("itemId");
			Product product=dao.getProductById(Integer.parseInt(itemId));
		
			session.setAttribute("product",product);
			response.sendRedirect("productdetails.jsp");
			return;
		}
		else if(action!=null && action.equals("custproductlist"))
		{
			 List<Product> prodlist=dao.getAllProduct();
			
			session.setAttribute("prodlist",prodlist);
			response.sendRedirect("Admin/viewproduct.jsp");
			return;
			
		}
		
	else if(action!=null && action.equals("Search"))
		{ 
			String itemName=request.getParameter("itemName");
			List<Product> list=dao.getProductbyName(itemName);
			//System.out.println(booklist);
			session.setAttribute("list",list);
			response.sendRedirect("searchview.jsp");
			return;
			
		}
		
		
		else if(action!=null && action.equals("CustomerSearch"))
		{ 
			String itemName=request.getParameter("itemName");
			List<Product> list=dao.getProductbyName(itemName);
			//System.out.println(booklist);
			session.setAttribute("list",list);
			response.sendRedirect("Customer/custsearchview.jsp");
			return;
			
		}
		
		
		
		
		else
		{
			
			List<Product> prodlist=dao.getAllProduct();
			List<Category> catlist=dao.getAllcategory();
		
		
			session.setAttribute("prodlist",prodlist);
			session.setAttribute("catlist",catlist);
			
			response.sendRedirect("index.jsp");
			
			return;
		
			
		}
	
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action=request.getParameter("action");
		//HttpSession session=request.getSession();
		ShoppingImpl dao=new ShoppingImpl();
        
    

		if(action!=null && action.equalsIgnoreCase("addProduct"))
		{
			
			String catId=request.getParameter("catId");
			String itemName=request.getParameter("itemName");
			String catName=request.getParameter("catName");
			String description=request.getParameter("description");
			System.out.println(itemName+" "+description);
			String price=request.getParameter("price");
			
			String stocks=request.getParameter("stocks");
			
			 
			String image=request.getParameter("image");
			Product p=new Product();
			p.setCatId(Integer.parseInt(catId));
			p.setItemName(itemName);
			p.setCatName(catName);
			p.setDescription(description);
			p.setPrice(Float.parseFloat(price));
			p.setStocks(Integer.parseInt(stocks));
			p.setImage(image);
		
			 SessionFactory factory = HibernateUtils.getSessionFactory();
		        Session session = factory.openSession();
		 
		        Transaction tx = session.beginTransaction();
		        session.save(p);
		 
		        session.flush();
		        tx.commit();
		        session.close();
		        System.out.println("Success");
		        response.sendRedirect("Admin/Products.jsp");
		        return;
			
		        /*boolean flag=dao.addProduct(p);
		if(dao.addProduct(p))
		{
			response.sendRedirect("Admin/Products.jsp");
			return;
		
		}
		else
		{
			response.sendRedirect("error.jsp");
			return;
		}*/
	}

		
	
		else if(action!=null && action.equalsIgnoreCase("updateProduct"))
		{
			String itemId=request.getParameter("itemId");
			String catId=request.getParameter("catId");
			String itemName=request.getParameter("itemName");
			String catName=request.getParameter("catName");
			String description=request.getParameter("description");
			String price=request.getParameter("price");
			String stocks=request.getParameter("stocks");
			String image=request.getParameter("image");
			Product p=new Product();
			p.setItemId(Integer.parseInt(itemId));
			p.setCatId(Integer.parseInt(catId));
			p.setItemName(itemName);
			p.setCatName(catName);
			p.setDescription(description);
			p.setPrice(Float.parseFloat(price));
			p.setStocks(Integer.parseInt(stocks));
			p.setImage(image);
			boolean flag=dao.updateProduct(p);
			if(flag)
			{
				response.sendRedirect("Admin/index.jsp");
				return;
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
		}
		
		// TODO Auto-generated method stub
	doGet(request, response);
	}

}
