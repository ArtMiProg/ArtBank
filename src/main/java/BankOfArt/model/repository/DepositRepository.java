package BankOfArt.model.repository;

import BankOfArt.model.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Integer> {
}
