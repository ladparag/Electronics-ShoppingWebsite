package com.electronicshop.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.electronicshop.dao.CustDao;
import com.electronicshop.pojo.Customer;

@Controller
public class CustController {
	
	 @Autowired 
	CustDao dao;
	 
	 
	 @RequestMapping("/customerList")  
	    public ModelAndView customerList(){  
	        List<Customer> list=dao.getCustomer();  
	        return new ModelAndView("customerList","list",list);  
	    }  

}
