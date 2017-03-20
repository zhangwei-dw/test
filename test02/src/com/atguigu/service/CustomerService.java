package com.atguigu.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.atguigu.entity.Customer;
import com.google.gson.Gson;

@Path("/crm")
public class CustomerService {

	@GET
	@Path("/customer/{id}")
	@Produces("application/json")
	public Customer getCustomerById(@PathParam("id") String id  ){
		Customer customer= new Customer(id,"zhang3",22);
		
		return customer;
	}
	
	
	@POST
	@Path("/addcustomer")
	@Consumes("application/json")
	public String addCustomer(String customer_json){
		Gson gson =new Gson();
		Customer customer=  gson.fromJson(customer_json, Customer.class);
		System.out.println(customer);
		return   "success:"+customer.toString();
	}
	
	
	
}
