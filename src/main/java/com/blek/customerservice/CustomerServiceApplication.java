package com.blek.customerservice;

import com.blek.customerservice.entities.Customer;
import com.blek.customerservice.services.CustomerService;
import com.github.javafaker.Faker;
import java.util.Locale;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
        
        @Bean
        CommandLineRunner commandLineRunner(CustomerService customerService){
            
            Faker faker = new Faker(new Locale("en"));
            return args -> {
                for(int i=0; i<20; i++){
                    customerService.addNewCustomer(Customer.builder()
                            .firstname(faker.name().firstName())
                            .lastname(faker.name().lastName())
                            .email(faker.internet().emailAddress())
                            .build());
                }
            };
        }

}
