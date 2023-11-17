package ma.emsi.accountservice.clients;

import ma.emsi.accountservice.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    List<Customer> allCustomers();
}
