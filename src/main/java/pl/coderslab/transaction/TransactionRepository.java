package pl.coderslab.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    @Query(nativeQuery = true, value = "select * from transaction group by typeOfTransaction where paidValue > 2000000")
//    List<Transaction> servicesDocumentation;
}
