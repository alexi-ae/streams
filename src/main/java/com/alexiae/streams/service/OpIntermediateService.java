package com.alexiae.streams.service;

import com.alexiae.streams.entity.Account;
import com.alexiae.streams.entity.Transaction;
import com.alexiae.streams.repository.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpIntermediateService {

  @Autowired
  private TransactionRepository transactionRepository;

  public List<Double> getTransactionAmounts(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .map(Transaction::getAmount)     // Transforma cada transacción en su amount
        .toList();
  }

  public List<Transaction> getHighValueTransactions(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .filter(t -> t.getAmount() > 100)  // Filtra las transacciones con amount > 100
        .toList();
  }

  public List<Double> getDistinctTransactionAmounts(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .map(Transaction::getAmount)      // Mapea las transacciones a sus montos
        .distinct()                       // Elimina los montos duplicados
        .toList();
  }

  public List<Transaction> getSortedTransactions(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .sorted(
            (t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))  // Ordena de mayor a menor
        .toList();
  }

  public List<Transaction> getFirstFiveTransactions(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .limit(5)     // Limita a las primeras 5 transacciones
        .toList();
  }

  public List<Transaction> getTransactionsAfterFirstFive(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .skip(5)      // Omite las primeras 5 transacciones
        .toList();
  }
}