package com.alexiae.streams.repository;

import com.alexiae.streams.entity.Account;
import com.alexiae.streams.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

  List<Transaction> findByAccount(Account account);

}
