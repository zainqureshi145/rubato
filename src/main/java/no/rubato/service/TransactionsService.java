package no.rubato.service;

import no.rubato.model.Transactions;
import no.rubato.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transactionsService")
public class TransactionsService {
    private TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionsService(TransactionsRepository transactionsRepository){
        this.transactionsRepository = transactionsRepository;
    }

    public Transactions findByIdTransaction(int idTransaction){
        return transactionsRepository.findByIdTransaction(idTransaction);
    }
    public Transactions findByTransactionAmount(int transactionAmount){
        return transactionsRepository.findByTransactionAmount(transactionAmount);
    }
    public Transactions findByTransactionStatus(String transactionStatus){
        return transactionsRepository.findByTransactionStatus(transactionStatus);
    }

    public void saveTransaction(Transactions transactions){
        transactionsRepository.save(transactions);
    }
}