/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.customerservice.services;

import com.blek.customerservice.entities.Customer;
import com.blek.customerservice.exceptions.CustomerNotFoundException;
import com.blek.customerservice.helpers.PageElement;
import com.blek.customerservice.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author blekg
 */
@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService{
    private CustomerRepository customerRepository;

    @Override
    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    @Override
    public PageElement<Customer> findCustomers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customers = customerRepository.findAll(pageable);
        PageElement<Customer> p = new PageElement<Customer>();
         p.setElements(customers.getContent());
        p.setTotalElements(customers.getTotalElements());
        p.setTotalPages(customers.getTotalPages());
        p.setSize(size);
        p.setCurrentPage(page);
        
        return p;
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("User with id="+id+"not found"));
    }

    @Override
    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }
}
