/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.customerservice.services;

import com.blek.customerservice.entities.Customer;
import com.blek.customerservice.helpers.PageElement;
import java.util.List;

/**
 *
 * @author blekg
 */
public interface CustomerService {

    public Customer findCustomerById(long id);
    public Customer addNewCustomer(Customer customer);
    public PageElement<Customer> findCustomers(int page, int size);

    List<Customer> findAllCustomer();
}
