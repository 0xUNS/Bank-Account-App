package ma.emsi.accountservice;

import ma.emsi.accountservice.clients.CustomerRestClient;
import ma.emsi.accountservice.entities.BankAccount;
import ma.emsi.accountservice.enums.AccountType;
import ma.emsi.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        return args -> customerRestClient.allCustomers().forEach(customer ->
                        bankAccountRepository.saveAll(List.of(
                                BankAccount.builder().currency("MAD").balance(Math.random()*10000).createAt(LocalDate.now()).type(AccountType.SAVING_ACCOUNT).customerId(customer.getId()).build(),
                                BankAccount.builder().currency("MAD").balance(Math.random()*10000).createAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT).customerId(customer.getId()).build(),
                                BankAccount.builder().currency("MAD").balance(Math.random()*10000).createAt(LocalDate.now()).type(AccountType.SAVING_ACCOUNT).customerId(customer.getId()).build()
                        ))
                );
    }
}
