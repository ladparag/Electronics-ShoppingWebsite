package com.electronicshop.dao;

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

public interface ShoppingInterface {
	
	    //about product
		public boolean addProduct(Product p);
		public boolean updateProduct(Product p);
		public boolean deleteProduct(int id);
		List<Product> getAllProduct();
		Product getProductById(int itemId);
		List<Product> getProductByCategory(String catName);
		List<Product> getProductbyName(String itemName);
		public List<Product> getAllProduct(int catId);
		 
		//about customer
        List<Customer> getCustomerByUsername(String userName);
        public Customer getCustomerById(int custId);
        public List<Customer> listAllCustomers();
	    public List<Customer> selectAddr(int custId);
	    List<Customer> getAllCustomers();
	    public boolean deleteCustomer(int CustId);
	
	    //about login
        public boolean adminLogin(String userName, String password);
        public boolean customerLogin(String userName, String password);
	
   
	    //about category
        public List<Category> getAllcategory();
	
        //about Orders
        public List<Orders> getAllOrder();
        public List<Cart> getAllCart();
        public List<InsertCart> getAllItemRecord(int itemId);
        public boolean addCart(AddCart c);
        public boolean deleteCart(int cartId);
        public List<Cart> getAllFinalCart();
        public List<Cart> getAllTotal();
        public boolean addFinalCart(int custId);
        public boolean deleteOrderByCartId(int cartId);
        
        public boolean deleteOrderByCustomer(int cartId);
        public boolean updateProductWhenInsertintoCart(Product p);
        public boolean updateProductWhenDeletedFromOrders(Product p);
        public List<Orders> getAllCartOrder(String userName);
        public List<History> getAllHistory();
  
    
	

}
