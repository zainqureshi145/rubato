package no.rubato.repository;

import no.rubato.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    Transactions findByIdTransaction(int idTransaction);
    Transactions findByTransactionAmount(int transactionAmount);
    Transactions findByTransactionStatus(String transactionStatus);
}
