package com.bank.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;

import com.bank.domain.Customer;
import com.bank.dto.CustomerDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
//@Rollback(false)
class CustomerMapperTest {
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Test
	void debeMappearDeCustomerACustomerDTO() {
		//Arrange
		Customer customer = new Customer();
		customer.setAccounts(null);
		customer.setAddress("Avenida siempre viva 1");
		customer.setCustId(2020);
		customer.setEmail("hsimpson@gmail.com");
		customer.setEnable(true);
		customer.setName("Homer J Simpson");
		customer.setPhone("55555555");
		customer.setRegisteredAccounts(null);
		customer.setToken(UUID.randomUUID().toString().toUpperCase());
//		customer.set;
		CustomerDTO customerDTO = null;
		
		//Act
		customerDTO = customerMapper.toCustomerDTO(customer);
		
		//Assert
		assertNotNull(customerDTO);
		
		
	}
	
	@Test
	void debeMappearDeCustomerDTOaCustomer() {
		//Arrange
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setAddress("Avenida siempre viva 1");
		customerDTO.setCustId(2020);
		customerDTO.setEmail("hsimpson@gmail.com");
		customerDTO.setEnable(true);
		customerDTO.setName("Homer J Simpson");
		customerDTO.setPhone("55555555");
		customerDTO.setToken(UUID.randomUUID().toString().toUpperCase());
		customerDTO.setDotyId(1);
		Customer customer = null;
		
		//Act
		customer = customerMapper.toCustomer(customerDTO);
		
		//Assert
		assertNotNull(customer);
		
		
	}

}
