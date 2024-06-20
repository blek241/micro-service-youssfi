package com.blek.accountservice;

import com.blek.accountservice.clients.CustomerServiceRestClient;
import com.blek.accountservice.entities.BankAccount;
import com.blek.accountservice.enums.AccountType;
import com.blek.accountservice.helpers.Formatter;
import com.blek.accountservice.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Currency;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountService bankAccountService, CustomerServiceRestClient customerServiceRestClient){
		return args -> {
				customerServiceRestClient.findAllCustomers().forEach(c -> {
					bankAccountService.addNewBankAccount(BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.balance(Formatter.formatNumber(Math.random()*7000))
							.accountType(AccountType.CURRENT_ACCOUNT)
							.createdAt(LocalDate.now())
							.currency("MAD")
							.customerId(c.getId())
							.build()
					);
					if (c.getId() % 3 == 0){
						bankAccountService.addNewBankAccount(BankAccount.builder()
								.accountId(UUID.randomUUID().toString())
								.balance(Formatter.formatNumber(Math.random()*700))
								.accountType(AccountType.SAVING_ACCOUNT)
								.createdAt(LocalDate.now())
								.currency("MAD")
								.customerId(c.getId())
								.build()
						);
					}
				});
		};
	}

}
