/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.blek.customerservice.web;

import com.blek.customerservice.entities.Customer;
import com.blek.customerservice.helpers.PageElement;
import com.blek.customerservice.services.CustomerService;
import jakarta.websocket.server.PathParam;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author blekg
 */
@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {
    private CustomerService customerService;
    
    @GetMapping("")
    PageElement<Customer> index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return customerService.findCustomers(page, size);
    }

    @GetMapping("/all")
    List<Customer> indexAll(){
        return customerService.findAllCustomer();
    }
    
    @GetMapping("/{id}")
    public Customer getById(@PathVariable long id){
        return customerService.findCustomerById(id);
    }

}
