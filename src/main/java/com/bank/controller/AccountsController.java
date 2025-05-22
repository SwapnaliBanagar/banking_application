package com.bank.controller;

import com.bank.dto.AccountsDto;
import com.bank.entity.AccountsEntity;
import com.bank.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountsController {
    @Autowired
    AccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody AccountsDto accountsDto) {
        return accountsService.createAccount(accountsDto);
    }


    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountsEntity> getAccountDetails(@PathVariable long accountNumber) {
        return accountsService.getAccountDetails(accountNumber);
    }

    @GetMapping("/accountId/{account_Id}")
    public ResponseEntity<AccountsEntity> getAccountDetailsByAccountId(@PathVariable long account_Id) {
        return accountsService.getAccountDetailsByAccountId(account_Id);
    }

    @GetMapping("/customers/{bankName}")
    public ResponseEntity<List<AccountsEntity>> getAccountsByBankName(@PathVariable String bankName) {
        return accountsService.getAccountsByBankName(bankName);
    }




    @PutMapping("/update/{account_Id}")
    public ResponseEntity<String>updateByAccountId(@RequestBody AccountsDto accountsDto,@PathVariable long account_Id)
    {
        return accountsService.updateByAccountId(accountsDto,account_Id);
    }

    @PutMapping("/updateAccount/{accountNumber}")
    public ResponseEntity<String>updateByAccountNumber(@RequestBody AccountsDto accountsDto,@PathVariable long accountNumber)
    {
        return accountsService.updateByAccountNumber(accountsDto,accountNumber);
    }




    @DeleteMapping("delete/{accountNumber}")
    public ResponseEntity<String>deleteAccountByAccountNumber(@PathVariable long accountNumber)
    {
        return accountsService.deleteAccountByAccountNumber(accountNumber);
    }

}
