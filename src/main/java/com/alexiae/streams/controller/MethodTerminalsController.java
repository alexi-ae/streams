package com.alexiae.streams.controller;

import com.alexiae.streams.entity.Account;
import com.alexiae.streams.service.OpIntermediateService;
import com.alexiae.streams.service.OpTerminalsService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methods/terminals")
public class MethodTerminalsController {

  @Autowired
  private OpTerminalsService opTerminalsService;

  @GetMapping("/collect/account/numbers")
  public Set<String> getAccountNumbers() {
    return opTerminalsService
        .getAccountNumbers();
  }

  @GetMapping("/reduce/account/{accountId}/total-amount")
  public Double getTotalTransactionAmount(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    return opTerminalsService
        .getTotalTransactionAmount(account);
  }

  @GetMapping("/foreach/account/{accountId}/print")
  public void printAllTransactions(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    opTerminalsService
        .printAllTransactions(account);
  }

  @GetMapping("/count/account/{accountId}/count")
  public long getTransactionCount(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    return opTerminalsService
        .getTransactionCount(account);
  }
}
