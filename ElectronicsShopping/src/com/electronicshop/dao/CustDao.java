package com.electronicshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.electronicshop.pojo.Customer;

public class CustDao {
	
	JdbcTemplate template; 
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	public List<Customer> getCustomer(){  
	    return template.query("select * from customer_registration",new RowMapper<Customer>(){  
	        public Customer mapRow(ResultSet rs, int row) throws SQLException {  
	            Customer e=new Customer();  
	            e.setCustId(rs.getInt(1));
	            e.setCustName(rs.getString(2));
	            e.setAddr(rs.getString(3));
	            e.setCity(rs.getString(4));
	            e.setEmail(rs.getString(5));
	            e.setMobile(rs.getString(6));
	            e.setUserName(rs.getString(7));
	            e.setPassword(rs.getString(8));
	            
	            return e;  
	        }  
	    });  
	}  

}
