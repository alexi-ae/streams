package com.alexiae.streams.service;

import com.alexiae.streams.entity.Account;
import com.alexiae.streams.entity.Transaction;
import com.alexiae.streams.repository.TransactionRepository;
import java.util.OptionalDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpTerminalsSpecialService {

  @Autowired
  private TransactionRepository transactionRepository;

  public double getSumOfAmounts(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .mapToDouble(Transaction::getAmount)  // Mapea cada transacción a un DoubleStream
        .sum();                               // Suma todos los montos
  }

  public OptionalDouble getAverageAmount(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .mapToDouble(Transaction::getAmount)  // Mapea cada transacción a un DoubleStream
        .average();                           // Calcula el promedio
  }

  public OptionalDouble getMaxTransactionAmount(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .mapToDouble(Transaction::getAmount)  // Mapea cada transacción a un DoubleStream
        .max();                               // Obtiene el valor máximo
  }

  public OptionalDouble getMinTransactionAmount(Account account) {
    return transactionRepository.findByAccount(account).stream()
        .mapToDouble(Transaction::getAmount)  // Mapea cada transacción a un DoubleStream
        .min();                               // Obtiene el valor mínimo
  }
}
