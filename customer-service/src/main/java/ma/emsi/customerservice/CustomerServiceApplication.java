package ma.emsi.customerservice;

import ma.emsi.customerservice.config.GlobalConfig;
import ma.emsi.customerservice.entities.Customer;
import ma.emsi.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> customerRepository.saveAll(List.of(
                Customer.builder().firstName("Amine").lastName("Rh").email("amine.rh@gmail.com").build(),
                Customer.builder().firstName("Yassine").lastName("El").email("yassine.el@gmail.com").build(),
                Customer.builder().firstName("Sara").lastName("Kh").email("sara.kh@gmail.com").build(),
                Customer.builder().firstName("Hicham").lastName("Sm").email("hicham.sm@gmail.com").build()
            ));
    }
}
