package ma.emsi.accountservice.repositories;

import ma.emsi.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
