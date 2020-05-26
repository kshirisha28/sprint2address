package com.cg.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.project.entity.Address;
import com.cg.project.entity.Customer;
import com.cg.project.exception.AddressException;
import com.cg.project.exception.CustomerException;
import com.cg.project.service.CustomerService;
@RestController
@CrossOrigin("*")

public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("customer")
	public ResponseEntity<List<Customer>> getAllCustomers() 
	{
		List<Customer> list = customerService.getAllCustomers();
		ResponseEntity<List<Customer>>  rt = new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		return rt;
			}
	
	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> findAllCustomerId(@PathVariable("id")  int id) throws CustomerException 	{
		Customer customer = customerService.RetreiveCustomer(id);
		   ResponseEntity<Customer>  tr = new ResponseEntity<>(customer,HttpStatus.OK);
		   return tr;
		}
	
	@PostMapping("customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) 
	{
		customer.setCustomerName(customer.getCustomerName());
		Customer customers = customerService.createCustomer(customer);
		ResponseEntity<Customer>  re = new ResponseEntity<Customer>(customers,HttpStatus.OK);
            return re;
	}
	
	@DeleteMapping("customer/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") int customerId) throws CustomerException
	{

		ResponseEntity<Customer>  rt = null;
		Customer customer = customerService.deleteCustomerById(customerId);
		rt= new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
		return rt;
	}
	@PutMapping("customer/customerId/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int customerId,@RequestBody Customer customer) throws CustomerException
	{
		customer.setCustomerName(customer.getCustomerName());
		Customer customers = customerService.updateCustomer(customerId, customer);
		ResponseEntity<Customer>  re = new ResponseEntity<Customer>(customers,HttpStatus.OK);

		return re;
	}
}
