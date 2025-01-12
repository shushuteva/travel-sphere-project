package com.travelsphere.travelsphere.service;

import com.travelsphere.travelsphere.dto.CustomerDto;
import com.travelsphere.travelsphere.exceptions.CustomerException;
import com.travelsphere.travelsphere.exceptions.LoginException;
import com.travelsphere.travelsphere.mapper.CustomerMapper;
import com.travelsphere.travelsphere.model.CurrentSession;
import com.travelsphere.travelsphere.model.Customer;
import com.travelsphere.travelsphere.repository.CustomerRepo;
import com.travelsphere.travelsphere.repository.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) throws CustomerException {
        Customer existingCustomer = customerRepo.findByEmail(customerDto.getEmail());
        if (existingCustomer != null) {
            throw new CustomerException("Customer already exists with this email");
        }

        Customer customer = customerMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepo.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomer(Integer customerId, String key) throws CustomerException, LoginException {
        validateAdminSession(key);

        Customer customer = customerRepo.findById(customerId).orElseThrow(() ->
                new CustomerException("No customer found with ID: " + customerId));

        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDto> viewAllCustomers(String key) throws CustomerException, LoginException {
        validateAdminSession(key);

        List<Customer> customers = customerRepo.findAll();
        if (customers.isEmpty()) {
            throw new CustomerException("No customers available");
        }

        return customers.stream().map(customerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, String key) throws CustomerException, LoginException {
        validateSession(key);

        Customer customer = customerRepo.findById(customerDto.getUserId()).orElseThrow(() ->
                new CustomerException("No customer found with ID: " + customerDto.getUserId()));

        customer.setCustomerName(customerDto.getCustomerName());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        customer.setMobile(customerDto.getMobile());

        Customer updatedCustomer = customerRepo.save(customer);
        return customerMapper.toDto(updatedCustomer);
    }

    @Override
    public CustomerDto deleteCustomer(Integer customerId, String key) throws CustomerException, LoginException {
        validateSession(key);

        Customer customer = customerRepo.findById(customerId).orElseThrow(() ->
                new CustomerException("No customer found with ID: " + customerId));

        customerRepo.delete(customer);
        return customerMapper.toDto(customer);
    }

    private void validateSession(String key) throws LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() ->
                new LoginException("Invalid session key"));
    }

    private void validateAdminSession(String key) throws LoginException {
        CurrentSession currentSession = sessionRepo.findByUuid(key).orElseThrow(() ->
                new LoginException("Invalid session key"));

        if (!"ADMIN".equals(currentSession.getUserType())) {
            throw new LoginException("You are not authorized");
        }
    }
}
