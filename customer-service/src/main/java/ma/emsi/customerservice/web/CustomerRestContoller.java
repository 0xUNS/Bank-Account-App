package ma.emsi.customerservice.web;

import lombok.AllArgsConstructor;
import ma.emsi.customerservice.entities.Customer;
import ma.emsi.customerservice.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerRestContoller {
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer customerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
