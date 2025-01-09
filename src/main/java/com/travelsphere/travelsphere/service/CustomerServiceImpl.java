package com.travelsphere.travelsphere.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.travelsphere.travelsphere.exceptions.*;

import com.travelsphere.travelsphere.model.*;

import com.travelsphere.travelsphere.repository.CustomerRepo;
import com.travelsphere.travelsphere.repository.SessionRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Override
    public Customer createCustomer(Customer customer) throws CustomerException {
        // TODO Auto-generated method stub


        //we need to resolve enum issue
        Customer existingCustomer=customerRepo.findByEmail(customer.getEmail());

        if(existingCustomer!=null) throw new CustomerException("Customer already Exists With this Email");



        Customer saveCustomer=customerRepo.save(customer);


        return saveCustomer;

    }

    @Override
    public Customer getCustomer(Integer cusId,String key) throws CustomerException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");

        if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");



        Optional<Customer> opt=customerRepo.findById(cusId);
        if(opt.isPresent()) {
            Customer customer=opt.get();

            return customer;
        }else
            throw new CustomerException("No customer Found");


    }

    @Override
    public List<Customer> ViewAllCustomer(String key) throws CustomerException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");

        if(!currentSession.getUserType().equals("ADMIN")) throw new LoginException("You are not authorized");



        List<Customer> customers=customerRepo.findAll();

        if(customers.size()==0)
            throw new CustomerException("There is no Customer");

        else
            return customers;


    }

    @Override
    public Customer updatecustomer(Customer customer,String key) throws CustomerException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");





        Optional<Customer> opt=customerRepo.findById(customer.getUserId());

        if(opt.isPresent()) {

            customerRepo.save(customer);
            return customer;
        }else
            throw new CustomerException("No Customer Found");


    }

    @Override
    public Customer DeleteCustomer(Integer customer_id,String key) throws CustomerException, LoginException {

        CurrentSession currentSession=	sessionRepo.findByUuid(key);
        if(currentSession==null) throw new LoginException("Please enter valid key ");



        // WE NEED TO LOOK INTO IT

        Optional<Customer> opt=customerRepo.findById(customer_id);

        if(opt.isPresent()) {

            Customer ExistingCustomer=opt.get();
            customerRepo.delete(ExistingCustomer);

            return ExistingCustomer;
        }else
            throw new CustomerException("No Customer Found");
    }





}
