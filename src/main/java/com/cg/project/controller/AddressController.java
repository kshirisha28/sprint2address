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
import com.cg.project.service.AddressService;
@RestController
@CrossOrigin("*")

public class AddressController {

	@Autowired
	AddressService addressService;

	@GetMapping("address")
	public ResponseEntity<List<Address>> findAllAddress() throws AddressException
	{
		List<Address> list = addressService.findAllAddress();
		ResponseEntity<List<Address>>  rt = new ResponseEntity<List<Address>>(list,HttpStatus.OK);
		return rt;
			}
	
	@GetMapping("address/{id}")
	public ResponseEntity<Address> findAllAddressId(@PathVariable("id")  int id) throws AddressException 	{
		Address  addresses = addressService.findAllAddressId(id);
		   ResponseEntity<Address>  tr = new ResponseEntity<>(addresses,HttpStatus.OK);
		   return tr;
		
	}
	
	@PostMapping("address/customer/{id}")
	public ResponseEntity<Address> createAddress(@PathVariable("id") int customerId,@RequestBody Address address) throws AddressException
	{
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		address.setCustomer(customer);
		Address addr =addressService.createAddress(address);
		ResponseEntity<Address>  re = new ResponseEntity<Address>(addr,HttpStatus.OK);

		return re;
	}
	
	@DeleteMapping("address/{id}")
	public ResponseEntity<Address> deleteAddressById(@PathVariable("id") int addressId) throws AddressException
	{

		ResponseEntity<Address>  rt = null;
		
		
		Address re = addressService.deleteAddressById(addressId);
		rt= new ResponseEntity<Address>(re,HttpStatus.OK);
		
		return rt;
	}
	
	@PutMapping("address/addressId/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") int addressId,@RequestBody Address address) throws AddressException
	{
		address.setAddressDoor(address.getAddressDoor());
		address.setAddressCity(address.getAddressCity());
		address.setAddressState(address.getAddressState());
		address.setAddressZip(address.getAddressZip());
		Address addr =addressService.updateAddress(addressId, address);
		ResponseEntity<Address>  re = new ResponseEntity<Address>(addr,HttpStatus.OK);

		return re;
	}
	
	@GetMapping("address/customer/{id}")
public ResponseEntity<List<Address>> getAllAddressOfCustomer(@PathVariable("id") int customerId) 
{
		List<Address> list=addressService.getAllAdressOfCustomer(customerId);
		ResponseEntity<List<Address>>  re = new ResponseEntity<List<Address>>(list,HttpStatus.OK);	
	return re;
}
}
	

