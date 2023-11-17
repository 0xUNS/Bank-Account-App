package ma.emsi.accountservice;

import ma.emsi.accountservice.entities.BankAccount;
import ma.emsi.accountservice.enums.AccountType;
import ma.emsi.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
        return args -> bankAccountRepository.saveAll(List.of(
                BankAccount.builder().currency("MAD").balance(12000).createAt(LocalDate.now()).type(AccountType.SAVING_ACCOUNT).customerId(1L).build(),
                BankAccount.builder().currency("MAD").balance(7000).createAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT).customerId(3L).build(),
                BankAccount.builder().currency("MAD").balance(8500).createAt(LocalDate.now()).type(AccountType.SAVING_ACCOUNT).customerId(3L).build(),
                BankAccount.builder().currency("MAD").balance(16000).createAt(LocalDate.now()).type(AccountType.SAVING_ACCOUNT).customerId(2L).build(),
                BankAccount.builder().currency("MAD").balance(5000).createAt(LocalDate.now()).type(AccountType.CURRENT_ACCOUNT).customerId(1L).build()
        ));
    }
}
