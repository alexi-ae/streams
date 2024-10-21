package com.alexiae.streams.service;

import com.alexiae.streams.entity.Account;
import com.alexiae.streams.entity.Customer;
import com.alexiae.streams.entity.Transaction;
import com.alexiae.streams.repository.AccountRepository;
import com.alexiae.streams.repository.CustomerRepository;
import com.alexiae.streams.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoaderService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private TransactionRepository transactionRepository;

  @PostConstruct
  public void loadData() {
    // Crea algunos clientes
    Customer customer1 = new Customer();
    customerRepository.save(customer1); // Guarda el cliente en la base de datos

    Customer customer2 = new Customer();
    customerRepository.save(customer2); // Guarda otro cliente

    // Crea cuentas para los clientes
    Account account1 = new Account();
    account1.setAccountNumber("123456789");
    account1.setCustomer(customer1);
    accountRepository.save(account1); // Guarda la cuenta en la base de datos

    Account account2 = new Account();
    account2.setAccountNumber("987654321");
    account2.setCustomer(customer2);
    accountRepository.save(account2); // Guarda otra cuenta

    // Crea transacciones para las cuentas
    Transaction transaction1 = new Transaction();
    transaction1.setAmount(50.0);
    transaction1.setStatus("COMPLETED");
    transaction1.setAccount(account1);
    transactionRepository.save(transaction1); // Guarda la transacción en la base de datos

    Transaction transaction2 = new Transaction();
    transaction2.setAmount(100.0);
    transaction2.setStatus("PENDING");
    transaction2.setAccount(account2);
    transactionRepository.save(transaction2); // Guarda otra transacción

  }
}
