package com.blek.accountservice.clients;

import com.blek.models.CustomerDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    CustomerDTO findCustomerById(@PathVariable long id);

    @GetMapping("/customers/all")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultAllCustomers")
    List<CustomerDTO> findAllCustomers();

    default List<CustomerDTO> getDefaultAllCustomers(Exception e){
        return List.of();
    }

    default CustomerDTO getDefaultCustomer(long id, Exception exception){

        return CustomerDTO.builder()
                .id(id)
                .firstname("Not available")
                .lastname("Not available")
                .email("Not available")
                .build();
    }
}
