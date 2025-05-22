package com.bank.service;

import com.bank.dto.AccountsDto;
import com.bank.dto.BalanceDto;
import com.bank.dto.TransferDto;
import com.bank.entity.AccountsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface AccountsService {
    public ResponseEntity<String> createAccount(AccountsDto accountsDto);

    public ResponseEntity<AccountsEntity> getAccountDetails(long accountNumber);

    public ResponseEntity<AccountsEntity> getAccountDetailsByAccountId(long account_Id);

    public ResponseEntity<List<AccountsEntity>> getAccountsByBankName(String bankName);

    public ResponseEntity<String> updateByAccountId(AccountsDto accountsDto, long account_Id);

    public ResponseEntity<String> updateByAccountNumber(AccountsDto accountsDto, long accountNumber);

    public ResponseEntity<String> deleteAccountByAccountNumber(long accountNumber);


    //-------------------------------   Balance ---------------------------------------

    public ResponseEntity<String> checkBalanceByAccountNumber(long accountNumber);

    public ResponseEntity<String> addBalance(BalanceDto balanceDto, long accountNumber);

    public ResponseEntity<String> withdrawAmount(BalanceDto balanceDto, long accountNumber);


    //------------------------------------------- Transfer Amount ---------------------------------

    public ResponseEntity<String>transferAmount(TransferDto transferDto);




}
