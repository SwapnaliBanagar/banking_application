package com.bank.controller;

import com.bank.dto.TransferDto;
import com.bank.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transfer")
public class TransferController {
@Autowired
    AccountsService accountsService;

    @PutMapping("/")
    public ResponseEntity<String>transferAmount(@RequestBody TransferDto transferDto)
    {
        return accountsService.transferAmount(transferDto);
    }
}
