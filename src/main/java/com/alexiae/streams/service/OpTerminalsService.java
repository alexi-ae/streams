package com.alexiae.streams.service;

import com.alexiae.streams.entity.Account;
import com.alexiae.streams.entity.Transaction;
import com.alexiae.streams.repository.TransactionRepository;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpTerminalsService {

  @Autowired
  private TransactionRepository transactionRepository;

  public Set<String> getAccountNumbers() {
    return transactionRepository.findAll().stream()
        .map(t -> t.getAccount().getAccountNumber())  // Mapea cada transacción al número de cuenta
        .collect(Collectors.toSet());
  }

  public Double getTotalTransactionAmount(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .map(Transaction::getAmount)       // Mapea cada transacción a su amount
        .reduce(0.0, Double::sum);         // Reduce sumando todos los montos
  }

  public void printAllTransactions(Account account) {
    transactionRepository.findByAccount(account).stream()
        .forEach(System.out::println);     // Imprime cada transacción
  }

  public long getTransactionCount(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .count();                          // Cuenta las transacciones
  }
}
