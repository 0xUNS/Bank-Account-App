package ma.emsi.accountservice.web;

import lombok.AllArgsConstructor;
import ma.emsi.accountservice.clients.CustomerRestClient;
import ma.emsi.accountservice.entities.BankAccount;
import ma.emsi.accountservice.model.Customer;
import ma.emsi.accountservice.repositories.BankAccountRepository;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
@EnableFeignClients
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    @GetMapping
    public List<BankAccount> bankAccounts() {
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(bankAccount ->
                bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()))
        );
        return accountList;
    }

    @GetMapping("/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
