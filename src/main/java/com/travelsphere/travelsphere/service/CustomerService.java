package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.CustomerDto;
import com.travelsphere.travelsphere.exceptions.CustomerException;
import com.travelsphere.travelsphere.exceptions.LoginException;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto) throws CustomerException;

    CustomerDto getCustomer(Integer customerId, String key) throws CustomerException, LoginException;

    List<CustomerDto> viewAllCustomers(String key) throws CustomerException, LoginException;

    CustomerDto updateCustomer(CustomerDto customerDto, String key) throws CustomerException, LoginException;

    CustomerDto deleteCustomer(Integer customerId, String key) throws CustomerException, LoginException;
}
