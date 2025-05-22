package com.bank.controller;

import com.bank.dto.BalanceDto;
import com.bank.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/balance")
public class BalanceController {
    @Autowired
    AccountsService accountsService;

    @GetMapping("/checkBalance/{accountNumber}")
    public ResponseEntity<String> checkBalanceByAccountNumber(@PathVariable long accountNumber) {
        return accountsService.checkBalanceByAccountNumber(accountNumber);
    }


    @PutMapping("/addBalance/{accountNumber}")
    public ResponseEntity<String> addBalance(@RequestBody BalanceDto balanceDto, @PathVariable long accountNumber) {
        return accountsService.addBalance(balanceDto, accountNumber);
    }

    @PutMapping("/withdraw/{accountNumber}")
    public ResponseEntity<String> withdrawAmount(@RequestBody BalanceDto balanceDto, @PathVariable long accountNumber) {
        return accountsService.withdrawAmount(balanceDto, accountNumber);
    }
}
