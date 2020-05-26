package com.cg;


//
//import static org.mockito.Mockito.when;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.project.dao.AddressDao;
import com.cg.project.dao.CustomerDao;
//import com.cg.project.entity.Address;
//import com.cg.project.entity.Customer;
//import com.cg.project.exception.AddressException;
//import com.cg.project.exception.CustomerException;
//import com.cg.project.service.AddressService;
//import com.cg.project.service.CustomerService;

@SpringBootTest
class AddressApplicationTests {

//	@Autowired
//	 private AddressService addressService;
//	@Autowired
//	 private CustomerService customerService;
//	
	@MockBean
	private AddressDao addressdao;
	
	@MockBean
	private CustomerDao customerdao;
	
//	@Test
//	void contextLoads() {
//	}

//	@Test
//	public void  getAddressTest() throws AddressException {
//		when(addressdao.findAll()).thenReturn (Stream.of(new Address(201,"1-23","hyderabad","telangana","501401"),new Address(202,"426-h","banglore","karnataka","532421").collect(Collectors.toList()));
//    assertEquals(2,addressService.findAllAddress().size());
//	}
//	
//	@Test
//	public void  getCustomerTest()throws CustomerException {
//		
//		when(customerdao.findAll()).thenReturn (Stream.of(new Customer(301,"sneha"),new Customer(302,"namitha")).collect(Collectors.toList()));
//		assertEquals(2,customerService.getAllCustomers().size());		
//  }
}
