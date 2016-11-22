package com.electronicshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.electronicshop.pojo.AddCart;
import com.electronicshop.pojo.Cart;
import com.electronicshop.pojo.Category;
import com.electronicshop.pojo.Customer;
import com.electronicshop.pojo.History;
import com.electronicshop.pojo.InsertCart;
import com.electronicshop.pojo.Orders;
import com.electronicshop.pojo.Product;
import com.electronicshop.pojo.User;
import com.electronicshop.utility.DbConnection;

public class ShoppingImpl implements ShoppingInterface {

	@Override
	public boolean addProduct(Product p) {
		
		 try{
			 
			     Connection con=DbConnection.getConnection();
			     PreparedStatement ps=con.prepareStatement("insert into products(catId,itemName,catName,description,price,stocks,image) values(?,?,?,?,?,?,?)");
			     ps.setInt(1, p.getCatId());
			     ps.setString(2, p.getItemName());
			     ps.setString(3,p.getCatName());
			     ps.setString(4, p.getDescription());
			    ps.setFloat(5, p.getPrice());
			   	 ps.setInt(6, p.getStocks());
			   	 ps.setString(7,p.getImage());
			     int x=ps.executeUpdate();
			       if(x>0)
			       {
			        return true;
			       }
			       	else
			        {
			        	return false;
			        }
			        }
					catch(Exception e)
					{
						e.printStackTrace();
					}
			        
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product p) {
		
		
		try
		{
			 Connection con=DbConnection.getConnection();
		String sql="update products set catId=?,itemName=?,catName=?,description=?,price=?,stocks=?,image=? where itemId=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setInt(1,p.getCatId());
		stmt.setString(2,p.getItemName());
		stmt.setString(3,p.getCatName());
		stmt.setString(4,p.getDescription());
		stmt.setFloat(5,p.getPrice());
		stmt.setInt(6,p.getStocks());	
		stmt.setString(7,p.getImage());
		stmt.setInt(8,p.getItemId());
		
		
		
		int x=stmt.executeUpdate();
		System.out.println(x);
		if(x>0)
		{
			return true;
			
		}
		}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		
		try
		{
			
			Connection con=DbConnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("delete from products where itemId=?");
			
			ps.setInt(1,id);
			
			int x=ps.executeUpdate();
			if(x>0)
			{
				return true;
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getAllProduct() {
		Connection con=null;
		try
		{
			 con=DbConnection.getConnection();
			Product product=null;
			List<Product> list=new ArrayList<Product>();
			String sql="select * from products";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		
		    while(rs.next())
		    {
			product=new Product();
			product.setItemId(rs.getInt("itemId"));
			product.setCatId(rs.getInt("catId"));
			product.setItemName(rs.getString("itemName"));
			product.setCatName(rs.getString("catName"));
			product.setDescription(rs.getString("description"));
			product.setImage(rs.getString("image"));
			product.setPrice(rs.getFloat("price"));
			
			product.setStocks(rs.getInt("stocks"));
		
			list.add(product);
		}
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(int itemId) {
		
		try
		{
			Connection con=DbConnection.getConnection();
			Product product=null;
			List<Product> list=new ArrayList<Product>();
			String sql="select * from products where itemId=?";
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1,itemId);
		    ResultSet rs=stmt.executeQuery();
			
		while(rs.next())
		{
			product=new Product();
			product.setItemId(rs.getInt("itemId"));
			product.setCatId(rs.getInt("catId"));
			product.setItemName(rs.getString("itemName"));
			product.setCatName(rs.getString("catName"));
			product.setDescription(rs.getString("description"));
			product.setImage(rs.getString("image"));
			product.setPrice(rs.getFloat("price"));
			product.setStocks(rs.getInt("stocks"));
			list.add(product);
		}
		return product;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public List<Product> getProductByCategory(String catName) {
		
		try
		{
			Connection con=DbConnection.getConnection();
			Product product=null;
			List<Product> catlist=new ArrayList<Product>();
			String sql="select * from products where catName=?";
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1,catName);
		    ResultSet rs=stmt.executeQuery();
		
		while(rs.next())
		{
			product=new Product();
			product.setItemId(rs.getInt("itemId"));
			product.setCatId(rs.getInt("catId"));
			product.setItemName(rs.getString("itemName"));
			product.setCatName(rs.getString("catName"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getFloat("price"));
			product.setStocks(rs.getInt("stocks"));
			product.setImage(rs.getString("image"));
			
			catlist.add(product);
		}
		return catlist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductbyName(String itemName) {
		
		try
		{
			Connection con=DbConnection.getConnection();
			Product product=null;
			List<Product> list=new ArrayList<Product>();
			
		
			String sql="SELECT * FROM products WHERE itemName LIKE CONCAT('%', ? , '%')";	
		
		
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, itemName);
		    ResultSet rs=stmt.executeQuery();
		
		while(rs.next())
		{
			product=new Product();
			product.setItemId(rs.getInt("itemId"));
			product.setCatId(rs.getInt("catId"));
			product.setItemName(rs.getString("itemName"));
			product.setCatName(rs.getString("catName"));
			product.setDescription(rs.getString("description"));
			product.setImage(rs.getString("image"));
			product.setPrice(rs.getFloat("price"));
			
			product.setStocks(rs.getInt("stocks"));
		
			list.add(product);
		}
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public boolean addCustomer(Customer c) {
		
		try{
			
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into customer_registration(custName,addr,city,email,mobile,userName,password) values(?,?,?,?,?,?,?)");
			System.out.println("Data inserted ");		
			
			ps.setString(1,c.getCustName());
			ps.setString(2,c.getAddr());
			ps.setString(3,c.getCity());
			ps.setString(4,c.getEmail());
			ps.setString(5,c.getMobile());
			ps.setString(6,c.getUserName());
			ps.setString(7,c.getPassword());
			int rs=ps.executeUpdate();
			if(rs>0)
			{

				return true;
			}
			else
			{

				return false;
			}
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}

		
		// TODO Auto-generated method stub
		return false;
	}*/

	/*@Override
	public boolean updateCustomer(Customer c) {
		try{
			
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update  customer_registration set custName=?,addr=?,city=?,email=?,mobile=?,userName=?,password=? where custId=?");
			System.out.println("Data updated ");		
			
			ps.setString(1,c.getCustName());
			ps.setString(2,c.getAddr());
			ps.setString(3,c.getCity());
			ps.setString(4,c.getEmail());
			ps.setString(5,c.getMobile());
			ps.setString(6,c.getUserName());
			ps.setString(7,c.getPassword());
			ps.setInt(8,c.getCustId());
			int rs=ps.executeUpdate();
			if(rs>0)
			{

				return true;
			}
			else
			{

				return false;
			}
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}

		
		// TODO Auto-generated method stub
		return false;
	}*/

	

	@Override
	public List<Customer> listAllCustomers() {
		
		Connection con=null;
		try
		{
			con=DbConnection.getConnection();
			Customer customer=null;
			List<Customer> list=new ArrayList<Customer>();
			String sql="select * from customer_registration";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		
		    while(rs.next())
		    {

				customer=new Customer();
				customer.setCustId(rs.getInt("custId"));
				customer.setCustName(rs.getString("custName"));
				customer.setAddr(rs.getString("addr"));
				customer.setCity(rs.getString("city"));
				customer.setEmail(rs.getString("email"));
				customer.setMobile(rs.getString("mobile"));
				customer.setUserName(rs.getString("userName"));
				customer.setPassword(rs.getString("password"));
				list.add(customer);
		}
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(int custId) {
		try
		{
		Connection con=DbConnection.getConnection();
		Customer customer=null;
		List<Customer> list=new ArrayList<Customer>();
		
		String sql="select * from customer_registration where custId=?";
		PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
		stmt.setInt(1,custId);
        ResultSet rs=stmt.executeQuery();
		
		while(rs.next())
		{
			customer=new Customer();
			customer.setCustId(rs.getInt("custId"));
			customer.setCustName(rs.getString("custName"));
			customer.setAddr(rs.getString("addr"));
			customer.setCity(rs.getString("city"));
			customer.setEmail(rs.getString("email"));
			customer.setMobile(rs.getString("mobile"));
			customer.setUserName(rs.getString("userName"));
			customer.setPassword(rs.getString("password"));
			
		}
		return customer;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomerByUsername(String userName) {
		
		try
		{
		Customer customer;
		List<Customer> list=new ArrayList<Customer>();
		Connection con=DbConnection.getConnection();
		String sql="select * from customer_registration where userName=?";
		PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
		stmt.setString(1,userName);
        ResultSet rs=stmt.executeQuery();
	
		while(rs.next())
		{
			customer=new Customer();
			customer.setCustId(rs.getInt("custId"));
			customer.setCustName(rs.getString("custName"));
			customer.setAddr(rs.getString("addr"));
			customer.setCity(rs.getString("city"));
			customer.setEmail(rs.getString("email"));
			customer.setMobile(rs.getString("mobile"));
			customer.setUserName(rs.getString("userName"));
			customer.setPassword(rs.getString("password"));
			list.add(customer);
		}
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean customerLogin(String userName, String password) {
		
		try
		{

	    Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from customer_registration where userName=? and password=?");
		//System.out.println("Data Retrived ");		
        ps.setString(1,userName);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{

			return true;
		}

		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean adminLogin(String userName, String password) {
		
		try{

            Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from admin_master where userName=? and password=?");
			//System.out.println("Data Retrived ");		
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{

				return true;
			}

		}
		catch(Exception e)
		{
			System.err.println("Error Occured..");
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public List<Category> getAllcategory() {
		
		try{

			Connection con=DbConnection.getConnection();
     	   PreparedStatement ps=con.prepareStatement("select * from  category_master");
     	   System.out.println("connection Success");
     	   ResultSet rs=ps.executeQuery();
     	   List<Category> catlist=new ArrayList<Category>();
     	   
     	   while(rs.next())
     	   {
     		  Category c=new Category();
     		  c.setCatId(rs.getInt("catId"));
     		  c.setCatName(rs.getString("catName"));
     		 catlist.add(c);
     		 System.out.println(c);
     	   }
     	   
     	   System.out.println(catlist.size());
     		   return catlist;
     	   
        }
      catch(Exception e)
      {
     	e.printStackTrace(); 
      }
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getAllOrder() {
		
		try
        {
			Connection con=DbConnection.getConnection();
     	   PreparedStatement ps=con.prepareStatement("SELECT shopping_cart_final.cartId,customer_registration.custId,customer_registration.custName,shopping_cart_final.itemName,shopping_cart_final.quantity,shopping_cart_final.price,shopping_cart_final.total FROM customer_registration,shopping_cart_final WHERE customer_registration.custId=shopping_cart_final.custId");
     	   System.out.println("connection Success");
     	   ResultSet rs=ps.executeQuery();
     	   List<Orders> list=new ArrayList<Orders>();
     	   
     	   while(rs.next())
     	   {
     		   Orders order=new Orders();
     		   order.setCartId(rs.getInt("cartId"));
     		   order.setCustId(rs.getInt("custId"));
     		   order.setCustName(rs.getString("custName"));
     		   order.setItemName(rs.getString("itemName"));
     		   order.setQuantity(rs.getInt("quantity"));
     		   order.setPrice(rs.getFloat("price"));
     		   order.setTotal(rs.getFloat("total"));
     		   list.add(order);
     		 //System.out.println(p);
     	   }
     	   System.out.println(list.size());
     		   return list;
     	   
        }
      catch(Exception e)
      {
     	e.printStackTrace(); 
      }
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAllCart() {
		
		try
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT shopping_cart.cartId,shopping_cart.itemName,shopping_cart.quantity,shopping_cart.total,products.catId,products.image FROM  shopping_cart,products WHERE  products.itemName=shopping_cart.itemName");
			ResultSet rs=ps.executeQuery();
			List<Cart> list=new ArrayList<Cart>();
			while(rs.next())
			{
			Cart c=new Cart();
			c.setCartId(rs.getInt("cartId"));
			c.setItemName(rs.getString("itemName"));
			c.setQuantity(rs.getInt("quantity"));
			c.setTotal(rs.getFloat("total"));
			c.setCatId(rs.getInt("catId"));
			c.setImage(rs.getString("image"));
			list.add(c);
			System.out.println(c);
			
			}
			System.out.println(list.size());
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<History> getAllHistory() {
		
		try
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT shopping_cart_final.itemName,shopping_cart_final.quantity,shopping_cart_final.price,shopping_cart_final.total,products.image,  FROM shopping_cart_final,products WHERE products.itemName=shopping_cart_final.itemName");
			ResultSet rs=ps.executeQuery();
			List<History> list=new ArrayList<History>();
			while(rs.next())
			{
				History h=new History();
				
				h.setItemName(rs.getString("itemName"));
				h.setQuantity(rs.getInt("quantity"));
				h.setPrice(rs.getFloat("price"));
				h.setTotal(rs.getFloat("total"));
				h.setImage(rs.getString("image"));
			
			list.add(h);
			System.out.println(h);
			
			}
			System.out.println(list.size());
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InsertCart> getAllItemRecord(int itemId) {
		
		try{

			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from products where itemId=?");
			ps.setInt(1, itemId);
			ResultSet rs=ps.executeQuery();
		    List<InsertCart> list=new ArrayList<InsertCart>();
		    while(rs.next())
		    {
		    	InsertCart i=new InsertCart();
		    	i.setItemId(rs.getInt("itemId"));
		    	i.setItemName(rs.getString("itemName"));
		    	i.setDescription(rs.getString("description"));
		    	
		    	//i.setQuantity(rs.getInt("Quantity"));
		    	i.setImage(rs.getString("image"));
		    	i.setPrice(rs.getFloat("price"));
		    	i.setStocks(rs.getInt("stocks"));
		    	//i.setTotal(rs.getFloat("total"));
		    	list.add(i);
		}
		    
		    System.out.println(list.size());
		    return list;
  	   
     }
   catch(Exception e)
   {
  	e.printStackTrace(); 
   }
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCart(AddCart c) {
		
		 try
		    {
			 	Connection con=DbConnection.getConnection();
		    	PreparedStatement ps=con.prepareStatement("select custId,userName,email from customer_registration where userName=?");
		    	ps.setString(1,c.getUserName());
		    	ResultSet rs=ps.executeQuery();
		    	int id=0;
		    	String uname=null;
		    	String emailid=null;
		    	while(rs.next())
		    	{
		    		id=rs.getInt("custId");
		    		uname=rs.getString("userName");
		    		emailid=rs.getString("email");
		    		System.out.println(id);
		    	}
		    
		        Date date = new Date();
		        java.sql.Date date2=new java.sql.Date(date.getTime());
		       
		        PreparedStatement ps1=con.prepareStatement("insert into shopping_cart(custId,userName,email,itemName,quantity,price,total,orderDate) values(?,?,?,?,?,?,?,?)");
		        
				ps1.setInt(1,id);
				ps1.setString(2,uname);
				ps1.setString(3,emailid);
		        ps1.setString(4, c.getItemName());
		        ps1.setInt(5, c.getQuantity());
		        ps1.setFloat(6, c.getPrice());
		        ps1.setFloat(7, c.getTotal());
		        ps1.setDate(8,date2);
		      
		        int x=ps1.executeUpdate();
		        if(x>0)
		        {
		        return true;	
		        }
		        else
		        {
		        	return false;
		        }
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCart(int cartId) {
		
		try
        {
			Connection con=DbConnection.getConnection();
     	   	PreparedStatement ps=con.prepareStatement("delete from shopping_cart where cartId=?");
     	   	System.out.println("connection Success");
     	   	ps.setInt(1, cartId);
     	   	System.out.println(ps);
     	   	int x=ps.executeUpdate();
     	   	if(x>0)
     	   {
     	   		
     	   	/*PreparedStatement ps1=con.prepareStatement("delete from shopping_cart_final where cartId=?");
    			ps1.setInt(1,cartId);
    			int x1=ps1.executeUpdate();
    			if(x1>0)
    			{
    			return true;
    			}*/
     		   return true;
     	   }
     	   else
     	   {
     		   return false;
     	   }
        }
      catch(Exception e)
      {
     	e.printStackTrace(); 
      }
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cart> getAllFinalCart() {
		
		 try
		  {
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select cartId,custId,email,itemName,quantity,price,total,orderDate from shopping_cart");
			ResultSet rs=ps.executeQuery();
			List<Cart> list=new ArrayList<Cart>();
			while(rs.next())
			{
			Cart c=new Cart();
			c.setCartId(rs.getInt("cartId"));
			c.setCustId(rs.getInt("custId"));
		    c.setEmail(rs.getString("email"));
			c.setItemName(rs.getString("itemName"));
			c.setQuantity(rs.getInt("quantity"));
			c.setPrice(rs.getFloat("price"));
			c.setTotal(rs.getFloat("total"));
			c.setOrderDate(rs.getString("orderDate"));
			list.add(c);
			//System.out.println(c);
			
			}
			System.out.println(list.size());
			return list;
			
		}
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }	
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAllTotal() {
		
		try
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select cartId,custId,userName,email,itemName, sum(quantity),sum(total) FinalTotal from shopping_cart group by custId;");
			ResultSet rs=ps.executeQuery();
			List<Cart> list=new ArrayList<Cart>();
			while(rs.next())
			{
			Cart c=new Cart();
			c.setCartId(rs.getInt("cartId"));
			c.setCustId(rs.getInt("custId"));
			c.setUserName(rs.getString("userName"));
			c.setEmail(rs.getString("email"));
			c.setItemName(rs.getString("itemName"));
			c.setTotalQuantity(rs.getInt("sum(quantity)"));
			c.setFinalTotal(rs.getFloat("FinalTotal"));
			list.add(c);
			System.out.println(c);
			
			}
			System.out.println(list.size());
			return list;
			
		}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addFinalCart(int custId) {
		
		try
		{
		
			Connection con=DbConnection.getConnection();
			
		PreparedStatement ps=con.prepareStatement("insert into shopping_cart_final(cartId,custId,userName,email,itemName,quantity,price,total,orderDate)  select cartId,custId,userName,email,itemName,quantity,price,total,orderDate from shopping_cart where custId=?");
	    ps.setInt(1,custId);
	  //  ps.setString(2,email );
		int x=ps.executeUpdate();
		if(x>0)
		{
			
			PreparedStatement ps1=con.prepareStatement("delete from shopping_cart where custId=?");
			ps1.setInt(1,custId);
			int x1=ps1.executeUpdate();
			if(x1>0)
			{
			return true;
			}
		} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> selectAddr(int custId) {
		try
		{

			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customer_registration where custId=?");
			ps.setInt(1,custId);
			ResultSet rs=ps.executeQuery();
		    
		    List<Customer> list=new ArrayList<Customer>();
		    while(rs.next())
		    {
		    Customer c=new Customer();
		    c.setCustName(rs.getString("custName"));
		    c.setAddr(rs.getString("addr"));
		    c.setCity(rs.getString("city"));
		    c.setEmail(rs.getString("email"));
		    c.setMobile(rs.getString("mobile"));
		    
		    list.add(c);
		   System.out.println(c);
		}
  	   System.out.println(list.size());
  		   return list;
  	   
     }
   catch(Exception e)
   {
  	e.printStackTrace(); 
   }
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Product> getAllProduct(int catId) {
		
		try
        {
 
			Connection con=DbConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("SELECT * FROM products where catId=?");
     	   ps.setInt(1,catId);
     	   //System.out.println("connetion Success");
     	   ResultSet rs=ps.executeQuery();
     	   List<Product> list=new ArrayList<Product>();
     	   
     	   while(rs.next())
     	   {
     		   Product p=new Product();
     		   p.setItemId(rs.getInt("itemId"));
     		   p.setCatId(rs.getInt("catId"));
     		   p.setItemName(rs.getString("itemName"));
     		   p.setDescription(rs.getString("description"));
     		   p.setImage(rs.getString("image"));
     		   p.setPrice(rs.getFloat("price"));
     		   p.setStocks(rs.getInt("stocks"));
     		  	  
     		  list.add(p);
     		 //System.out.println(p);
     	   }
     	   System.out.println(list.size());
     		   return list;
     	   
        }
      catch(Exception e)
      {
     	e.printStackTrace(); 
      }
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOrderByCartId(int cartId) {
		
		try
        {
			Connection con=DbConnection.getConnection();
     	   	PreparedStatement ps=con.prepareStatement("delete from shopping_cart_final where cartId=?");
     	   	System.out.println("connection Success");
     	   	ps.setInt(1, cartId);
     	   	System.out.println(ps);
     	   	int x=ps.executeUpdate();
     	   	if(x>0)
     	   {
     		   return true;
     	   }
     	   else
     	   {
     		   return false;
     	   }
        }
      catch(Exception e)
      {
     	e.printStackTrace(); 
      }
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Orders> getAllCartOrder(String userName) {
		// TODO Auto-generated method stub
		
		try
        {
 
			Connection con=DbConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("SELECT * FROM shopping_cart_final where userName=?");
     	   ps.setString(1,userName);
     	   //System.out.println("connetion Success");
     	   ResultSet rs=ps.executeQuery();
     	   List<Orders> list=new ArrayList<Orders>();
     	   
     	   while(rs.next())
     	   {
     		  Orders p=new Orders();
     		  p.setCartId(rs.getInt("cartId"));
     		  p.setCustId(rs.getInt("custId"));
     		 
     		   p.setItemName(rs.getString("itemName"));
     		   p.setQuantity(rs.getInt("quantity"));
     		   p.setPrice(rs.getFloat("price"));
     		   p.setTotal(rs.getInt("total"));
     		 
     		  	  
     		  list.add(p);
     		 //System.out.println(p);
     	   }
     	   System.out.println(list.size());
     		   return list;
     	   
        }
      catch(Exception e)
      {
     	e.printStackTrace(); 
      }
		
		
		
		
		return null;
	}

	@Override
	public boolean deleteOrderByCustomer(int cartId) {
		// TODO Auto-generated method stub
		
		try
        {
			Connection con=DbConnection.getConnection();
     	   	PreparedStatement ps=con.prepareStatement("delete from shopping_cart_final where cartId=?");
     	   	System.out.println("in delete order by customer");
     	   	ps.setInt(1, cartId);
     	   	System.out.println(ps);
     	   	int x=ps.executeUpdate();
     	 	System.out.println(x);
     	   	if(x>0)
     	   {
     		   return true;
     	   }
     	   else
     	   {
     		   return false;
     	   }
        }
      catch(Exception e)
      {
     	e.printStackTrace(); 
      }
		return false;
	}


	
public boolean updateProductWhenInsertintoCart(Product p) {
		
		
		try
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select shopping_cart_final.quantity, products.stocks from shopping_cart_final,products where shopping_cart_final.itemName=products.itemName");
			//ps.setString(1,p.getItemName());
			ResultSet rs=ps.executeQuery();
			int qty=0;
			int prod=0;
			System.out.println(rs);
			while(rs.next())
			{
				System.out.println("in while loop");
				qty=rs.getInt("quantity");
				prod=rs.getInt("stocks");
				System.out.println("quantity "+qty);
				System.out.println("stocks "+prod);
				p.setDiff(prod-qty);
				int d = p.getDiff();
				System.out.println("Difference :" +d );
			}

			String sql="Update products set stocks=? where itemName=?";
			PreparedStatement ps1=con.prepareStatement(sql);
			
			ps1.setInt(1, p.getDiff());
            ps1.setString(2, p.getItemName());
			//ps1.setInt(1,p.getStocks());
            System.out.println("in update query");

			int x=ps1.executeUpdate();
			System.out.println("after update exec");
			if(x>0)
			{
			return true;	
			}
			else
			{
				return false;
			}
		}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		// TODO Auto-generated method stub
		return false;
	}

public boolean updateProductWhenDeletedFromOrders(Product p) {
	
	
	try
	{
		System.out.println("in try block");
		Connection con=DbConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select shopping_cart_final.quantity, products.stocks from shopping_cart_final,products where shopping_cart_final.itemName=products.itemName ");
		//ps.setString(1,p.getItemName());
		ResultSet rs=ps.executeQuery();
		int qty=0;
		int prod=0;
		System.out.println(rs.next());
		int size =0;  
        if (rs != null)   
        {  
            rs.beforeFirst();  
            rs.last();  
        size = rs.getRow();
        }
        for (int i =0;i<size;i++){
	
			System.out.println("in for loop");
			qty=rs.getInt("quantity");
			prod=rs.getInt("stocks");
			System.out.println("quantity "+qty);
			System.out.println("stocks "+prod);
			
		    p.setAdd(prod+qty);
			
			int a= p.getAdd();
			//System.out.println("Difference :" +d );
			System.out.println("Stocks updated after cancel order:" +a);
		}

		String sql="Update products set stocks=? where itemName=?";
		PreparedStatement ps1=con.prepareStatement(sql);
		
		
		ps1.setInt(1, p.getAdd());
		System.out.println(p.getAdd());
		
        ps1.setString(2, p.getItemName());
        System.out.println(p.getItemName());
        
        System.out.println("in cancel order update query");

		int y=ps1.executeUpdate();
		System.out.println("after update exec");
		if(y>0)
		{
		System.out.println("true");	
		return true;	
		}
		else
		{
			System.out.println("false");
			return false;
		}
	}

catch(Exception e)
{
	e.printStackTrace();
}

	// TODO Auto-generated method stub
	return false;
}
	
@Override
public boolean deleteCustomer(int CustId) {
	
	String sql="Delete from customer_registration Where custId=?";
	
	Connection conn = DbConnection.getConnection();
	try {
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setInt(1, CustId);
		int x=prep.executeUpdate();
		if(x>0)
     	   {
     		   return true;
     	   }
     	   else
     	   {
     		   return false;
     	   }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
	
}

@Override
public List<Customer> getAllCustomers() {
	
	
	
	try {
		Connection con=DbConnection.getConnection();
		List<Customer> custList = new ArrayList<Customer>();
		String sql= "select * from customer_registration";
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		//PreparedStatement prep = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Customer c= new Customer();
			c.setCustId(rs.getInt("custId"));
			c.setCustName(rs.getString("custName"));
			c.setAddr(rs.getString("addr"));
			c.setCity(rs.getString("city"));
			c.setEmail(rs.getString("email"));
			c.setMobile(rs.getString("mobile"));
			c.setUserName(rs.getString("userName"));
			c.setPassword(rs.getString("password"));
			
		    custList.add(c);
		    
		    //return custList;
		}
		return custList;
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}




}
	







