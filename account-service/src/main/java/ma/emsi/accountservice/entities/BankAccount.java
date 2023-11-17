package ma.emsi.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.emsi.accountservice.enums.AccountType;
import ma.emsi.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
