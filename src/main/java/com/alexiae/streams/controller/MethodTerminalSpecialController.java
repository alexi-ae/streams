package com.alexiae.streams.controller;

import com.alexiae.streams.entity.Account;
import com.alexiae.streams.service.OpTerminalsSpecialService;
import java.util.OptionalDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methods/terminals/special")
public class MethodTerminalSpecialController {

  @Autowired
  private OpTerminalsSpecialService opTerminalsSpecialService;

  @GetMapping("/account/{accountId}/sum")
  public double getSumOfAmounts(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    return opTerminalsSpecialService
        .getSumOfAmounts(account);
  }

  @GetMapping("/account/{accountId}/average")
  public OptionalDouble getAverageAmount(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    return opTerminalsSpecialService
        .getAverageAmount(account);
  }

  @GetMapping("/account/{accountId}/max")
  public OptionalDouble getMaxTransactionAmount(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    return opTerminalsSpecialService
        .getMaxTransactionAmount(account);
  }

  @GetMapping("/account/{accountId}/min")
  public OptionalDouble getMinTransactionAmount(@PathVariable Long accountId) {
    Account account = new Account();
    account.setId(accountId);
    return opTerminalsSpecialService
        .getMinTransactionAmount(account);
  }
}
