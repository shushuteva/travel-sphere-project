package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.exceptions.*;
import com.travelsphere.travelsphere.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer createCustomer(Customer customer) throws CustomerException;

    public Customer getCustomer(Integer cusId,String key)throws CustomerException, LoginException;

    public List<Customer> ViewAllCustomer(String key)throws CustomerException, LoginException;

    public Customer updatecustomer(Customer customer,String key)throws CustomerException, LoginException;

    public Customer DeleteCustomer(Integer customer_id,String key)throws CustomerException, LoginException;

}
