package com.alexiae.streams.controller;

import com.alexiae.streams.entity.Account;
import com.alexiae.streams.entity.Transaction;
import com.alexiae.streams.service.OpIntermediateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methods/intermediate")
public class MethodIntermediateController {

  @Autowired
  private OpIntermediateService intermediateService;

  // 1. Obtener montos de todas las transacciones (map)
  @GetMapping("/map/{accountId}/amounts")
  public ResponseEntity<List<Double>> getTransactionAmounts(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    List<Double> amounts = intermediateService.getTransactionAmounts(account);
    return ResponseEntity.ok(amounts);
  }

  // 2. Obtener transacciones con monto superior a 100 (filter)
  @GetMapping("/filter/{accountId}/high-value")
  public ResponseEntity<List<Transaction>> getHighValueTransactions(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    List<Transaction> transactions = intermediateService.getHighValueTransactions(account);
    return ResponseEntity.ok(transactions);
  }

  // 3. Obtener los montos de transacciones distintas (distinct)
  @GetMapping("/distinct/{accountId}/distinct-amounts")
  public ResponseEntity<List<Double>> getDistinctTransactionAmounts(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    List<Double> distinctAmounts = intermediateService.getDistinctTransactionAmounts(account);
    return ResponseEntity.ok(distinctAmounts);
  }

  // 4. Obtener transacciones ordenadas por monto de mayor a menor (sorted)
  @GetMapping("/sorted/{accountId}/sorted-transactions")
  public ResponseEntity<List<Transaction>> getSortedTransactions(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    List<Transaction> transactions = intermediateService.getSortedTransactions(account);
    return ResponseEntity.ok(transactions);
  }

  // 5. Obtener las primeras cinco transacciones (limit)
  @GetMapping("/limit/{accountId}/first-five")
  public ResponseEntity<List<Transaction>> getFirstFiveTransactions(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    List<Transaction> transactions = intermediateService.getFirstFiveTransactions(account);
    return ResponseEntity.ok(transactions);
  }

  // 6. Obtener transacciones después de las primeras cinco (skip)
  @GetMapping("/skip/{accountId}/after-first-five")
  public ResponseEntity<List<Transaction>> getTransactionsAfterFirstFive(
      @PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    List<Transaction> transactions = intermediateService.getTransactionsAfterFirstFive(account);
    return ResponseEntity.ok(transactions);
  }
}
